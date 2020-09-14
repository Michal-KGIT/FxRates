package lt.michalkropa.fxrates.config;

import lt.michalkropa.fxrates.client.FxRateClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.ClientHttpRequestMessageSender;

@Configuration
public class FxRateClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("lt.michalkropa.fxrates.client.gen");
        return marshaller;
    }

    @Bean
    public FxRateClient fxRateClient(Jaxb2Marshaller marshaller) {
        FxRateClient client = new FxRateClient();
        client.setDefaultUri("https://www.lb.lt/webservices/fxrates/fxrates.asmx");
        client.setMarshaller(marshaller);
        client.setMessageSender(new ClientHttpRequestMessageSender());
        client.setUnmarshaller(marshaller);
        return client;
    }
}
