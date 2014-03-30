package org.tbot.system.dto;

import java.io.Serializable;

public class Building implements Serializable {

	/**
   * 
   */
	private static final long serialVersionUID = -6863122539364903528L;

	public Building() {

	}

	public void setTime(String time) {
		String[] tiempo = time.split("[:]");
		buildingTime[0] = Short.valueOf(tiempo[0]);
		buildingTime[1] = Short.valueOf(tiempo[1]);
		buildingTime[2] = Short.valueOf(tiempo[2]);
	}

	private String name,idvillage;
	private int id, level, nextLevel;
	private short[] buildingTime = new short[3];
	private Resources nextLevelResources = new Resources();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Resources getNextLevelResources() {
		return nextLevelResources;
	}

	public void setNextLevelResources(Resources nextLevelResources) {
		this.nextLevelResources = nextLevelResources;
	}

	private void printLite() {
		System.out.println("id: " + id + " name: " + name + " level: " + level);
	}

	public int getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(int nextLevel) {
		this.nextLevel = nextLevel;
	}

	public short[] getBuildingTime() {
		return buildingTime;
	}

	public void setBuildingTime(short[] buildingTime) {
		this.buildingTime = buildingTime;
	}

	public String getIdvillage() {
		return idvillage;
	}

	public void setIdvillage(String idVillage2) {
		this.idvillage = idVillage2;
	}

}
