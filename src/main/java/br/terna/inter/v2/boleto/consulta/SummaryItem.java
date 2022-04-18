package br.terna.inter.v2.boleto.consulta;

import java.math.BigDecimal;

public class SummaryItem {
    private Integer    quantidade;
    private BigDecimal valor;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
