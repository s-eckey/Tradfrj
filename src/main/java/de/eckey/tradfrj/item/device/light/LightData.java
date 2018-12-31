package de.eckey.tradfrj.item.device.light;

import com.google.gson.annotations.SerializedName;

public class LightData {

	public final static String COLOR = "5706";
	public final static String COLOR_X = "5709";
	public final static String COLOR_Y = "5710";
	public final static String CUMULATIVE_ACTIVE_POWER = "5805";
	public final static String DIMMER = "5851";
	public final static String ON_OFF = "5850";
	public final static String ON_TIME = "5852";
	public final static String POWER_FACTOR = "5820";
	public final static String TRANSITION_TIME = "5712";
	public final static String UNIT = "5701";

	@SerializedName(COLOR)
	private String color;
	@SerializedName(COLOR_X)
	private int colorX;
	@SerializedName(COLOR_Y)
	private int colorY;
	@SerializedName(CUMULATIVE_ACTIVE_POWER)
	private float cumulativeActivePower;
	@SerializedName(DIMMER)
	private int dimmer;
	@SerializedName(ON_OFF)
	private int onOff;
	@SerializedName(ON_TIME)
	private int onTime;
	@SerializedName(POWER_FACTOR)
	private float powerFactor;
	@SerializedName(TRANSITION_TIME)
	private int transitionTime = 5;
	@SerializedName(UNIT)
	private String unit;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getColorX() {
		return colorX;
	}

	public void setColorX(int colorX) {
		this.colorX = colorX;
	}

	public int getColorY() {
		return colorY;
	}

	public void setColorY(int colorY) {
		this.colorY = colorY;
	}

	public float getCumulativeActivePower() {
		return cumulativeActivePower;
	}

	public void setCumulativeActivePower(float cumulativeActivePower) {
		this.cumulativeActivePower = cumulativeActivePower;
	}

	public int getDimmer() {
		return dimmer;
	}

	public void setDimmer(int dimmer) {
		this.dimmer = dimmer;
	}

	public int getOnOff() {
		return onOff;
	}

	public void setOnOff(int onOff) {
		this.onOff = onOff;
	}

	public int getOnTime() {
		return onTime;
	}

	public void setOnTime(int onTime) {
		this.onTime = onTime;
	}

	public float getPowerFactor() {
		return powerFactor;
	}

	public void setPowerFactor(float powerFactor) {
		this.powerFactor = powerFactor;
	}

	public int getTransitionTime() {
		return transitionTime;
	}

	public void setTransitionTime(int transitionTime) {
		this.transitionTime = transitionTime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
