package br.terna.inter.v2.boleto.emissao;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Desconto {
    private CodigoDesconto codigoDesconto = CodigoDesconto.NAOTEMDESCONTO;
    private BigDecimal taxa = BigDecimal.ZERO;
    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

    public CodigoDesconto getCodigoDesconto() {
        return codigoDesconto;
    }

    public void setCodigoDesconto(CodigoDesconto codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
