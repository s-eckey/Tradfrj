package de.eckey.tradfrj.request.item.group;

import java.util.Collection;

import de.eckey.tradfrj.item.group.Group;
import de.eckey.tradfrj.request.item.LookupItems;

public class LookupGroups extends LookupItems<Group> {

	public LookupGroups(Collection<Double> ids) {
		super(ids, (id) -> new LookupGroup(id));
	}
}
