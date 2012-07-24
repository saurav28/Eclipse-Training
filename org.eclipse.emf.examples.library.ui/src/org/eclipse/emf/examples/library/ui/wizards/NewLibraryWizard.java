package org.eclipse.emf.examples.library.ui.wizards;




import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.library.ui.LibraryPersister;
import org.eclipse.emf.examples.library.ui.services.LibraryModifyListener;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewLibraryWizard extends Wizard{
	
	
	private NewLibraryPage libraryPage;
	
	@Override
	public void addPages() {
		libraryPage = new NewLibraryPage("Create Library");
		addPage(libraryPage);
	}

	@Override
	public boolean performFinish() {
		Library library=libraryPage.getLibrary();
		Resource res=LibraryPersister.setUp(false);
		res.getContents().add(library);
		try {
			res.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	
		
		
	
}
