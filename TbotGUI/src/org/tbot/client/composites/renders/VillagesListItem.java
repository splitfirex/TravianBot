package org.tbot.client.composites.renders;

import org.tbot.dto.Village;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class VillagesListItem extends Composite{
	Village villa= null;
	SimplePanel main = new SimplePanel();
	HorizontalPanel hopanel = new HorizontalPanel();
	
	
	public VillagesListItem(Village villa){
		initWidget(main);
		this.villa = villa;
		main.setStyleName("villageItem");	
		
		Label titulo = new Label(this.villa.getName());
		titulo.setStyleName("villageName");
		
		hopanel.add(titulo);
		main.add(hopanel);
		
	}
}
