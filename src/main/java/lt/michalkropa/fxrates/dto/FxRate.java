package lt.michalkropa.fxrates.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FxRate {
    private Long id;
    private String currency;
    private BigDecimal amount;
    private LocalDate date;
}
