package br.terna.inter.v1.boleto.consulta;

public class Summary {
    private SummaryItem recebidos;
    private SummaryItem previstos;
    private SummaryItem baixados;
    private SummaryItem expirados;

    public SummaryItem getRecebidos() {
        return recebidos;
    }

    public void setRecebidos(SummaryItem recebidos) {
        this.recebidos = recebidos;
    }

    public SummaryItem getPrevistos() {
        return previstos;
    }

    public void setPrevistos(SummaryItem previstos) {
        this.previstos = previstos;
    }

    public SummaryItem getBaixados() {
        return baixados;
    }

    public void setBaixados(SummaryItem baixados) {
        this.baixados = baixados;
    }

    public SummaryItem getExpirados() {
        return expirados;
    }

    public void setExpirados(SummaryItem expirados) {
        this.expirados = expirados;
    }
}
