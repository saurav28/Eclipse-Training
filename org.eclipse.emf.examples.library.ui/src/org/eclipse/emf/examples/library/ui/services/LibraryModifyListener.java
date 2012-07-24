package org.eclipse.emf.examples.library.ui.services;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

public class LibraryModifyListener implements ModifyListener{
	private Object object;
	 
	public Object modifiedObject(){
		return object;
	}

	@Override
	public void modifyText(ModifyEvent e) {
		object=e.getSource();
		
	}

}
