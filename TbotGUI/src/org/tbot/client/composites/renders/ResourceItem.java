package org.tbot.client.composites.renders;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ResourceItem extends Composite {
	HorizontalPanel	wg	= new HorizontalPanel();
	
	public enum Items {
		WOOD, CLAY, IRON, CROP, KEEP, STOR, GRAN
	}
	
	public ResourceItem(Items item, String resour, String produc) {
		initWidget(wg);
		
		wg.setStyleName("resourceItem");
		Image ima = new Image(getImageRoute(item));
		ima.setPixelSize(16, 16);
		wg.add(ima);
		
		wg.add(new Label(resour));
		wg.add(new Label("(" + produc + ")"));
		
	}
	
	public ResourceItem(Items item, String resour) {
		initWidget(wg);
		
		wg.setStyleName("resourceItem");
		
		Image ima = new Image(getImageRoute(item));
		ima.setPixelSize(16, 16);
		wg.add(ima);
		
		wg.add(new Label(resour));
		
	}
	
	private String getImageRoute(Items item) {
		
		switch (item) {
			case WOOD:
				return "images/wood.png";
			case CLAY:
				return "images/clay.png";
				
			case IRON:
				
				return "images/Iron.png";
			case CROP:
				
				return "images/Crop.png";
			case KEEP:
				
				return "images/Keep.png";
			case STOR:
				
				return "images/Storage.png";
			case GRAN:
				
				return "images/Granary.png";
			default:
				return null;
		}
		
	}
	
}
