package org.tbot.system.dto;

import java.io.Serializable;

public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5097467233407517673L;
	private String				login, pass, server, idlogin, tipoLegion;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getServer() {
		return server;
	}
	
	public void setServer(String server) {
		this.server = server;
	}
	
	public Account(String server, String pass, String login) {
		this.login = login;
		this.pass = pass;
		this.server = server;
	}
	
	public Account() {
		
	}
	
	/*
	 * private List<NameValuePair> getCreds() { List<NameValuePair> ret = new
	 * ArrayList<NameValuePair>(); ret.add(new BasicNameValuePair("name", login)); ret.add(new
	 * BasicNameValuePair("password", pass)); ret.add(new BasicNameValuePair("w", "")); ret.add(new
	 * BasicNameValuePair("login", idlogin));
	 * 
	 * return ret; }
	 */
	
	public String getIdlogin() {
		return idlogin;
	}
	
	public void setIdlogin(String idlogin) {
		this.idlogin = idlogin;
	}
}
