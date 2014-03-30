package org.tbot.building.impl;

import org.tbot.account.IAccount;
import org.tbot.util.ServiceLocator;

public class BuildingFactory {
	private static BuildingFactory instance;

	private BuildingFactory() {

	}

	public static BuildingFactory getInstance() {
		if (instance == null) {
			instance = new BuildingFactory();
		}
		return instance;
	}

	public IAccount openAccount() {
		IAccount servicio = null;
		try {
			servicio = (IAccount) ServiceLocator.instance().get(
					BuildingRemoteLocal.JNDI_REMOTE_NAME);
		} catch (Exception e) {
		}
		return servicio;
	}
}
