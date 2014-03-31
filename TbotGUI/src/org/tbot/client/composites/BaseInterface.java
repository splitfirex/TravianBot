package org.tbot.client.composites;

import java.util.ArrayList;
import java.util.List;

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
	private List<BaseComposite> bases = new ArrayList<BaseComposite>(); 
	
	
	public BaseInterface() {
		
		bases.add(build);
		bases.add(army);
		bases.add(market);
		bases.add(villages);
		bases.add(settings);
		
		for(BaseComposite ba : bases){
			main.add(ba, ba.getTabName());
			ba.Initialize();
		}
		
		
		
		main.setStyleName("interfaceTab");
		main.selectTab(3);
		initWidget(main);

	}
	
}
