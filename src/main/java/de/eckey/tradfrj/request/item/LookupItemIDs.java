package de.eckey.tradfrj.request.item;

import java.util.Collection;
import java.util.List;

import org.eclipse.californium.core.coap.CoAP;

import de.eckey.tradfrj.request.TradfrjRequest;
import de.eckey.tradfrj.service.CoapRequest;
import de.eckey.tradfrj.service.CoapResponse;

public abstract class LookupItemIDs implements TradfrjRequest<Collection<Double>> {

	private String path;

	public LookupItemIDs(String path) {
		this.path = path;
	}

	@Override
	public CoapRequest getRequest() {
		return new CoapRequest(path, CoAP.Code.GET);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Double> handleResponse(CoapResponse response) {
		return (List<Double>) gson().fromJson(response.getPayload(), List.class);
	}
}
