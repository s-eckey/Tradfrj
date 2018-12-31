package de.eckey.tradfrj.service;

import org.eclipse.californium.core.coap.CoAP.Code;

public class CoapRequest {

	private final String path;
	private final String payload;
	private final Code code;

	public CoapRequest(String path, Code code) {
		this(path, code, null);
	}

	public CoapRequest(String path, Code code, String payload) {
		this.path = path;
		this.code = code;
		this.payload = payload;
	}

	public String getPath() {
		return path;
	}

	public String getPayload() {
		return payload;
	}

	public Code getCode() {
		return code;
	}

}
