package org.tbot.client;

import org.tbot.dto.Village;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AccountServiceGWTAsync {

	void Login(String user, String pass, String Server, AsyncCallback<String> callback);

	void obtenerVillas(String hashlogin, AsyncCallback<Village[]> callback);
	
}
