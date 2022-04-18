package br.terna.inter.v2.boleto;

import br.terna.inter.util.JsonUtils;
import br.terna.inter.v1.boleto.download.Storage;
import br.terna.inter.v2.HttpInterConnectionV2;
import br.terna.inter.v2.boleto.baixa.CodigoBaixa;
import br.terna.inter.v2.boleto.consulta.Content;
import br.terna.inter.v2.boleto.consulta.FiltrarDataPor;
import br.terna.inter.v2.boleto.consulta.FiltrarPor;
import br.terna.inter.v2.boleto.consulta.Page;
import br.terna.inter.v2.boleto.emissao.Emissao;
import br.terna.inter.v2.boleto.emissao.EmissaoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public record Boleto(HttpInterConnectionV2 con) {
    private static final Logger log = LoggerFactory.getLogger(Boleto.class);

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final static String CONSULTA_URL = "https://cdpj.partners.bancointer.com.br/cobranca/v2/boletos?";

    private final static String EMITIR_URL = "https://cdpj.partners.bancointer.com.br/cobranca/v2/boletos";

    private final static String BAIXAR_URL = "https://cdpj.partners.bancointer.com.br/cobranca/v2/boletos/%s/cancelar";

    private final static String PDF_URL = "https://cdpj.partners.bancointer.com.br/cobranca/v2/boletos/%s/pdf";

    public List<Content> consultar(FiltrarPor filtrarPor, FiltrarDataPor filtrarDataPor, LocalDate dataInicial, LocalDate dataFinal, Integer page, Integer pageSize) throws IOException, URISyntaxException, InterruptedException {
        List<Content> res = new ArrayList<>();
        Page page1 = consultarPagina(filtrarPor, filtrarDataPor, dataInicial, dataFinal, page, pageSize);
        res.addAll(page1.getContent());
        Integer pageIndex = 1;
        while (!page1.getLast()) {
            page1 = consultarPagina(filtrarPor, filtrarDataPor, dataInicial, dataFinal, pageIndex, pageSize);
            res.addAll(page1.getContent());
            pageIndex++;
        }
        return res;
    }

    public Page consultarPagina(FiltrarPor filtrarPor, FiltrarDataPor filtrarDataPor, LocalDate dataInicial, LocalDate dataFinal, Integer page, Integer pageSize) throws IOException, URISyntaxException, InterruptedException {
        List<String> filtros = new ArrayList<>();
        if (filtrarPor != null) {
            filtros.add("filtrarPor=" + filtrarPor.name());
        }

        if (filtrarDataPor != null) {
            filtros.add("filtrarDataPor=" + filtrarDataPor.name());
        }

        filtros.add("dataInicial=" + DATE_TIME_FORMATTER.format(dataInicial));
        filtros.add("dataFinal=" + DATE_TIME_FORMATTER.format(dataFinal));
        if (page != null) {
            filtros.add("page=" + page);
        }
        if (pageSize != null) {
            filtros.add("size=" + pageSize);
        }

        String query = filtros.stream().collect(Collectors.joining("&"));
        String url = CONSULTA_URL + query;
//        log.info("Consultando Link: " + url);

        HttpRequest request = con.newRequest().uri(new URI(url)).build();
        HttpResponse<String> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return con.jsonResponse(response, Page.class);
    }

    public EmissaoResponse emitirBoleto(Emissao emissao) throws Exception {
        log.info("Emitindo Boleto V2: " + emissao.toString() + "Pagador " + emissao.getPagador().toString());
        log.info("Pagador: " + emissao.getPagador().toString());
        String bodyStr = JsonUtils.mapper.writeValueAsString(emissao);

        HttpRequest request = con.newRequest()
                .POST(HttpRequest.BodyPublishers.ofString(bodyStr))
                .header("Content-Type", "application/json")
                .uri(new URI(EMITIR_URL)).build();

        HttpResponse<String> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        con.checkBadRequest(response);
        return con.jsonResponse(response, EmissaoResponse.class);
    }

    public void baixar(String nossoNumero, CodigoBaixa codigoBaixa) throws Exception {
        String url = String.format(BAIXAR_URL, nossoNumero);
        Map<String, String> body = new HashMap<>();
        body.put("codigoBaixa", codigoBaixa.name());
        HttpRequest request = con.newRequest()
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtils.mapper.writeValueAsString(body)))
                .header("Content-Type", "application/json")
                .uri(new URI(url)).build();

        HttpResponse<String> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        con.checkBadRequest(response);
    }

    public byte[] download(String nossoNumero, boolean useCache) throws Exception {
        if (useCache) {
            byte[] nossoNumero1 = Storage.get().getNossoNumero(nossoNumero);
            if (nossoNumero1 != null) {
                return nossoNumero1;
            }
        }
        log.info("Fazendo download do boleto " + nossoNumero);
        String url = String.format(PDF_URL, nossoNumero);
        HttpRequest request = con.newRequest().GET().uri(new URI(url)).build();
        HttpResponse<byte[]> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofByteArray());
        byte[] content = Base64.getDecoder().decode(response.body());
        Storage.get().gravar(nossoNumero, content);
        return content;
    }

    public void setLido(String nossoNumero) {
        Storage.get().setLido(nossoNumero);
    }
}
