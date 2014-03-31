package org.tbot.server;

import java.rmi.RemoteException;

import org.tbot.client.AccountServiceGWT;
import org.tbot.dto.Village;
import org.tbot.services.AccountServiceProxy;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AccountServiceImpl extends RemoteServiceServlet implements AccountServiceGWT {
	
	public String Login(String user, String pass, String Server) {
		
		AccountServiceProxy ac = new AccountServiceProxy();
		
		try {
			return ac.initialize(user, pass, Server);
		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Village[] obtenerVillas(String hashlogin) {
		AccountServiceProxy ac = new AccountServiceProxy();
		Village[] ff = null;
		try {
			ff = ac.obtenerVillas(hashlogin);
			return ff;
						
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
