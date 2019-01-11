package de.eckey.tradfrj.request;

import org.eclipse.californium.core.coap.CoAP.Code;
import org.junit.jupiter.api.Assertions;

import de.eckey.tradfrj.service.CoapRequest;

public class RequestAssertions {

	public static void assertRequest(CoapRequest request, Code code, String path, String payload) {
		Assertions.assertEquals(code, request.getCode());
		Assertions.assertEquals(path, request.getPath());
		Assertions.assertEquals(payload, request.getPayload());
	}

	public static void assertRequest(TradfrjRequestBuilder<?> builder, Code code, String path, String payload) {
		CoapRequest request = builder.getRequest().getRequest();
		assertRequest(request, code, path, payload);
	}
}
