package de.eckey.tradfrj.request.item.device.lamp;

import java.util.Collection;

import de.eckey.tradfrj.item.device.light.Light;
import de.eckey.tradfrj.request.item.LookupItems;

public class LookupLights extends LookupItems<Light> {

	public LookupLights(Collection<Double> ids) {
		super(ids, (id) -> new LookupLight(id));
	}

}
