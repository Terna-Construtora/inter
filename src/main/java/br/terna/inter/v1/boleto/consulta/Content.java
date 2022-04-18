package br.terna.inter.v1.boleto.consulta;

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

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public void setCnpjCpfSacado(String cnpjCpfSacado) {
        this.cnpjCpfSacado = cnpjCpfSacado;
    }

    public void setNomeSacado(String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setDataPagtoBaixa(LocalDate dataPagtoBaixa) {
        this.dataPagtoBaixa = dataPagtoBaixa;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public void setValorTotalRecebimento(BigDecimal valorTotalRecebimento) {
        this.valorTotalRecebimento = valorTotalRecebimento;
    }

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
