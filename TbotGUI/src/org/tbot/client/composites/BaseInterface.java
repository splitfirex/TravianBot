package org.tbot.client.composites;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

public class BaseInterface extends Composite {
	TabPanel					main		= new TabPanel();
	String						hashLogin	= null;
	public final BaseBuild		build		= new BaseBuild();
	public final BaseArmy		army		= new BaseArmy();
	public final BaseMarket		market		= new BaseMarket();
	public final BaseVillages	villages	= new BaseVillages();
	public final BaseSettings	settings	= new BaseSettings();
	
	public BaseInterface() {
		
		main.setStyleName("interfaceTab");
		main.add(build, build.getTabName());
		main.add(army, army.getTabName());
		main.add(market, market.getTabName());
		main.add(villages, villages.getTabName());
		main.add(settings, settings.getTabName());
		main.selectTab(3);
		initWidget(main);
		
	}
	
}
