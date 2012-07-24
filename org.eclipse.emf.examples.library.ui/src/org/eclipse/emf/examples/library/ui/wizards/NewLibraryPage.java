package org.eclipse.emf.examples.library.ui.wizards;

import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewLibraryPage extends WizardPage {

	private Library library;

	protected NewLibraryPage(String pageName) {
		super(pageName);
		library=EXTLibraryFactory.eINSTANCE.createLibrary();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite= new Composite(parent, SWT.NONE);
		
		//Create Library related UI
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(composite);
		
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("Name");
		GridDataFactory.fillDefaults().applyTo(label);
		Text text =new Text(composite, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				library.setName(((Text)e.getSource()).getText());
				setPageComplete(true);
				
			}
		});
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		setControl(composite);
	}
	
	public Library getLibrary(){
		return library;
	}
	

}
