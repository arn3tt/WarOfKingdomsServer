package com.warofkingdoms.server.entities.actions;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Move.class, name = "move"),
		@Type(value = CreateTroop.class, name = "createTroop"),
		@Type(value = UpgradeTroop.class, name = "upgradeTroop") })
public abstract class Action {

}
