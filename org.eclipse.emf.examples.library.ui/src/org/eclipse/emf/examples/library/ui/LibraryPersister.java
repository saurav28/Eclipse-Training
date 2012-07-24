package org.eclipse.emf.examples.library.ui;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resources;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.library.ui.services.LibraryConstants;
/**
 * Sample code to test the APIs of EMF
 * 	1. Persistence
 * 	--  Loading
 *  --  Saving
 *  2. Notification
 *  --  Adapter mechanism
 *  
 * for the ExtendedLibraryModel
 * @author saurav.sarkar1@gmail.com
 *
 */
public class LibraryPersister {
	
	public static void main(String a[]){
		Resource resource=setUp(true);
		try {
			
			save(resource);
			load(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Sets up the initial code
	 * @return
	 */
	public static Resource setUp(boolean isStandAlone) {
		ResourceSet rs=new ResourceSetImpl();
		if(isStandAlone){
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("extlibrary", new XMLResourceFactoryImpl());
			rs.getPackageRegistry().put("http:///org/eclipse/emf/examples/library/extlibrary.ecore/1.0.0", EXTLibraryPackage.class);
		}
		Resource res=rs.createResource(URI.createFileURI(LibraryConstants.LIBRARY_PATH));
		return res;
	}
	/**
	 * Load the persisted resource and prints out the contents
	 * @param res
	 * @throws IOException
	 */
	private static void load(Resource res) throws IOException {
		
		res.load(null);
		EObject eObject=res.getContents().get(0);
		if(eObject instanceof Library){
			Library library=(Library)eObject;
			System.out.println("Library Name::" +library.getName());
			EList<Book> bookList=library.getBooks();
			for (Iterator iterator = bookList.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				System.out.println("The book in the library:: " +library.getName()+ " is ::"+book.getTitle());
			}
		}
		
		
	}
	/**
	 * Persists the resource
	 * @param res
	 * @throws IOException
	 */
	private static void save(Resource res) throws IOException {
		
		Library library1=EXTLibraryFactory.eINSTANCE.createLibrary();
		attachAdapter(library1);
		library1.setName("SAP Library");
		
		Book book1=EXTLibraryFactory.eINSTANCE.createBook();
		book1.setTitle("SAP Netweaver");
		
		library1.getBooks().add(book1);
		
		res.getContents().add(library1);
		res.save(null);
		res.unload();
		
		
	}
	
	private static void attachAdapter(EObject obj){
		obj.eAdapters().add(new EContentAdapter(){
			@Override
			public void notifyChanged(Notification notification) {
				// TODO Auto-generated method stub
				super.notifyChanged(notification);
				if(notification.getEventType() == Notification.SET || notification.getEventType()== Notification.ADD)
				System.out.println("Notification happened for::" +notification.getNewValue()); 
			}
		});
	}
	
	
}
