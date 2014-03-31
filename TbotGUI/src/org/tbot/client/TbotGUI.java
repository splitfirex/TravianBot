package org.tbot.client;

import org.tbot.client.composites.BaseInterface;
import org.tbot.client.composites.LoginForm;
import org.tbot.dto.Account;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TbotGUI implements EntryPoint {

	static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	static String hashlogin = null;
	static final LoginForm logform = new LoginForm();
	static final BaseInterface base = new BaseInterface();
	static String username = null;
	static Account accb = null;
	static int selected = 0;

	public static Account getAccount() {
		return accb;
	}

	public static void setSelected(int selecte2d) {
		selected = selecte2d;
	}

	public static int getSelected() {
		return selected;
	}

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
		if (Cookies.getCookie("logged") != null
				&& Cookies.getCookie("logged").equals("true")) {
			return true;
		}
		return false;

	}

	protected void setLogin() {
		logform.getSubmit().addClickHandler(
				TbotGUIHelper.getInstance().getSessionClick());
		RootPanel.get("gwtContainer").add(logform);
	}

	protected void setInterface() {
		TbotGUIHelper.getInstance().obtenerCuenta();
	}

}
