package org.tbot.client.composites;

import com.google.gwt.user.client.ui.SimplePanel;


public class BaseArmy extends BaseComposite {

	SimplePanel main = new SimplePanel();
	
	public BaseArmy(){
		initWidget(main);
	}
	
	
	@Override
	public String getTabName() {
		
		return "Army";
	}


	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
