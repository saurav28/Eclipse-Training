package org.eclipse.emf.examples.library.ui.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.examples.library.ui.wizards.NewLibraryWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;


public class LibraryCreationHandler extends AbstractHandler{

	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		//Open the wizard
		
		WizardDialog wizardDialog= new WizardDialog(Display.getDefault().getActiveShell(), new NewLibraryWizard());
		wizardDialog.open();
		
		return null;
	}

	

}
