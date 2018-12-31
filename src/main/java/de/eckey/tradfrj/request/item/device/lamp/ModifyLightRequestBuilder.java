package de.eckey.tradfrj.request.item.device.lamp;

import java.util.HashMap;
import java.util.Map;

import de.eckey.tradfrj.item.device.light.Light;
import de.eckey.tradfrj.item.device.light.LightData;
import de.eckey.tradfrj.request.TradfrjRequest;
import de.eckey.tradfrj.request.TradfrjRequestBuilder;

public class ModifyLightRequestBuilder implements TradfrjRequestBuilder<Void> {

	private Map<String, Object> params = new HashMap<>();
	private int id;

	public static ModifyLightRequestBuilder modify(Light light) {
		return new ModifyLightRequestBuilder(light.getId());
	}

	private ModifyLightRequestBuilder(int id) {
		this.id = id;
	}

	public ModifyLightRequestBuilder withLightOn(boolean on) {
		if (on) {
			params.put(LightData.ON_OFF, Integer.valueOf(1));
		} else {
			params.put(LightData.ON_OFF, Integer.valueOf(0));
		}
		return this;
	}

	public ModifyLightRequestBuilder withDimmer(int dimmer) {
		if (dimmer < 1 || dimmer > 254) {
			throw new IllegalStateException("dimmer value has to be between 1 and 254");
		}
		params.put(LightData.DIMMER, dimmer);
		return this;
	}

	public ModifyLightRequestBuilder withColor(ColorTemperature color) {
		params.put(LightData.COLOR, (color.getColor()));
		return this;
	}

	public ModifyLightRequestBuilder withColor(String color) {
		params.put(LightData.COLOR, (color));
		return this;
	}

	@Override
	public TradfrjRequest<Void> getRequest() {
		return new ModifyLight(id, params);
	}

	public enum ColorTemperature {
		COLD("f5faf6"), MEDIUM("f1e0b5"), WARM("efd275");

		private String temp;

		ColorTemperature(String temp) {
			this.temp = temp;
		}

		public String getColor() {
			return temp;
		}
	}
}
