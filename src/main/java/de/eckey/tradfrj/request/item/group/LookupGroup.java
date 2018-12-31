package de.eckey.tradfrj.request.item.group;

import de.eckey.tradfrj.item.group.Group;
import de.eckey.tradfrj.request.item.LookupItem;

public class LookupGroup extends LookupItem<Group> {

	public LookupGroup(Double id) {
		super(Group.class, "15004/" + id.intValue());
	}
}
