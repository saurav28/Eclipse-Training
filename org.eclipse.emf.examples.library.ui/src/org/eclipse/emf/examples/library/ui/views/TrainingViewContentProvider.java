package org.eclipse.emf.examples.library.ui.views;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.library.ui.services.ModelPersisterHelper;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TrainingViewContentProvider implements ITreeContentProvider {
	private TreeParent invisibleRoot;
	private TrainingView view;

	public TrainingViewContentProvider(TrainingView trainingView) {
		view=trainingView;
	}
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		
	}
	public void dispose() {
	}
	public Object[] getElements(Object parent) {
		if (parent.equals(view.getViewSite())) {
			if (invisibleRoot==null) initialize();
			return getChildren(invisibleRoot);
		}
		return getChildren(parent);
	}
	public Object getParent(Object child) {
		if (child instanceof Library) {
			return invisibleRoot;
		}
		return null;
	}
	public Object [] getChildren(Object parent) {
		if (parent instanceof TreeParent) {
			return ((TreeParent)parent).getChildren();
		}if (parent instanceof Library)
			return ((Library)parent).getBooks().toArray();
		return new Object[0];
	}
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeParent)
			return ((TreeParent)parent).hasChildren();
		if(parent instanceof Library) {
			return !((Library)parent).getBooks().isEmpty();
		}
		return false;
	}
/*
* We will set up a dummy model to initialize tree heararchy.
* In a real code, you will connect to a real model and
* expose its hierarchy.
*/
	private void initialize() {
		//For the library model
		EObject eObject=ModelPersisterHelper.modelLoader();
		Library library=null;
		if(eObject instanceof Library){
			library=(Library)eObject;
		}
		invisibleRoot = new TreeParent("");
		invisibleRoot.addChild(library);
	}

}
