package br.terna.inter.v2.extrato;

import br.terna.inter.v2.HttpInterConnectionV2;
import lombok.Data;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record Extrato(HttpInterConnectionV2 con) {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String URL = "https://cdpj.partners.bancointer.com.br/banking/v2/extrato?dataInicio=%s&dataFim=%";
    private static final String URL_PDF = "https://cdpj.partners.bancointer.com.br/banking/v2/extrato/exportar?dataInicio=%s&dataFim=%";

    @Data
    private static class ExtratoResponse {
        List<LinhaExtrato> transacoes;
    }

    public List<LinhaExtrato> getExtrato(LocalDate inicio, LocalDate fim) throws Exception {
        String urlCompleta = String.format(URL, DATE_TIME_FORMATTER.format(inicio), DATE_TIME_FORMATTER.format(fim));

        HttpRequest request = con.newRequest().uri(new URI(urlCompleta)).build();
        HttpResponse<String> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return con.jsonResponse(response, ExtratoResponse.class).getTransacoes();
    }

    public byte[] getExtratoPdf(LocalDate inicio, LocalDate fim) throws Exception {
        String urlCompleta = String.format(URL_PDF, DATE_TIME_FORMATTER.format(inicio), DATE_TIME_FORMATTER.format(fim));

        HttpRequest request = con.newRequest().GET().uri(new URI(urlCompleta)).build();
        HttpResponse<byte[]> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofByteArray());
        return response.body();
    }
}
