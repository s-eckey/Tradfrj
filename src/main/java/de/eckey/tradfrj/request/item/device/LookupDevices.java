package de.eckey.tradfrj.request.item.device;

import java.util.Collection;

import de.eckey.tradfrj.item.device.Device;
import de.eckey.tradfrj.request.item.LookupItems;

public class LookupDevices extends LookupItems<Device> {

	public LookupDevices(Collection<Double> ids) {
		super(ids, (id) -> new LookupDevice(id));
	}
}
