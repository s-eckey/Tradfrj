package de.eckey.tradfrj.request.item.device.lamp;

import static de.eckey.tradfrj.request.RequestAssertions.assertRequest;

import org.eclipse.californium.core.coap.CoAP.Code;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.eckey.tradfrj.item.device.light.Light;
import de.eckey.tradfrj.request.item.device.lamp.ModifyLightRequestBuilder.ColorTemperature;

public class ModifyLightRequestBuilderTest {

	private static final int LIGHT_ID = 10987;
	private ModifyLightRequestBuilder builder;

	@BeforeEach
	public void before() {
		Light light = new Light();
		light.setId(LIGHT_ID);
		builder = ModifyLightRequestBuilder.modify(light);
	}

	@Test
	public void testColorCold() {
		builder.withColor(ColorTemperature.COLD);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5706\":\"f5faf6\"}]}");
	}

	@Test
	public void testColorMedium() {
		builder.withColor(ColorTemperature.MEDIUM);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5706\":\"f1e0b5\"}]}");
	}

	@Test
	public void testColorWarm() {
		builder.withColor(ColorTemperature.WARM);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5706\":\"efd275\"}]}");
	}

	@Test
	public void testColor() {
		builder.withColor("costomC");
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5706\":\"costomC\"}]}");
	}

	@Test
	public void testDimmer() {
		try {
			builder.withDimmer(0);
		} catch (IllegalStateException e) {
			Assertions.assertEquals("dimmer value has to be between 1 and 254", e.getMessage());
		}
		try {
			builder.withDimmer(255);
		} catch (IllegalStateException e) {
			Assertions.assertEquals("dimmer value has to be between 1 and 254", e.getMessage());
		}
		builder.withDimmer(12);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5851\":12}]}");
	}

	@Test
	public void testLightOn() {
		builder.withLightOn(true);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5850\":1}]}");
	}

	@Test
	public void testLightOff() {
		builder.withLightOn(false);
		assertRequest(builder, Code.PUT, "15001/10987", "{\"3311\":[{\"5850\":0}]}");
	}
}
