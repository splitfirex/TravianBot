package org.tbot.village;

import java.io.IOException;
import java.util.Map;

import org.tbot.system.dto.Building;
import org.tbot.system.dto.Troops;
import org.tbot.system.dto.Village;

public interface IVillage {
		
	void obtenerVillaInfo(String hashLogin, Village vl) throws IOException;
	
	Map<String, Troops> obtenerTropas(String hashLogin, Village vl);

	Map<String, Building> obtenerEdificios(String hashLogin, String vl) throws IOException;
	
	Map<String, String> obtenerConstruibles(String hashLogin, String vl) throws IOException;
	
}
