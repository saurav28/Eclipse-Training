package org.eclipse.emf.examples.library.ui.views;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;



public class TreeParent extends EObjectImpl{
	private ArrayList<EObject> children;
	private String name;
	public TreeParent(String name) {
		
		children = new ArrayList();
		this.name=name;
	}
	public void addChild(EObject child) {
		children.add(child);
		//child.setParent(this);
	}
	public void removeChild(EObject child) {
		children.remove(child);
		//child.setParent(null);
		
	}
	public EObject[] getChildren() {
		return (EObject [])children.toArray(new EObject[children.size()]);
	}
	public boolean hasChildren() {
		return children.size()>0;
	}
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return name;
}

}
