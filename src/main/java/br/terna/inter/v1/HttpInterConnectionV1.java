package br.terna.inter.v1;

import br.terna.inter.HttpInterConnection;

import java.io.InputStream;
import java.net.http.HttpRequest;

public class HttpInterConnectionV1 extends HttpInterConnection {
    private final String numeroConta;

    public HttpInterConnectionV1(String p12Password, InputStream p12Is, String numeroConta) throws Exception {
        super(p12Password, p12Is);
        this.numeroConta = numeroConta;
    }

    @Override
    protected HttpRequest.Builder addHeader(HttpRequest.Builder requestBuilder) {
        return requestBuilder.header("x-inter-conta-corrente", numeroConta);
    }
}
