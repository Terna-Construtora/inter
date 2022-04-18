package br.terna.inter.v2;

import br.terna.inter.HttpInterConnection;
import br.terna.inter.v2.oauth.Token;

import java.io.InputStream;
import java.net.http.HttpRequest;

public class HttpInterConnectionV2 extends HttpInterConnection {

    private Token token;

    public HttpInterConnectionV2(String p12Password, InputStream p12Is) throws Exception {
        super(p12Password, p12Is);
    }

    @Override
    protected HttpRequest.Builder addHeader(HttpRequest.Builder requestBuilder) {
        return requestBuilder.header("Authorization", "Bearer " + getAccessToken());
    }

    public String getAccessToken() {
        return null;
    }

    public Token getToken() {
        if (token == null || token.isExpired()) return null;
        return token;
    }
}
