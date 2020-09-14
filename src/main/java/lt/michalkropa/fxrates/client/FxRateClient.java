package lt.michalkropa.fxrates.client;

import lt.michalkropa.fxrates.client.gen.GetCurrentFxRates;
import lt.michalkropa.fxrates.client.gen.GetCurrentFxRatesResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class FxRateClient extends WebServiceGatewaySupport {
    public GetCurrentFxRatesResponse getCurrentFxRates() {
        GetCurrentFxRates request = new GetCurrentFxRates();
        request.setTp("eu");
        return (GetCurrentFxRatesResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.lb.lt/webservices/fxrates/fxrates.asmx",
                request,
                new SoapActionCallback("http://www.lb.lt/WebServices/FxRates/getCurrentFxRates"));
    }
}
