package lt.michalkropa.fxrates.service;

import lombok.RequiredArgsConstructor;
import lt.michalkropa.fxrates.dto.ConversionModel;
import lt.michalkropa.fxrates.entity.FxRateEntity;
import lt.michalkropa.fxrates.repository.FxRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ConvertingService {
    private final FxRateRepository fxRateRepository;

    public BigDecimal convert(ConversionModel conversionModel) {
        FxRateEntity targetFxRate = fxRateRepository.findByCurrency(conversionModel.getTargetCurrency());
        return conversionModel.getSourceAmount().multiply(targetFxRate.getAmount());
    }
}
