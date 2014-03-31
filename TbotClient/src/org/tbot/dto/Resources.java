package org.tbot.dto;

import java.io.Serializable;

public class Resources implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8280682725256167122L;
	
	private String				wood, clay, wheat, iron, store, granary, unkeep;
	
	private String				pwood, pclay, pwheat, piron;
	
	public String getPwood() {
		return pwood;
	}
	
	public void setPwood(String pwood) {
		this.pwood = pwood;
	}
	
	public String getPclay() {
		return pclay;
	}
	
	public void setPclay(String pclay) {
		this.pclay = pclay;
	}
	
	public String getPwheat() {
		return pwheat;
	}
	
	public void setPwheat(String pwheat) {
		this.pwheat = pwheat;
	}
	
	public String getPiron() {
		return piron;
	}
	
	public void setPiron(String piron) {
		this.piron = piron;
	}
	
	public boolean compareUpgrade(Resources newrec) {
		
		return true;
		
	}
	
	public void print() {
		System.out.println("W: " + getWood() + " C: " + getClay() + " I: " + getIron() + " WH: " + getWheat());
	}
	
	public String getWheat() {
		return wheat;
	}
	
	public void setWheat(String wheat) {
		this.wheat = wheat;
	}
	
	public String getWood() {
		return wood;
	}
	
	public void setWood(String wood) {
		this.wood = wood;
	}
	
	public String getClay() {
		return clay;
	}
	
	public void setClay(String clay) {
		this.clay = clay;
	}
	
	public String getIron() {
		return iron;
	}
	
	public void setIron(String iron) {
		this.iron = iron;
	}
	
	public String getUnkeep() {
		return unkeep;
	}
	
	public void setUnkeep(String unkeep) {
		this.unkeep = unkeep;
	}
	
	public String getGranary() {
		return granary;
	}
	
	public void setGranary(String granary) {
		this.granary = granary;
	}
	
	public String getStore() {
		return store;
	}
	
	public void setStore(String store) {
		this.store = store;
	}
	
}
