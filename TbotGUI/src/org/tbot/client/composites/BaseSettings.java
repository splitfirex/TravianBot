package org.tbot.client.composites;

import com.google.gwt.user.client.ui.SimplePanel;

public class BaseSettings extends BaseComposite {
	
	SimplePanel	main	= new SimplePanel();
	
	public BaseSettings() {
		initWidget(main);
	}
	
	@Override
	public String getTabName() {
		// TODO Auto-generated method stub
		return "Settings";
	}

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
