package org.tbot.dto;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5097467233407517673L;
	private String idlogin, tipoLegion;
	private Village[] villages;

	public Account() {

	}

	public Account(String idlogin) {
		this.idlogin = idlogin;
	}

	public String getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(String idlogin) {
		this.idlogin = idlogin;
	}

	public Village[] getVillages() {
		return villages;
	}

	public void setVillages(Village[] villages) {
		this.villages = villages;
	}

	public String getTipoLegion() {
		return tipoLegion;
	}

	public void setTipoLegion(String tipoLegion) {
		this.tipoLegion = tipoLegion;
	}
}
