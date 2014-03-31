package org.tbot.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.tbot.account.impl.AccountRemoteLocal;
import org.tbot.building.IBuilding;
import org.tbot.core.CoreActions;
import org.tbot.core.CoreConnection;
import org.tbot.core.CoreDaemon;
import org.tbot.dto.Account;
import org.tbot.dto.Village;
import org.tbot.village.IVillage;

@Remote
@Stateless
public class AccountBean implements AccountRemoteLocal {

	CloseableHttpResponse response;
	Document doc;
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	CoreConnection tc;

	@EJB
	IBuilding ibui;

	@EJB
	IVillage ivil;

	// BuildingEjb bejb = new BuildingEjb();

	public void inicializarVillages(Account ac) throws IOException {
		/*
		 * tc = CoreDeamon.getConnection(ac.getServer(), ac.getLogin(),
		 * ac.getPass()); params = new ArrayList<NameValuePair>(); Map<String,
		 * Village> lvi = new HashMap<String, Village>();
		 * 
		 * CloseableHttpResponse response =
		 * tc.sendGET(Tactions.getUrl("t_login"));
		 * 
		 * Document doc = Jsoup.parse(response.getEntity().getContent(),
		 * "UTF-8", tc.server);
		 * 
		 * params.add(new BasicNameValuePair("login", doc
		 * .select("input[name=login]").first().val())); params.add(new
		 * BasicNameValuePair("name", ac.getLogin())); params.add(new
		 * BasicNameValuePair("password", ac.getPass())); params.add(new
		 * BasicNameValuePair("w", ""));
		 * 
		 * response = tc.sendPOST(Tactions.getUrl("t_default1"), params); doc =
		 * Jsoup .parse(response.getEntity().getContent(), "UTF-8", tc.server);
		 * 
		 * java.util.Iterator<Element> ite =
		 * doc.select("#sidebarBoxVillagelist")
		 * .select(".innerBox.content").select("li").iterator(); while
		 * (ite.hasNext()) { Village nvi = new Village(); Map<Integer, Building>
		 * lbui = new HashMap<Integer, Building>();
		 * 
		 * Element village = ite.next();
		 * nvi.setName(village.select(".name").first().text());
		 * nvi.setId(village.select("a").first().attr("href")
		 * .replaceAll("\\D+", ""));
		 * nvi.setX(village.select(".coordinateX").first().text()
		 * .replaceAll("\\D+", ""));
		 * nvi.setY(village.select(".coordinateY").first().text()
		 * .replaceAll("\\D+", "")); lvi.put(nvi.getId(), nvi);
		 * 
		 * ExecutorService es = Executors.newCachedThreadPool(); for (int i = 1;
		 * i <= 40; i++) { Building bb = new Building(); es.execute(new
		 * EventGetBuilding(ac.getLogin(), i, Integer .valueOf(nvi.getId()),
		 * bb)); lbui.put(i, bb); }
		 * 
		 * es.shutdown();
		 * 
		 * try { boolean finshed = es.awaitTermination(30, TimeUnit.SECONDS); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * obtenerRecursos(ac);
		 * 
		 * response.close();
		 */
	}

	@Override
	public String initialize(String login, String pass, String Server) {
		String Hash = CoreDaemon.generateConnection(Server, login, pass);
		tc = CoreDaemon.getConnection(Hash);
		params = new ArrayList<NameValuePair>();
		try {
			response = tc.sendGET(CoreActions.getUrl("t_login"));

			Document doc = Jsoup.parse(response.getEntity().getContent(),
					"UTF-8", tc.server);

			params.add(new BasicNameValuePair("login", doc
					.select("input[name=login]").first().val()));
			params.add(new BasicNameValuePair("name", login));
			params.add(new BasicNameValuePair("password", pass));
			params.add(new BasicNameValuePair("w", ""));

			response = tc.sendPOST(CoreActions.getUrl("t_default1"), params);
			doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8",
					tc.server);

			if (doc.select(".ERROR.LTR") != null
					&& !doc.select(".ERROR.LTR").text().trim().equals("")) {
				CoreDaemon.killCoonection(Hash);
				return null;
			}
			tc.tipoLegion = CoreActions.getUrl("nation");
			for (String legion : doc.select(".nation").first().classNames()) {
				if (CoreActions.getUrl(legion) != null
						&& !legion.equals("nation")) {
					tc.tipoLegion = CoreActions.getUrl(legion);
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Hash;
	}

	@Override
	public Village[] obtenerVillas(String hashlogin) throws IOException {
		List<Village> listaVilla = new ArrayList<Village>();

		tc = CoreDaemon.getConnection(hashlogin);
		params = new ArrayList<NameValuePair>();

		response = tc.sendPOST(CoreActions.getUrl("t_default1"), params);
		doc = Jsoup
				.parse(response.getEntity().getContent(), "UTF-8", tc.server);

		java.util.Iterator<Element> ite = doc.select("#sidebarBoxVillagelist")
				.select(".innerBox.content").select("li").iterator();
		while (ite.hasNext()) {
			Village nvi = new Village();
			Element village = ite.next();
			nvi.setName(village.select(".name").first().text());
			nvi.setId(village.select("a").first().attr("href")
					.replaceAll("\\D+", ""));
			// nvi.setX(village.select(".coordinateX").first().text().replaceAll("\\D+",
			// ""));
			// nvi.setY(village.select(".coordinateY").first().text().replaceAll("\\D+",
			// ""));
			ivil.obtenerVillaInfo(hashlogin, nvi);
			listaVilla.add(nvi);
			/*
			 * ExecutorService es = Executors.newCachedThreadPool(); for (int i
			 * = 1; i <= 40; i++) { Building bb = new Building(); es.execute(new
			 * EventGetBuilding(ac.getLogin(), i, Integer.valueOf(nvi.getId()),
			 * bb)); lbui.put(i, bb); }
			 * 
			 * es.shutdown();
			 * 
			 * try { boolean finshed = es.awaitTermination(30,
			 * TimeUnit.SECONDS); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

		}
		
		
		response.close();
		Village[] gg = listaVilla.toArray(new Village[listaVilla.size()]);
		CoreDaemon.getAccount(hashlogin).setVillages(gg);
		return gg;

	}

	@Override
	public Boolean enviarAtaque(String hashlogin) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account obtenerCuenta(String hashlogin) throws IOException {

		return CoreDaemon.getAccount(hashlogin);
	}

}
