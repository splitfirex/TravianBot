package org.tbot.account.impl;

import org.tbot.account.IAccount;
import org.tbot.util.ServiceLocator;

public class AccountFactory {
	private static AccountFactory instance;

	private AccountFactory() {

	}

	public static AccountFactory getInstance() {
		if (instance == null) {
			instance = new AccountFactory();
		}
		return instance;
	}

	public IAccount openAccount() {
		IAccount servicio = null;
		try {
			servicio = (IAccount) ServiceLocator.instance().get(
					AccountRemoteLocal.JNDI_REMOTE_NAME);
		} catch (Exception e) {
		}
		return servicio;
	}
}
