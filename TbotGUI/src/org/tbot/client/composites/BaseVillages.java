package org.tbot.client.composites;

import org.tbot.client.composites.renders.VillagesList;
import org.tbot.dto.Village;

import com.google.gwt.user.client.ui.SimplePanel;

public class BaseVillages extends BaseComposite {
	SimplePanel		main		= new SimplePanel();
	VillagesList	villages	= new VillagesList();
	Village[]		villas		= null;
	
	public BaseVillages() {
		initWidget(main);
		main.add(villages);
	}
	
	@Override
	public String getTabName() {
		// TODO Auto-generated method stub
		return "Villages";
	}
	
	public void setVillages(Village[] villages) {
		villas = villages;
		for(Village vg: villas){
			this.villages.addVillage(vg);
		}
	}

	@Override
	public void Initialize() {
		
		
		
	}
	
		
}
