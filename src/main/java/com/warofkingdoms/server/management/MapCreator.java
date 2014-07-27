package com.warofkingdoms.server.management;

import java.util.ArrayList;
import java.util.List;

import com.warofkingdoms.server.entities.Castle;
import com.warofkingdoms.server.entities.Map;
import com.warofkingdoms.server.entities.MapTemplate;
import com.warofkingdoms.server.entities.Territory;
import com.warofkingdoms.server.entities.Tower;
import com.warofkingdoms.server.entities.Unit;

public class MapCreator {

	private static final int CASTLE_STARTING_LEVEL = 2;

	private static final int RESOURCES_GAINED_PER_TERRITORY = 1;
	private static final int RESOURCES_GAINED_PER_CASTLE = 5;
	private static final int RESOURCES_GAINED_PER_TOWER = 3;

	public final static List<Unit> gotUnits = populateGotUnits();

	public static Map createNewMap(MapTemplate templateMap) {
		switch (templateMap) {
		case GAME_OF_THRONES:
		default:
			return createNewGameOfThronesMap();
		}
	}

	private static List<Unit> populateGotUnits() {
		List<Unit> gotUnits = new ArrayList<Unit>();
		gotUnits.add(new Castle(RESOURCES_GAINED_PER_CASTLE, CASTLE_STARTING_LEVEL, "A"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "B"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "C"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "D"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "E"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "F"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "G"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "H"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "I"));
		gotUnits.add(new Tower(RESOURCES_GAINED_PER_TOWER, "J"));
		gotUnits.add(new Tower(RESOURCES_GAINED_PER_TOWER, "K"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "L"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "M"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "N"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "O"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "P"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "Q"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "R"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "S"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "T"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "U"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "V"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "X"));
		gotUnits.add(new Castle(RESOURCES_GAINED_PER_CASTLE, CASTLE_STARTING_LEVEL, "Y"));
		gotUnits.add(new Territory(RESOURCES_GAINED_PER_TERRITORY, "Z"));
		return gotUnits;
	}

	private static Map createNewGameOfThronesMap() {
		List<Unit> gotUnits = new ArrayList<Unit>();
		for (Unit gotUnit : MapCreator.gotUnits) {
			gotUnit.clone();
			gotUnits.add(gotUnit.clone());
		}
		return new Map(MapTemplate.GAME_OF_THRONES, 2, gotUnits);
	}
}