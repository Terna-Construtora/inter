package br.terna.inter.v2.boleto.consulta;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Content {
    private String nossoNumero;
    private String seuNumero;
    private String cnpjCpfSacado;
    private String nomeSacado;
    //BAIXADO, EMABERTO, PAGO, VENCIDO
    private String situacao;
    private LocalDate dataPagtoBaixa;
    private LocalDate dataVencimento;
    private BigDecimal valorNominal;
    private String telefone;
    private String email;
    private LocalDate dataEmissao;
    private LocalDate dataLimite;
    private String linhaDigitavel;
    private BigDecimal valorJuros;
    private BigDecimal valorMulta;
    private BigDecimal valorTotalRecebimento;

    public String getNossoNumero() {
        return nossoNumero;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public String getCnpjCpfSacado() {
        return cnpjCpfSacado;
    }

    public String getNomeSacado() {
        return nomeSacado;
    }

    public String getSituacao() {
        return situacao;
    }

    public LocalDate getDataPagtoBaixa() {
        return dataPagtoBaixa;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public BigDecimal getValorMulta() {
        return valorMulta;
    }

    public BigDecimal getValorTotalRecebimento() {
        return valorTotalRecebimento;
    }
}
