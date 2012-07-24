package org.eclipse.emf.examples.library.ui.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ModelPersisterHelper {

	public static EObject modelLoader(){
		ResourceSet resSet=new ResourceSetImpl();
		Resource res=resSet.getResource(URI.createFileURI(LibraryConstants.LIBRARY_PATH),true);
		
		if(!res.getContents().isEmpty()){
		EObject eObject=res.getContents().get(0);
		return eObject;
		}
		return null;
	}
}
