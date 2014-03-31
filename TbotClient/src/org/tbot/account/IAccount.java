package org.tbot.account;

import java.io.IOException;

import javax.ejb.Remote;

import org.tbot.dto.Village;

@Remote
public interface IAccount {
	
	public String initialize(String login, String pass, String Server) throws IOException;
	
	public Village[] obtenerVillas(String hashlogin) throws IOException;
	
	public Boolean enviarAtaque(String hashlogin) throws IOException;
	
}
