package org.tbot.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class CoreConnection {
	
	public String						server	= "";
	public String						login	= "";
	public String						pass	= "";
	public String						idlogin	= "";
	public String						tipoLegion="";
	public String 						acctionkey ="";
	
	private final static Logger			lg		= Logger.getLogger(CoreConnection.class.getName());
	
	public final CloseableHttpClient	Httpclient;
	
	public CloseableHttpClient createClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// Increase max total connection to 200
		cm.setMaxTotal(200);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		// Increase max connections for localhost:80 to 50
		return HttpClients.custom().setConnectionManager(cm).build();
	}
	
	public CoreConnection(String server, String login, String pass) {
		this.server = server;
		this.Httpclient = createClient();
		this.login = login;
		this.pass = pass;
		
	}
	
	public CloseableHttpResponse sendGET(String urlentry) throws IOException {
		return sendGET(urlentry, null);
	}
	
	public CloseableHttpResponse sendGET(String urlentry, List<NameValuePair> params) throws IOException {
		
		HttpGet sender = new HttpGet(server + urlentry + "?" + formatParams(params));
		sender.setHeader("User-Agent", " Mozilla/1.1");
		
		CloseableHttpResponse response = Httpclient.execute(sender);
		
		System.out.println("GET  " + server + urlentry + "?" + formatParams(params) + " " + response.getStatusLine().getStatusCode());
		return response;
		
	}
	
	public CloseableHttpResponse sendPOST(String urlentry) throws IOException {
		return sendPOST(urlentry, null);
	}
	
	public CloseableHttpResponse sendPOST(String urlentry, List<NameValuePair> params) throws IOException {
		
		HttpPost sender = new HttpPost(server + urlentry);
		sender.setHeader("User-Agent", "Mozilla/1.1");
		sender.setEntity(new UrlEncodedFormEntity(params));
		CloseableHttpResponse response = Httpclient.execute(sender);
		System.out.println("POST " + server + urlentry + "?" + formatParams(params) + " " + response.getStatusLine().getStatusCode());
		
		return response;
		
	}
	
	private static String formatParams(List<NameValuePair> params) {
		if (params == null || params.size()==0)
			return "";
		
		String result = "";
		
		for (NameValuePair p : params) {
			result += p.getName() + "=" + p.getValue() + "&";
		}
		result = result.substring(0, result.length() - 1);
		return result;
		
	}
	
	public void printConn(HttpResponse conn) {
		BufferedReader rd;
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
