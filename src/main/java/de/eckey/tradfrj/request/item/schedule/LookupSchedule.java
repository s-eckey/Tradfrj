package de.eckey.tradfrj.request.item.schedule;

import de.eckey.tradfrj.item.schedule.Schedule;
import de.eckey.tradfrj.request.item.LookupItem;

public class LookupSchedule extends LookupItem<Schedule> {

	public LookupSchedule(Double id) {
		super(Schedule.class, "15010/" + id.intValue());
	}

}
