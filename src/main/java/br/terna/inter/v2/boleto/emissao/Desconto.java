package br.terna.inter.v2.boleto.emissao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Desconto {
    @Builder.Default
    private CodigoDesconto codigoDesconto = CodigoDesconto.NAOTEMDESCONTO;
    @Builder.Default
    private BigDecimal taxa = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

}
