package de.eckey.tradfrj.request.item.device.lamp;

import java.util.Optional;

import de.eckey.tradfrj.item.device.light.Light;
import de.eckey.tradfrj.request.item.LookupItem;
import de.eckey.tradfrj.service.CoapResponse;

public class LookupLight extends LookupItem<Light> {

	public LookupLight(Double id) {
		super(Light.class, "15001/" + id.intValue());
	}

	@Override
	public Optional<Light> handleResponse(CoapResponse response) {
		Optional<Light> device = super.handleResponse(response);
		if (device.isPresent() && device.get().getType() == 2) {
			return device;
		} else {
			return Optional.empty();
		}
	}

}
