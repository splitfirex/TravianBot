package org.tbot.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.tbot.building.IBuilding;
import org.tbot.core.CoreActions;
import org.tbot.core.CoreConnection;
import org.tbot.core.CoreDaemon;
import org.tbot.dto.Building;
import org.tbot.dto.Village;

@Local
@Stateless
public class BuildingBean implements IBuilding {
	
	CloseableHttpResponse	response;
	Document				doc;
	List<NameValuePair>		params	= new ArrayList<NameValuePair>();
	CoreConnection			tc;
	
	private void populate(HttpResponse response, String server) {
		try {
			Document doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", server);
			
			if (doc.select("#build.gid0").size() != 0) {
				populateBlank(doc);
			} else if (doc.select("#content.build.gidRessources").size() != 0) {
				// populateField(doc);
				
			} else if (doc.select("#tabFavorButton").attr("onclick").contains("buildingMarket")) {
				populateMarket(doc);
				// printLite();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void populateMarket(Document doc) {
		
	}
	
	private void populateBlank(Document doc) {
		// name = "Terreno Vacio";
	}
	
	@Override
	public void obtenerInfoEdificio(String hashLogin, Building bui) throws IOException {
		
		
		
	}
	
	private Boolean puedeSubir(Village vl, Building bui) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//if (bui.getNextLevelResources().compareUpgrade(vl.getTotalResources()) && (vl.getFinishTime() == null || vl.getFinishTime().compareTo(calendar) == -1))
		//	return true;
		
		return false;
		
	}
	
	@Override
	public Boolean subirNivel(String hashlogin, Village vl, Building id) throws IOException {
		if (!puedeSubir(vl, id))
			return false;
		
		tc = CoreDaemon.getConnection(hashlogin);
		
		params.clear();
		params.add(new BasicNameValuePair("newdid", vl.getId()));
		params.add(new BasicNameValuePair("id", String.valueOf(id.getId())));
		response = tc.sendGET(CoreActions.getUrl("t_build"), params);
		doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", tc.server);
		String c = "";
		if (doc.select(".green.build").first() != null) {
			
			Pattern pattern = Pattern.compile("c=(.*?)\'");
			Matcher matcher = pattern.matcher(doc.select(".green.build").first().attr("onclick"));
			if (matcher.find()) {
				c = matcher.group(1);
				params.clear();
				params.add(new BasicNameValuePair("a", String.valueOf(id.getId())));
				params.add(new BasicNameValuePair("c", c));
				tc.acctionkey = c;
				response = tc.sendGET(CoreActions.getUrl("t_default1"), params);
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public void inicializarEdificios(String login, int id, int villageID, Building bui) {
		// TODO Auto-generated method stub
		
	}
	
}
