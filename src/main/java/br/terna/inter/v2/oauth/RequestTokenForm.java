package br.terna.inter.v2.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
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
}
