package de.eckey.tradfrj.item.group;

import com.google.gson.annotations.SerializedName;

public class GroupData {

	@SerializedName("15002")
	private GroupItems items;

	public GroupItems getItems() {
		return items;
	}
}
