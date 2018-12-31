package de.eckey.tradfrj.request;

import com.google.gson.Gson;

import de.eckey.tradfrj.service.CoapRequest;
import de.eckey.tradfrj.service.CoapResponse;

public interface TradfrjRequest<T> {

	CoapRequest getRequest();

	T handleResponse(CoapResponse response);

	default Gson gson() {
		return new Gson();
	}
}
