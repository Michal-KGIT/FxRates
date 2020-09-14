package lt.michalkropa.fxrates.config;

import lt.michalkropa.fxrates.client.FxRateClient;
import lt.michalkropa.fxrates.entity.FxRateEntity;
import lt.michalkropa.fxrates.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Autowired
    private FxRateClient fxRateClient;

    @Autowired
    private FxRateRepository fxRateRepository;

    @Scheduled(fixedRate = 86400000)
    public void getAndSaveFxRates() {
        List<FxRateEntity> result = new ArrayList<>();
        Element fxRates = (Element) fxRateClient.getCurrentFxRates().getGetCurrentFxRatesResult().getContent().get(0);
        NodeList nodeList = fxRates.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getLocalName().equals("CcyAmt")
                    && !node.getFirstChild().getFirstChild().getNodeValue().equals("EUR")) {
                FxRateEntity fxRateEntity = new FxRateEntity();
                fxRateEntity.setDate(LocalDate.now());
                fxRateEntity.setCurrency(node.getFirstChild().getFirstChild().getNodeValue());
                fxRateEntity.setAmount(new BigDecimal(node.getLastChild().getFirstChild().getNodeValue()));
                result.add(fxRateEntity);
            }
        }

        fxRateRepository.saveAll(result);
    }
}
