package org.tbot.client.composites;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

public class LoginForm extends Composite {
	

	
	public String getHashlogin() {
		return hashlogin;
	}

	public void setHashlogin(String hashlogin) {
		this.hashlogin = hashlogin;
	}

	public FlexTable getLayout() {
		return layout;
	}

	public void setLayout(FlexTable layout) {
		this.layout = layout;
	}

	public TextBox getUser() {
		return user;
	}

	public void setUser(TextBox user) {
		this.user = user;
	}

	public ListBox getDropBox() {
		return dropBox;
	}

	public void setDropBox(ListBox dropBox) {
		this.dropBox = dropBox;
	}

	public PasswordTextBox getNormalPassword() {
		return normalPassword;
	}

	public void setNormalPassword(PasswordTextBox normalPassword) {
		this.normalPassword = normalPassword;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	String									hashlogin			= null;
	FlexTable								layout				= new FlexTable();
	SimplePanel								main				= new SimplePanel();
	TextBox									user				= new TextBox();
	PasswordTextBox							normalPassword		= new PasswordTextBox();
	ListBox									dropBox				= new ListBox();
	Button									submit				= new Button();
	
	public LoginForm() {
		layout.setStyleName("loginformbox");
		layout.setCellSpacing(6);
		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
		dropBox.setStyleName("loginformserver");
		submit.setText("Iniciar");
		// Add a title to the form
		Label title = new Label("Iniciar sesion");
		title.setStyleName("loginformtitle");
		layout.setWidget(0, 0, title);
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		// Add some standard form options
		layout.setHTML(1, 0, "Usuario");
		layout.setWidget(1, 1, user);
		layout.setHTML(2, 0, "Contrasena");
		layout.setWidget(2, 1, normalPassword);
		layout.setHTML(3, 0, "Servidor");
		layout.setWidget(3, 1, dropBox);
		
		layout.setWidget(4, 1, submit);
		
		obtenerServer();
		
		// Wrap the content in a DecoratorPanel
		main.setWidget(layout);
		main.setStyleName("loginform");
		
		initWidget(main);
	}
	
	private void obtenerServer() {
		this.dropBox.addItem("http://ts5.travian.cl");
		this.dropBox.addItem("http://ts6.travian.cl");
		this.dropBox.addItem("http://ts7.travian.cl");
		this.dropBox.addItem("http://ts4.travian.cl");
		
	}
	
	
	
	public String getLoginHash() {
		return hashlogin;
	}
}
