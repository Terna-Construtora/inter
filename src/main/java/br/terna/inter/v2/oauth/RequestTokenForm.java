package br.terna.inter.v2.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class RequestTokenForm {
    @JsonProperty("client_id")
    private String clienteId;

    @JsonProperty("client_secret")
    private String clienteSecret;

    @JsonProperty("grant_type")
    private String grant_type = "grant_type";

    private String scopes;

    public RequestTokenForm(String clienteId, String clienteSecret, List<Scope> scopes) {
        this.clienteId = clienteId;
        this.clienteSecret = clienteSecret;
        this.scopes = scopes.stream().map(scope -> scope.getPermissao()).collect(Collectors.joining(" "));
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteSecret() {
        return clienteSecret;
    }

    public void setClienteSecret(String clienteSecret) {
        this.clienteSecret = clienteSecret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }
}
