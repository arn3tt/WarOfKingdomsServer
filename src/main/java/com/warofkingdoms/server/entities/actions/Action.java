package com.warofkingdoms.server.entities.actions;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.warofkingdoms.server.entities.Troop;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = MoveTroop.class, name = "moveTroop"),
		@Type(value = CreateTroop.class, name = "createTroop"),
		@Type(value = UpgradeTroop.class, name = "upgradeTroop") })
public abstract class Action {

	private Troop troop;

	/**
	 * This method should never be called. Call the subclass clone() instead.
	 */
	@Override
	public Action clone() {
		return null;
	}
	
	public Troop getTroop() {
		return troop;
	}

	public void setTroop(Troop troop) {
		this.troop = troop;
	}
}
