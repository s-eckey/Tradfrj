package de.eckey.tradfrj.item;

import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("9003")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
