package org.tbot.client;

import java.util.Date;

import org.tbot.dto.Account;
import org.tbot.dto.Village;
import org.tbot.system.AccountGlobal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TbotGUIHelper extends TbotGUI {

	public static TbotGUIHelper getInstance() {
		return new TbotGUIHelper();
	}

	public validarSesionClick getSessionClick() {
		return new validarSesionClick();
	}

	public class validarSesionClick implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			AccountServiceGWTAsync accountServicegwt = GWT
					.create(AccountServiceGWT.class);
			logform.getLayout().setWidget(5, 1, new Label("Iniciando..."));
			accountServicegwt.Login(logform.getUser().getValue(), logform
					.getNormalPassword().getValue(), logform.getDropBox()
					.getValue(logform.getDropBox().getSelectedIndex()),
					new AsyncCallback<String>() {

						@Override
						public void onSuccess(String result) {
							if (result == null) {
								logform.getLayout()
										.setWidget(
												5,
												1,
												new Label(
														"Credenciales erroneas, Intente nuevamente."));
								Cookies.removeCookie("id");
								Cookies.removeCookie("hashlogin");
								Cookies.removeCookie("logged");

							} else {
								final long DURATION = 1000 * 60 * 60 * 24 * 1;
								Date expires = new Date(System
										.currentTimeMillis() + DURATION);
								Cookies.setCookie("id", logform.getUser()
										.getValue(), expires);
								Cookies.setCookie("hashlogin", result, expires);
								Cookies.setCookie("logged", "true", expires);
								System.out.print(result);
								logform.getLayout().setWidget(5, 1,
										new Label("Bienvenido!"));
								hashlogin = result;
								setInterface();
								logform.removeFromParent();
							}

						}

						@Override
						public void onFailure(Throwable caught) {
							logform.getLayout()
									.setWidget(
											5,
											1,
											new Label(
													"Problemas en el servidor, intente mas tarde."));

						}
					});

		}

	}

	public void obtenerCuenta() {
		AccountServiceGWTAsync accountServicegwt = GWT
				.create(AccountServiceGWT.class);
		accountServicegwt.obtenerCuenta(hashlogin,
				new AsyncCallback<Account>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(Account result) {
						if (result != null) {
							accb = result;
							base.villages.setVillages(result.getVillages());
							RootPanel.get("gwtContainer").add(base);
						} else {
							obtenerVillages();
						}
					}
				});

	}

	public void obtenerVillages() {
		AccountServiceGWTAsync accountServicegwt = GWT
				.create(AccountServiceGWT.class);
		accountServicegwt.obtenerVillas(hashlogin,
				new AsyncCallback<Village[]>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(Village[] result) {
						if (result != null && result.length > 0) {
							base.villages.setVillages(result);
							accb = new AccountGlobal(username, hashlogin);
							accb.setVillages(result);
							RootPanel.get("gwtContainer").add(base);

						} else {
							Cookies.removeCookie("id");
							Cookies.removeCookie("hashlogin");
							Cookies.removeCookie("logged");
							setLogin();
						}

					}
				});

	}

}
