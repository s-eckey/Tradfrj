package de.eckey.tradfrj.item.device.light;

import com.google.gson.annotations.SerializedName;

import de.eckey.tradfrj.item.device.Device;

public class Light extends Device {

	@SerializedName("3311")
	private LightData[] lightData;

	public LightData[] getLightData() {
		return lightData;
	}
}
