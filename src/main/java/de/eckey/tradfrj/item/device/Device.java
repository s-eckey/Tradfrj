package de.eckey.tradfrj.item.device;

import com.google.gson.annotations.SerializedName;

import de.eckey.tradfrj.item.Item;

public class Device extends Item {

	@SerializedName("5750")
	private int type;
	@SerializedName("9001")
	private String name = "";
	@SerializedName("9002")
	private long createdAt;
	@SerializedName("9019")
	private int reachable;
	@SerializedName("9020")
	private long lastSeen;

	@SerializedName("3")
	private DeviceData deviceData;

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public int getReachable() {
		return reachable;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public DeviceData getDeviceData() {
		return deviceData;
	}

}
