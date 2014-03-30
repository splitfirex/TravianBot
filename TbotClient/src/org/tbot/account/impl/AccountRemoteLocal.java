package org.tbot.account.impl;

import javax.ejb.Remote;

import org.tbot.account.IAccount;


@Remote
public interface AccountRemoteLocal extends IAccount{
	public static final String JNDI_REMOTE_NAME = "java:jboss/exported/TbotWSEAR/TbotWS/AccountBean!org.tbot.account.impl.AccountRemoteLocal";

}
