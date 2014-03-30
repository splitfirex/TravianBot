package org.tbot.building;

import java.io.IOException;

import org.tbot.system.dto.Account;
import org.tbot.system.dto.Building;
import org.tbot.system.dto.Village;

public interface IBuilding {
	public void inicializarEdificios(String login, int id,int villageID, Building bui);
	
	Boolean subirNivel(String hashlogin, Village vl, Building id) throws IOException;

	void obtenerInfoEdificio(String hashLogin, Building bui) throws IOException;
}
