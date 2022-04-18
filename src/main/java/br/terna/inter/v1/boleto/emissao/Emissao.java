package br.terna.inter.v1.boleto.emissao;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Emissao {
    private String cnpjCPFBeneficiario;

    private BigDecimal valorNominal;

    private BigDecimal valorAbatimento;

    @Builder.Default
    private NumDiasAgenda numDiasAgenda = NumDiasAgenda.SESSENTA;

    private LocalDate dataVencimento;

    private String dataLimite;

    private String seuNumero;

    private LocalDate dataEmissao;

    private Pagador pagador;

    private Mensagem mensagem;

    @Builder.Default
    private Desconto desconto1 = Desconto.builder().build();

    @Builder.Default
    private Desconto desconto2 = Desconto.builder().build();

    @Builder.Default
    private Desconto desconto3 = Desconto.builder().build();

    @Builder.Default
    private Multa multa = Multa.builder().build();

    @Builder.Default
    private Mora mora = Mora.builder().build();

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

}
