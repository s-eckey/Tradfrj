package de.eckey.tradfrj.request.item.device;

import de.eckey.tradfrj.item.device.Device;
import de.eckey.tradfrj.request.item.LookupItem;

public class LookupDevice extends LookupItem<Device> {

	public LookupDevice(Double id) {
		super(Device.class, "15001/" + id.intValue());
	}
}
