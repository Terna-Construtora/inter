package br.terna.inter;

import br.terna.inter.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyStore;

public class HttpInterConnection {

    private HttpClient httpClient;

    public HttpInterConnection(String p12Password, InputStream p12Is) throws Exception {
        httpClient = HttpClient.newBuilder().sslContext(createSslCustomContext(p12Is, p12Password)).build();
    }

    public HttpRequest.Builder newRequest() {
        return addHeader(HttpRequest.newBuilder());
    }

    public void checkBadRequest(HttpResponse<String> response) {
        if (response.statusCode() == 400)
            throw new BadRequestException(response.body());
    }

    public <T> T jsonResponse(HttpResponse<String> response, Class<T> clazz) throws JsonProcessingException {
        return JsonUtils.mapper.readValue(response.body(), clazz);
    }

    protected HttpRequest.Builder addHeader(HttpRequest.Builder requestBuilder) {
        return requestBuilder;
    }

    private SSLContext createSslCustomContext(InputStream p12Is, String p12Password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        keyStore.load(p12Is, p12Password.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, p12Password.toCharArray());

        sslContext.init(kmf.getKeyManagers(), null, null);
        return sslContext;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }
}
