package org.tbot.client.composites;

import org.tbot.client.TbotGUI;
import org.tbot.client.composites.renders.ResourcesBar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;

public class BaseBuild extends BaseComposite {
	
	
	SimplePanel	main	= new SimplePanel();
	Button but = new Button();
	
	public BaseBuild() {
		initWidget(main);
		ResourcesBar rb = new ResourcesBar();
		but.setText("PRUEBA");
		//Resources rc = new Resources("2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000", "2000");
		
		//rb.updateResources(rc);
		
		main.setWidget(but);
	}

	@Override
	public String getTabName() {
		return "Buildings";
	}

	@Override
	public void Initialize() {
		but.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				System.out.print("VILLAS" + TbotGUI.getAccount().getVillages().length);
				
			}
		});
	}
	
}
