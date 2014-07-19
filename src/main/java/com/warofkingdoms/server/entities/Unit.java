package com.warofkingdoms.server.entities;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Territory.class, name = "territory"),
		@Type(value = Tower.class, name = "tower"),
		@Type(value = Castle.class, name = "castle") })
public abstract class Unit {

	private int resourcesGainedPerRound;
	private String name;

	public int getResourcesGainedPerRound() {
		return resourcesGainedPerRound;
	}

	public void setResourcesGainedPerRound(int resourcesGainedPerRound) {
		this.resourcesGainedPerRound = resourcesGainedPerRound;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method should never be called. Call the subclass clone() instead.
	 */
	@Override
	public Unit clone() {
		return null;
	}
}