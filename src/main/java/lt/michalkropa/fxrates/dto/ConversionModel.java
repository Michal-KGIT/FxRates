package lt.michalkropa.fxrates.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConversionModel {
    private String sourceCurrency;
    private BigDecimal sourceAmount;
    private String targetCurrency;
    private BigDecimal targetAmount;
}
