package org.tbot.client.composites;

import com.google.gwt.user.client.ui.SimplePanel;

public class BaseMarket extends BaseComposite {
	SimplePanel	main	= new SimplePanel();
	
	public BaseMarket() {
		initWidget(main);
	}
	
	@Override
	public String getTabName() {
		// TODO Auto-generated method stub
		return "Market";
	}

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
