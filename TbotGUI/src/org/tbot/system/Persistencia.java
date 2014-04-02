package org.tbot.system;

import java.util.HashMap;
import java.util.Map;

public class Persistencia {
	public static Map<String, AccountGlobal> cuentas = new HashMap<String, AccountGlobal>();

	public static void addAccount(AccountGlobal acc) {
		cuentas.put(acc.getIdSession(), acc);
	}
}
