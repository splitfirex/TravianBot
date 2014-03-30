package org.tbot.core;

import java.io.InputStream;
import java.util.Properties;

public class CoreBuildings {

	/**
	 * Guardar los mensajes en un mapa de propiedades.
	 */
	private static Properties prop = null;
	/**
	 * Bitacora de eventos del servicio.
	 */

	/**
	 * carga el archivo de mensajes apenas arranque la aplicacion.
	 */
	static {
		loadProperties("idBuildings.properties");
	}

	/**
	 * Metodo publico que devuelve un objeto HashMap con los valores de las
	 * propiedades que se encuentran en el archivo Mensajes.properties
	 * 
	 * @param name
	 *            , string con el path y el nombre del fichero .properties a
	 *            leer
	 * @return HashMap con los valores, de lo contrario devolvemos null
	 */
	private static void loadProperties(String name) {

		/*
		 * Abrimos el fichero properties para leer de el
		 */
		if (prop == null) {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			prop = new Properties();
			InputStream in = cl.getResourceAsStream(name);
			try {
				prop.load(in);
			} catch (Exception exception) {
			} finally {
				try {
					in.close();
				} catch (Exception exception) {
				}
			}
		}
	}

	/**
	 * Metodo que obtiene el mensaje.
	 * 
	 * @param clave
	 *            Clave para buscar el mensaje.
	 * @return El mensaje.
	 */
	public static String getName(String clave) {
		return prop.getProperty(clave);
	}
	
	
}
