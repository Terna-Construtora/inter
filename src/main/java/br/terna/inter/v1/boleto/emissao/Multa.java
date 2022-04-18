package br.terna.inter.v1.boleto.emissao;

import java.math.BigDecimal;
import java.time.LocalDate;

// @Slf4j
public class Multa {

    private CodigoMulta codigoMulta = CodigoMulta.NAOTEMMULTA;

    private BigDecimal taxa = BigDecimal.ZERO;
    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

    // @JsonIgnore
    // public boolean isValid() {
    //     if (codigoMulta != CodigoMulta.NAOTEMMULTA) {
    //         if (data == null) {
    //             log.error("Data é obrigatório na multa");
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    public CodigoMulta getCodigoMulta() {
        return codigoMulta;
    }

    public void setCodigoMulta(CodigoMulta codigoMulta) {
        this.codigoMulta = codigoMulta;
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
