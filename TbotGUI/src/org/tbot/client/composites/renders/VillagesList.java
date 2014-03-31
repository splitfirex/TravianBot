package org.tbot.client.composites.renders;

import org.tbot.dto.Village;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VillagesList extends Composite{
	VerticalPanel main = new VerticalPanel();
	
	public VillagesList(){
		initWidget(main);
		main.setStyleName("villageList");
		
		
	}
	
	public void addVillage(Village village){
		main.add(new VillagesListItem(village));
	}
	
}
