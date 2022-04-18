package br.terna.inter.v2.oauth;

public enum Scope {
    EXTRATO_READ("extrato.read"),
    BOLETO_READ("boleto-cobranca.read"),
    BOLETO_WRITE("boleto-cobranca.write");

    private String permissao;

    Scope(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
}
