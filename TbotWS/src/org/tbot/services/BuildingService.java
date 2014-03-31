package org.tbot.services;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.tbot.building.IBuilding;
import org.tbot.dto.Building;
import org.tbot.dto.Village;

@WebService
public class BuildingService {
	
	@EJB()
	IBuilding	ibui	= null;
	
	@WebMethod(operationName = "subirNivelEdificio")
	public Boolean subirnivel(@WebParam(name = "hashLogin") String hashLogin, @WebParam(name = "village") Village vl, @WebParam(name = "building") Building bui) throws IOException {
		
		return ibui.subirNivel(hashLogin, vl, bui);
	}
	
	@WebMethod(operationName = "obtenerInfoEdificio")
	public Building obtenerInfoEdificio(@WebParam(name = "hashLogin") String hashLogin, @WebParam(name = "idVillage") String vl, @WebParam(name = "idBuilding") int bui)
			throws IOException {
		Building ret = new Building();
		ret.setId(bui);
		ret.setIdvillage(vl);
		
		ibui.obtenerInfoEdificio(hashLogin, ret);
		
		return ret;
		
	}
	
}
