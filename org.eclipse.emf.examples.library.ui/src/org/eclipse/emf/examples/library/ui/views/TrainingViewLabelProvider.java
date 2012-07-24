package org.eclipse.emf.examples.library.ui.views;


import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TrainingViewLabelProvider extends LabelProvider {

	public String getText(Object obj) {
		if(obj instanceof Library){
			return ((Library)obj).getName();
		}if(obj instanceof Book){
			return ((Book)obj).getTitle();
		}
		return obj.toString();
	}
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof TreeParent)
		   imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

}
