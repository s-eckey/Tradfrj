package de.eckey.tradfrj.item.schedule;

import com.google.gson.annotations.SerializedName;

import de.eckey.tradfrj.item.Item;

public class Schedule extends Item {
	@SerializedName("9002")
	private long createdAt;

	@SerializedName("5850")
	private int power;

	@SerializedName("9041")
	private int days;

	public long getCreatedAt() {
		return createdAt;
	}

	public int getPower() {
		return power;
	}

	public int getDays() {
		return days;
	}

}
