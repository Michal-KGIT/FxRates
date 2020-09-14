package lt.michalkropa.fxrates.factory;

import lt.michalkropa.fxrates.dto.FxRate;
import lt.michalkropa.fxrates.entity.FxRateEntity;
import org.springframework.stereotype.Component;

@Component
public class FxRateFactory {
    public FxRate toDto(FxRateEntity entity) {
        FxRate dto = new FxRate();
        dto.setId(entity.getId());
        dto.setCurrency(entity.getCurrency());
        dto.setAmount(entity.getAmount());
        dto.setDate(entity.getDate());
        return dto;
    }
}
