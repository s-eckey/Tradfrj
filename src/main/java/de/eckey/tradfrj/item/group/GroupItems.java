package de.eckey.tradfrj.item.group;

import java.util.Collection;

import com.google.gson.annotations.SerializedName;

public class GroupItems {
	@SerializedName("9003")
	private Collection<Double> ids;

	public Collection<Double> getIds() {
		return ids;
	}
}