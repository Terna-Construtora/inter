package br.terna.inter.v1.boleto.emissao;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emissao {
    private String cnpjCPFBeneficiario;

    private BigDecimal valorNominal;

    private BigDecimal valorAbatimento;

    private NumDiasAgenda numDiasAgenda = NumDiasAgenda.SESSENTA;

    private LocalDate dataVencimento;

    private String dataLimite;

    private String seuNumero;

    private LocalDate dataEmissao;

    private Pagador pagador;

    private Mensagem mensagem;

    private Desconto desconto1 = new Desconto();

    private Desconto desconto2 = new Desconto();

    private Desconto desconto3 = new Desconto();

    private Multa multa = new Multa();

    private Mora mora = new Mora();

    public String isValid() {
        if (StringUtils.isEmpty(getSeuNumero()))
            return "Seu_numero é necessário";
        if (StringUtils.isEmpty(cnpjCPFBeneficiario))
            return "cnpjCPFBeneficiario é necessário";
        if (valorNominal == null)
            return "valorNominal é necessário";
        if (dataEmissao == null)
            return "dataEmissao é necessário";
        if (dataVencimento == null)
            return "dataVencimento é necessário";
        if (dataVencimento.isBefore(LocalDate.now())) {
            return "dataVencimento deve ser maior que hoje";
        }
        return null;
    }

    public void addMensagem(String msg) {
        if (mensagem == null) {
            mensagem = new Mensagem();
        }
        mensagem.addLinha(msg);
    }

    public String getCnpjCPFBeneficiario() {
        return cnpjCPFBeneficiario;
    }

    public void setCnpjCPFBeneficiario(String cnpjCPFBeneficiario) {
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public BigDecimal getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(BigDecimal valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public NumDiasAgenda getNumDiasAgenda() {
        return numDiasAgenda;
    }

    public void setNumDiasAgenda(NumDiasAgenda numDiasAgenda) {
        this.numDiasAgenda = numDiasAgenda;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Desconto getDesconto1() {
        return desconto1;
    }

    public void setDesconto1(Desconto desconto1) {
        this.desconto1 = desconto1;
    }

    public Desconto getDesconto2() {
        return desconto2;
    }

    public void setDesconto2(Desconto desconto2) {
        this.desconto2 = desconto2;
    }

    public Desconto getDesconto3() {
        return desconto3;
    }

    public void setDesconto3(Desconto desconto3) {
        this.desconto3 = desconto3;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }
}
