package org.tbot.events;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.tbot.building.IBuilding;
import org.tbot.core.CoreBuildings;
import org.tbot.core.CoreDaemon;
import org.tbot.core.CoreActions;
import org.tbot.core.CoreConnection;
import org.tbot.system.dto.Building;
import org.tbot.system.dto.Resources;

public class EventGetBuilding implements Runnable {
	
	CloseableHttpResponse	response;
	Document				doc;
	List<NameValuePair>		params	= new ArrayList<NameValuePair>();
	CoreConnection			tc;
	
	@EJB
	private IBuilding		ibui;
	
	private Building		bui;
	private String			login;
	private String			idVillage;
	
	public EventGetBuilding(String login, String idVillage, Building bu) {
		this.login = login;
		this.idVillage = idVillage;
		this.bui = bu;
	}
	
	@Override
	public void run() {
		try {
			tc = CoreDaemon.getConnection(login);
			params.clear();
			params.add(new BasicNameValuePair("newdid", idVillage));
			params.add(new BasicNameValuePair("id", String.valueOf(bui.getId())));
			bui.setIdvillage(idVillage);
			
			response = tc.sendGET(CoreActions.getUrl("t_build"), params);
			
			doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", tc.server);
			
			bui.setName(CoreBuildings.getName(doc.select("#build").first().className().split("\\s+")[0]));
			
			if (doc.select("#build").first().className().split("\\s+").length > 1) {
				bui.setLevel(Integer.valueOf(doc.select("#build").first().className().split("\\s+")[1].replaceAll("\\D+", "")));
			}
			
			bui.setNextLevelResources(null);
			if (doc.select("#contract").select(".contractText").first() != null) {
				bui.setNextLevel(Integer.valueOf(doc.select("#contract").select(".contractText").first().text().replaceAll("\\D+", "")));
				Resources rc = new Resources();
				rc.setWood(doc.select("#contract").select(".showCosts").select(".resources.r1").text().replaceAll("\\D+", ""));
				rc.setClay(doc.select("#contract").select(".showCosts").select(".resources.r2").text().replaceAll("\\D+", ""));
				rc.setIron(doc.select("#contract").select(".showCosts").select(".resources.r3").text().replaceAll("\\D+", ""));
				rc.setWheat(doc.select("#contract").select(".showCosts").select(".resources.r4").text().replaceAll("\\D+", ""));
				rc.setWheat(doc.select("#contract").select(".showCosts").select(".resources.r4").text().replaceAll("\\D+", ""));
				
				bui.setTime(doc.select("#contract").select(".showCosts").select(".clocks").text());
				
				bui.setNextLevel(Integer.valueOf(doc.select("#contract").select(".contractText").first().text().replaceAll("\\D+", "")));
				
				bui.setNextLevelResources(rc);
			}
			
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
