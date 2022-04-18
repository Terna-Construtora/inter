package br.terna.inter.v2.boleto.emissao;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Mora {
    private CodigoMora codigoMora = CodigoMora.ISENTO;
    private BigDecimal taxa = BigDecimal.ZERO;
    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

    // public boolean isValid() {
    //     if (codigoMora != CodigoMora.ISENTO) {
    //         if (data == null) {
    //             log.error("Data é obrigatório na mora");
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    public CodigoMora getCodigoMora() {
        return codigoMora;
    }

    public void setCodigoMora(CodigoMora codigoMora) {
        this.codigoMora = codigoMora;
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
