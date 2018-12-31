package de.eckey.tradfrj.request.item;

import java.util.Optional;

import org.eclipse.californium.core.coap.CoAP;

import de.eckey.tradfrj.request.TradfrjRequest;
import de.eckey.tradfrj.service.CoapRequest;
import de.eckey.tradfrj.service.CoapResponse;

public abstract class LookupItem<T> implements TradfrjRequest<Optional<T>> {

	private final String path;
	private Class<T> targetClass;

	public LookupItem(Class<T> targetClass, String path) {
		this.targetClass = targetClass;
		this.path = path;
	}

	@Override
	public CoapRequest getRequest() {
		return new CoapRequest(path, CoAP.Code.GET);
	}

	@Override
	public Optional<T> handleResponse(CoapResponse response) {
		return Optional.of(gson().fromJson(response.getPayload(), targetClass));
	}
}
