package org.tbot.village.impl;

import org.tbot.account.IAccount;
import org.tbot.util.ServiceLocator;

public class VillageFactory {
	private static VillageFactory instance;

	private VillageFactory() {

	}

	public static VillageFactory getInstance() {
		if (instance == null) {
			instance = new VillageFactory();
		}
		return instance;
	}

	public IAccount openAccount() {
		IAccount servicio = null;
		try {
			servicio = (IAccount) ServiceLocator.instance().get(
					VillageRemoteLocal.JNDI_REMOTE_NAME);
		} catch (Exception e) {
		}
		return servicio;
	}
}
