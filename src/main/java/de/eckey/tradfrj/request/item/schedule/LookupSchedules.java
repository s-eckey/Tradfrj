package de.eckey.tradfrj.request.item.schedule;

import java.util.Collection;

import de.eckey.tradfrj.item.schedule.Schedule;
import de.eckey.tradfrj.request.item.LookupItems;

public class LookupSchedules extends LookupItems<Schedule> {

	public LookupSchedules(Collection<Double> ids) {
		super(ids, (id) -> new LookupSchedule(id));
	}

}
