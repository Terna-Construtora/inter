package br.terna.inter.v2.boleto.emissao;

import lombok.Data;

@Data
public class EmissaoResponse {
    private String seuNumero;
    private String nossoNumero;
    private String codigoBarras;
    private String linhaDigitavel;
}
