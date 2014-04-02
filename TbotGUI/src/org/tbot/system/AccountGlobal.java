package org.tbot.system;

import org.tbot.dto.Account;
import org.tbot.dto.Village;

public class AccountGlobal extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -302112758620821376L;
	private Village selected;
	private Village[] villages;
	private String idSession;
	private String cuenta;

	public AccountGlobal(){
		
	}
	
	public AccountGlobal(String cuenta, String idSession) {
		this.idSession = idSession;
		this.cuenta = cuenta;
	}

	public Village getSelected() {
		if (selected == null && villages == null) {
			this.selected = villages[0];
		}
		return selected;
	}

	public void setSelected(Village selected) {
		this.selected = selected;
	}

	public Village[] getVillages() {
		return villages;
	}

	public void setVillages(Village[] villages) {
		this.villages = villages;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
}
