package org.tbot.client.composites;

import com.google.gwt.user.client.ui.Composite;

abstract class BaseComposite extends Composite {
	public abstract String getTabName();
	
	public abstract void Initialize();
}
