package org.tbot.util;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Clase singleton para realizar las llamadas a los proveedores remotos JNDI
 * usando evaluaci�n perezoza (<em>lazy loading</em>) se guarda a nivel de
 * sesi�n
 */
public class ServiceLocator {

	private static Context initialContext;

	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	/**
	 * @return Context initialContext
	 * @throws NamingException
	 */
	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

	/**
	 * Instancia del locator
	 */
	private static volatile ServiceLocator instance = null;

	/**
	 * Mapa para registrar las instancias de locator de todos los servicios
	 */
	private Map<String, Object> services = new TreeMap<String, Object>();

	/**
	 * Mapa para registrar las instancias de locator de todos los servicios
	 */
	private Map<String, Object> servicesSinVerificador = new TreeMap<String, Object>();

	/**
	 * Instancia del contexto para obtener los objetos remotos
	 */
	private Context ctx;

	/**
	 * Constructor por defecto, inicializa el contexto
	 * 
	 * @throws NamingException
	 */
	private ServiceLocator() throws NamingException {

		setCtx(new InitialContext());
	}

	/**
	 * M�todo que implementa el patr�n singleton
	 * 
	 * @return instancia �nica de {@link ServiceLocator}
	 * @throws NamingException
	 */
	public static ServiceLocator instance() throws NamingException {

		if (instance == null) {
			/*
			 * Primera creaci�n
			 */
			// Bloqueo con doble verificacion. Funciona en JDK5+
			synchronized (ServiceLocator.class) {
				if (instance == null) {
					instance = new ServiceLocator();
				} else {
					if (instance.getCtx() == null) {
						instance.setCtx(getInitialContext());
					}
				}
			}
		}

		return instance;
	}

	/**
	 * Obtiene la instancia de un objeto remoto
	 * 
	 * @param beanName
	 *            Nombre JNDI remoto del bean a buscar
	 * @return La instancia del bean
	 * @throws NamingException
	 *             Si el nombre no est� asociado a un objeto en el contenedor
	 *             web.
	 */
	public Object get(String beanName) throws NamingException {

		Object vs = services.get(beanName);
		Object serviceRef = null;

		if (vs != null) {
			try {
				// Invocando Metodo Remoto
				serviceRef = vs;
			} catch (Exception e) {
			}

		}
		if (serviceRef == null) {
			// se crea por primera vez
			serviceRef = getCtx().lookup(beanName);
			assert ServiceLocator.class.isAssignableFrom(serviceRef.getClass());
			services.put(beanName, serviceRef);
		}

		return serviceRef;

	}

	/**
	 * Obtiene la instancia de un objeto remoto
	 * 
	 * @param beanName
	 *            Nombre JNDI remoto del bean a buscar
	 * @return La instancia del bean
	 * @throws NamingException
	 *             Si el nombre no est� asociado a un objeto en el contenedor
	 *             web.
	 */
	public Object getSinServicioVerificable(String beanName)
			throws NamingException {

		Object serviceRef = servicesSinVerificador.get(beanName);

		if (serviceRef == null) {
			// se crea por primera vez
			serviceRef = getCtx().lookup(beanName);
			assert serviceRef != null;
			servicesSinVerificador.put(beanName, serviceRef);
		}

		return serviceRef;

	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
}