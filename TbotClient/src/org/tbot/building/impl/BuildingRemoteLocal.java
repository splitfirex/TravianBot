package org.tbot.building.impl;

import javax.ejb.Remote;

import org.tbot.building.IBuilding;

@Remote
public interface BuildingRemoteLocal extends IBuilding {
	public static final String JNDI_REMOTE_NAME = "ejb/IBuilding";

}
