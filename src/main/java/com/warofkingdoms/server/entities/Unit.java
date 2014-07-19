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

	public int getResourcesGainedPerRound() {
		return resourcesGainedPerRound;
	}

	public void setResourcesGainedPerRound(int resourcesGainedPerRound) {
		this.resourcesGainedPerRound = resourcesGainedPerRound;
	}

}