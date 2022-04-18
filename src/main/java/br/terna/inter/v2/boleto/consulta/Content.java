package br.terna.inter.v2.boleto.consulta;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
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

}
