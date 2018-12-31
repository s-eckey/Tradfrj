package de.eckey.tradfrj.request.item.device.lamp;

import java.util.Map;

import org.eclipse.californium.core.coap.CoAP;

import de.eckey.tradfrj.request.TradfrjRequest;
import de.eckey.tradfrj.service.CoapRequest;
import de.eckey.tradfrj.service.CoapResponse;

public class ModifyLight implements TradfrjRequest<Void> {

	private int id;
	private Map<String, Object> params;

	ModifyLight(int id, Map<String, Object> params) {
		this.id = id;
		this.params = params;
	}

	@Override
	public CoapRequest getRequest() {
		return new CoapRequest("15001/" + id, CoAP.Code.PUT, "{\"3311\":[" + gson().toJson(params) + "]}");
	}

	@Override
	public Void handleResponse(CoapResponse response) {
		System.out.println(response.getResponseCode());
		return null;
	}
}
