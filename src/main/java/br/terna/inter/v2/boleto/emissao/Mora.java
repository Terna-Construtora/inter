package br.terna.inter.v2.boleto.emissao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
// @Slf4j
public class Mora {
    @Builder.Default
    private CodigoMora codigoMora = CodigoMora.ISENTO;
    @Builder.Default
    private BigDecimal taxa       = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal valor      = BigDecimal.ZERO;
    private LocalDate  data;

    // public boolean isValid() {
    //     if (codigoMora != CodigoMora.ISENTO) {
    //         if (data == null) {
    //             log.error("Data é obrigatório na mora");
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
