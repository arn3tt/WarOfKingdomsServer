package com.warofkingdoms.server.entities;

import java.util.List;

public class Map {

	private TemplateMap template;
	private int numPlayers;
	private List<Unit> conquerableUnits;

	// Must have no-argument constructor
	public Map() {

	}

	public Map(TemplateMap template, int numPlayers, List<Unit> conquerableUnits) {
		this.template = template;
		this.numPlayers = numPlayers;
		this.conquerableUnits = conquerableUnits;
	}

	public TemplateMap getTemplate() {
		return template;
	}
	
	public void setTemplate(TemplateMap template) {
		this.template = template;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public List<Unit> getConquerableUnits() {
		return conquerableUnits;
	}

	public void setConquerableUnits(List<Unit> conquerableUnits) {
		this.conquerableUnits = conquerableUnits;
	}
}
