package org.tbot.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.tbot.building.IBuilding;
import org.tbot.core.CoreActions;
import org.tbot.core.CoreBuildings;
import org.tbot.core.CoreConnection;
import org.tbot.core.CoreDaemon;
import org.tbot.dto.Building;
import org.tbot.dto.Resources;
import org.tbot.dto.Troops;
import org.tbot.dto.Village;
import org.tbot.events.EventGetBuilding;
import org.tbot.utils.TimeCalculator;
import org.tbot.village.IVillage;

@Local
@Stateless
public class VillageBean implements IVillage {
	
	CloseableHttpResponse	response;
	Document				doc;
	List<NameValuePair>		params	= new ArrayList<NameValuePair>();
	CoreConnection			tc;
	
	@EJB
	IBuilding				ibui;
	
	@Override
	public Map<String, Building> obtenerEdificios(String hashLogin, String vl) throws IOException {
		
		tc = CoreDaemon.getConnection(hashLogin);
		Map<String, Building> lbui = new HashMap<String, Building>();
		
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 1; i <= 40; i++) {
			Building bb = new Building();
			bb.setId(i);
			es.execute(new EventGetBuilding(hashLogin, vl, bb));
			lbui.put(String.valueOf(i), bb);
		}
		
		es.shutdown();
		
		try {
			boolean finshed = es.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*	
			for (int i = 1; i <= 40; i++) {
				Building bui =  new Building();
				bui.setId(i);
				lbui.put(String.valueOf(i),bui);
				ibui.obtenerInfoEdificio(hashLogin, vl, lbui.get(String.valueOf(i)));
			}
			*/
		return lbui;
	}
	
	@Override
	public Map<String, Troops> obtenerTropas(String hashLogin, Village vl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void obtenerVillaInfo(String hashLogin, Village vd) throws IOException {
		
		tc = CoreDaemon.getConnection(hashLogin);
		
		params.clear();
		params.add(new BasicNameValuePair("newdid", vd.getId()));
		response = tc.sendGET(CoreActions.getUrl("t_default1"), params);
		doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", tc.server);
		vd.setName(doc.select("#villageNameField").first().text());
		vd.setX(doc.select("#sidebarBoxVillagelist").select(".innerBox.content").select("li.active").select(".coordinateX").first().text().replaceAll("\\D+", ""));
		vd.setY(doc.select("#sidebarBoxVillagelist").select(".innerBox.content").select("li.active").select(".coordinateY").first().text().replaceAll("\\D+", ""));
		
		Resources rc = new Resources();
		rc.setWood(doc.select("#l1").text().replaceAll("\\D+", ""));
		rc.setClay(doc.select("#l2").text().replaceAll("\\D+", ""));
		rc.setIron(doc.select("#l3").text().replaceAll("\\D+", ""));
		rc.setWheat(doc.select("#l4").text().replaceAll("\\D+", ""));
		rc.setStore(doc.select("#stockBarWarehouse").text().replaceAll("\\D+", ""));
		rc.setGranary(doc.select("#stockBarGranary").text().replaceAll("\\D+", ""));
		rc.setUnkeep(doc.select("#stockBarFreeCrop").text().replaceAll("\\D+", ""));
		
		//Produccion
		rc.setPwood(doc.select("#production").select("tr").get(1).select("td.num").text().replaceAll("\\D+", ""));
		rc.setPclay(doc.select("#production").select("tr").get(2).select("td.num").text().replaceAll("\\D+", ""));
		rc.setPiron(doc.select("#production").select("tr").get(3).select("td.num").text().replaceAll("\\D+", ""));
		rc.setPwheat(doc.select("#production").select("tr").get(4).select("td.num").text().replaceAll("\\D+", ""));
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		if (doc.select("#content").select("#timer1").size() != 0) {
			
			String[] time = doc.select("#content").select("#timer1").first().text().split("[:]");
			
			Long timeDate = TimeCalculator.NowPlusTime(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
			
			vd.setFinishTime(timeDate);
		}
		
		vd.setTotalResources(rc);
		response.close();
		
	}
	
	@Override
	public Map<String, String> obtenerConstruibles(String hashLogin, String vl) throws IOException {
		tc = CoreDaemon.getConnection(hashLogin);
		Map<String, String> resultado = new HashMap<String, String>();
		
		int blank_spot = 0;
		for (int i = 17; i <= 40; i++) {
			params.clear();
			params.add(new BasicNameValuePair("newdid", vl));
			params.add(new BasicNameValuePair("id", String.valueOf(i)));
			response = tc.sendGET(CoreActions.getUrl("t_build"), params);
			doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", tc.server);
			if (doc.select("#build").first().className().split("\\s+")[0].equals("gid0")) {
				blank_spot = i;
				break;
			}
			response.close();
			
		}
		
		for (int i = 1; i <= 3 && blank_spot != 0; i++) {
			params.clear();
			params.add(new BasicNameValuePair("newdid", vl));
			params.add(new BasicNameValuePair("category", String.valueOf(i)));
			params.add(new BasicNameValuePair("id", String.valueOf(blank_spot)));
			response = tc.sendGET(CoreActions.getUrl("t_build"), params);
			doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", tc.server);
			
			for (Element ele : doc.select("div[id^=contract_building]")) {
				String f = "gid" + ele.attr("id").replaceAll("\\D+", "");
				resultado.put(CoreBuildings.getName(f), f);
			}
			
			response.close();
		}
		
		return resultado;
	}
	
}
