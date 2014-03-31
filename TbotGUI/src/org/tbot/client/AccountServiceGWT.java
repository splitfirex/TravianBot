package org.tbot.client;

import org.tbot.dto.Account;
import org.tbot.dto.Village;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("account")
public interface AccountServiceGWT extends RemoteService {

	String Login(String user, String pass, String Server);

	Village[] obtenerVillas(String hashlogin);

	Account obtenerCuenta(String hashlogin);

}
