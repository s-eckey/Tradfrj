package de.eckey.tradfrj.item.device;

import com.google.gson.annotations.SerializedName;

public class DeviceData {

	@SerializedName("9")
	private int battery;
	@SerializedName("3")
	private String firmwareVersion;
	@SerializedName("0")
	private String manufacture;
	@SerializedName("1")
	private String modelNumber = "";
	@SerializedName("6")
	private int power;
	@SerializedName("2")
	private String serialNumber;

	public int getBattery() {
		return battery;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public String getManufacture() {
		return manufacture;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public int getPower() {
		return power;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

}
