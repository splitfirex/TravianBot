package org.tbot.client.composites.renders;

import org.tbot.dto.Resources;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ResourcesBar extends Composite {
	SimplePanel		main			= new SimplePanel();
	HorizontalPanel	horizonpanel	= new HorizontalPanel();
	
	public ResourcesBar() {
		initWidget(main);
		main.setStyleName("resourcesBar");
		main.add(horizonpanel);
		
	}
	
	public void updateResources(Resources res) {
	/*	horizonpanel.add(new ResourceItem(ResourceItem.Items.WOOD, res., res.pw));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.CLAY, res.c, res.pc));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.IRON, res.i, res.pi));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.CROP, res.cr, res.pcr));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.KEEP, res.ke));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.STOR, res.str));
		horizonpanel.add(new ResourceItem(ResourceItem.Items.GRAN, res.gra));*/
	}
	
}
