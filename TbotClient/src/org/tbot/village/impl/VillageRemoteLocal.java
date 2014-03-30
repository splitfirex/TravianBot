package org.tbot.village.impl;

import javax.ejb.Remote;

import org.tbot.building.IBuilding;

@Remote
public interface VillageRemoteLocal extends IBuilding {
	public static final String JNDI_REMOTE_NAME = "ejb/IBuilding";

}
