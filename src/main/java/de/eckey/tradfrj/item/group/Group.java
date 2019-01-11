package de.eckey.tradfrj.item.group;

import com.google.gson.annotations.SerializedName;

import de.eckey.tradfrj.item.Item;

public class Group extends Item {
	@SerializedName("9001")
	private String name;

	@SerializedName("9002")
	private long createdAt;

	@SerializedName("5850")
	private int power;

	@SerializedName("9039")
	private int sceneId;

	@SerializedName("9018")
	private GroupData groupData;

	public String getName() {
		return name;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public int getPower() {
		return power;
	}

	public int getSceneId() {
		return sceneId;
	}

	public GroupData getGroupData() {
		return groupData;
	}

}
