package org.tbot.core;

import java.util.HashMap;
import java.util.Map;

import org.tbot.utils.StringMD;

public class CoreDaemon {

	private static Map<String, CoreConnection> connections = new HashMap<String, CoreConnection>();

	public static String generateConnection(String server, String login,
			String pass) {
		//System.setProperty("socksProxyHost", "localhost");
		//System.setProperty("socksProxyPort", "9666");

		String stringToEncrypt = server + login + pass;

		String encryptedString = StringMD.getStringMessageDigest(
				stringToEncrypt, "MD5");

		if (connections.containsKey(encryptedString)) {
			return encryptedString;
		} else {
			connections.put(encryptedString, new CoreConnection(server, login,
					pass));
			return encryptedString;
		}
	}

	public static CoreConnection getConnection(String login) {
		if (connections.containsKey(login)) {
			return connections.get(login);
		} else {
			System.out.println("No se pudo obtener la conexion");
			return null;
		}
	}

	public static void killCoonection(String login) {
		connections.remove(login);
	}

}
