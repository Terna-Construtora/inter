package br.terna.inter.v1.boleto.emissao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
// @Slf4j
public class Multa {
    @Builder.Default
    private CodigoMulta codigoMulta = CodigoMulta.NAOTEMMULTA;
    @Builder.Default
    private BigDecimal  taxa        = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal  valor       = BigDecimal.ZERO;
    private LocalDate   data;

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
}
