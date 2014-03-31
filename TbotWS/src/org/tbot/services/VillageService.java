package org.tbot.services;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.tbot.dto.Building;
import org.tbot.dto.Village;
import org.tbot.village.IVillage;

@WebService
public class VillageService {
	@EJB()
	IVillage	ivl	= null;
	
	@WebMethod(operationName = "obtenerInfoVilla")
	public Village obtenerInfoVilla(@WebParam(name = "hashLogin") String hashlogin, @WebParam(name = "village") Village vl) throws IOException {
		ivl.obtenerVillaInfo(hashlogin, vl);
		return vl;
		
	}
	
	@WebMethod(operationName = "obtenerListaEdificios")
	public Map<String, Building> obtenerListaEdificios(@WebParam(name = "hashLogin") String hashlogin, @WebParam(name = "idvillage") String vl) throws IOException {
		
		return ivl.obtenerEdificios(hashlogin, vl);
		
	}
	
	@WebMethod(operationName = "obtenerListaConstruibles")
	public Map<String, String> obtenerListaConstruibles(@WebParam(name = "hashLogin") String hashlogin, @WebParam(name = "idvillage") String vl) throws IOException {
		
		return ivl.obtenerConstruibles(hashlogin, vl);
		
	}
}
