package lt.michalkropa.fxrates.service;

import lombok.RequiredArgsConstructor;
import lt.michalkropa.fxrates.dto.FxRate;
import lt.michalkropa.fxrates.entity.FxRateEntity;
import lt.michalkropa.fxrates.factory.FxRateFactory;
import lt.michalkropa.fxrates.repository.FxRateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FxRateService {
    private final FxRateFactory fxRateFactory;
    private final FxRateRepository fxRateRepository;

    public List<FxRate> getAllFxRatesByDate(LocalDate date) {
        List<FxRateEntity> fxRates = fxRateRepository.findAllByDateEquals(date);
        return toFxRates(fxRates);
    }

    private List<FxRate> toFxRates(List<FxRateEntity> fxRates) {
        List<FxRate> result = new ArrayList<>();
        for (FxRateEntity fxRate : fxRates) {
            result.add(fxRateFactory.toDto(fxRate));
        }

        return result;
    }
}
