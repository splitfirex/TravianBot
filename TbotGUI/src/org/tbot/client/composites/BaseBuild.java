package org.tbot.client.composites;

import org.tbot.client.composites.renders.ResourcesBar;

import com.google.gwt.user.client.ui.SimplePanel;

public class BaseBuild extends BaseComposite {
	
	
	SimplePanel	main	= new SimplePanel();
	
	public BaseBuild() {
		initWidget(main);
		ResourcesBar rb = new ResourcesBar();
		//Resources rc = new Resources("2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000");
		
		//rb.updateResources(rc);
		
		main.setWidget(rb);
	}

	@Override
	public String getTabName() {
		return "Buildings";
	}

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
