package org.tbot.system.dto;

import java.io.Serializable;

public class Village implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8460968317751951965L;

	private String		x;
	
	private String		y;
	
	private String		id;
	
	private String		name;
	
	private Resources	totalResources;
	
	private Long		finishTime;
	
	public Village() {
	}
	
	public String getX() {
		return x;
	}
	
	public void setX(String x) {
		this.x = x;
	}
	
	public String getY() {
		return y;
	}
	
	public void setY(String y) {
		this.y = y;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Resources getTotalResources() {
		return totalResources;
	}
	
	public void setTotalResources(Resources totalResources) {
		this.totalResources = totalResources;
	}
	
	public Long getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime(Long calendar) {
		this.finishTime = calendar;
	}
	
}
