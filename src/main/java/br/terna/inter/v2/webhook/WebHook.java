package br.terna.inter.v2.webhook;

import br.terna.inter.util.JsonUtils;
import br.terna.inter.v2.HttpInterConnectionV2;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public record WebHook(HttpInterConnectionV2 con) {
    private static final String URL = "https://cdpj.partners.bancointer.com.br/cobranca/v2/boletos/webhook";

    private static class CreateForm {
        private String webhookUrl;

        public CreateForm(String webhookUrl) {
            this.webhookUrl = webhookUrl;
        }

        public String getWebhookUrl() {
            return webhookUrl;
        }

        public void setWebhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
        }
    }

    public boolean create(String callBackUrl) throws Exception {
        String bodyStr = JsonUtils.mapper.writeValueAsString(new CreateForm(callBackUrl));

        HttpRequest request = con.newRequest()
                .PUT(HttpRequest.BodyPublishers.ofString(bodyStr))
                .uri(new URI(URL)).build();

        HttpResponse<Void> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.discarding());

        return response.statusCode() == 204;
    }

    public Map<String, Object> read() throws Exception {
        HttpRequest request = con.newRequest().uri(new URI(URL)).build();
        HttpResponse<String> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return con.jsonResponse(response, Map.class);
    }

    public boolean excluir() throws Exception {
        HttpRequest request = con.newRequest().uri(new URI(URL)).DELETE().build();
        HttpResponse<Void> response = con.getHttpClient().send(request, HttpResponse.BodyHandlers.discarding());
        return response.statusCode() == 204;
    }
}
