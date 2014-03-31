package org.tbot.client;

import java.util.HashMap;
import java.util.Map;

import org.tbot.client.composites.BaseInterface;
import org.tbot.client.composites.LoginForm;
import org.tbot.dto.Village;
import org.tbot.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TbotGUI implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	static final String			SERVER_ERROR	= "An error occurred while " + "attempting to contact the server. Please check your network " + "connection and try again.";
	static String				hashlogin		= null;
	static final LoginForm		logform			= new LoginForm();
	static String				username		= null;
	static final BaseInterface	base			= new BaseInterface();
	static Map<String, Village> villages		= new HashMap<String, Village>();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		if (!isLogged()) {
			setLogin();
		} else {
			setInterface();
		}
		
	}
	
	private boolean isLogged() {
		username = Cookies.getCookie("id");
		hashlogin = Cookies.getCookie("hashlogin");
		if (Cookies.getCookie("logged") != null && Cookies.getCookie("logged").equals("true")) {
			return true;
		}
		return false;
		
	}
	
	protected void setLogin() {
		logform.getSubmit().addClickHandler(TbotGUIHelper.getInstance().getSessionClick());
		RootPanel.get("gwtContainer").add(logform);
	}
	
	protected void setInterface() {
		
		TbotGUIHelper.getInstance().obtenerVillages(hashlogin);
		RootPanel.get("gwtContainer").add(base);
	}
}
