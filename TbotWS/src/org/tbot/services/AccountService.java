package org.tbot.services;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.NamingException;

import org.tbot.account.IAccount;
import org.tbot.account.impl.AccountRemoteLocal;
import org.tbot.system.dto.Village;
import org.tbot.util.ServiceLocator;

@WebService(name = "AccountService")
public class AccountService {
	
	@WebMethod(operationName = "inicializar")
	public String initialize(@WebParam(name = "login") String login, @WebParam(name = "pass") String pass, @WebParam(name = "server") String Server) throws IOException {
		
		IAccount dd = null;
		try {
			dd = (AccountRemoteLocal) ServiceLocator.instance().get(AccountRemoteLocal.JNDI_REMOTE_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dd.initialize(login, pass, Server);
		
	}
	
	@WebMethod(operationName = "obtenerVillas")
	public Village[] obtenerVillas(@WebParam(name = "hashLogin") String hashLogin) throws NamingException, IOException {
		IAccount dd = null;
		try {
			dd = (AccountRemoteLocal) ServiceLocator.instance().get(AccountRemoteLocal.JNDI_REMOTE_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Village[] ee = dd.obtenerVillas(hashLogin);
		return ee;
		
	}
	
}
