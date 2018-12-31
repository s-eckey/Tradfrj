package de.eckey.tradfrj.service;

import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.Response;

public class CoapResponse {

	private final ResponseCode responseCode;
	private final String payload;

	private CoapResponse(ResponseCode responseCode, String payload) {
		this.responseCode = responseCode;
		this.payload = payload;
	}

	public static CoapResponse from(Response response) {
		return new CoapResponse(response.getCode(), response.getPayloadString());
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public String getPayload() {
		return payload;
	}
}
