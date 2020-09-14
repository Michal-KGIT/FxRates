package lt.michalkropa.fxrates.controller;

import lombok.RequiredArgsConstructor;
import lt.michalkropa.fxrates.dto.ConversionModel;
import lt.michalkropa.fxrates.dto.ConversionResponseModel;
import lt.michalkropa.fxrates.dto.FxRate;
import lt.michalkropa.fxrates.service.ConvertingService;
import lt.michalkropa.fxrates.service.FxRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FxRateController {
    private final FxRateService fxRateService;
    private final ConvertingService convertingService;

    @GetMapping("/fx-rates")
    public String fxRates(Model model) {
        List<FxRate> fxRates = fxRateService.getAllFxRatesByDate(LocalDate.now());
        model.addAttribute("fxRates", fxRates);
        return "fx_rates";
    }

    @GetMapping("/statistics")
    public String statistics() {
        return "statistics";
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        List<FxRate> fxRates = fxRateService.getAllFxRatesByDate(LocalDate.now());
        model.addAttribute("fxRates", fxRates);
        model.addAttribute("conversionModel", new ConversionModel());
        return "calculator";
    }

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponseModel> convert(
            @ModelAttribute("conversionModel") ConversionModel conversionModel, Model model) {
        model.addAttribute("conversionModel", conversionModel);
        BigDecimal convertedValue = convertingService.convert(conversionModel);
        return ResponseEntity.ok(new ConversionResponseModel(convertedValue));
    }
}
