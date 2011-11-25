/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.pdt.ui.refactoring;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.RenameElementsOperation;
import org.eclipse.dltk.internal.core.SourceMethod;

/**
 *
 */
@SuppressWarnings("restriction")
public class RenamePHPElementsOperation extends RenameElementsOperation {

	/**
	 * @param elements
	 * @param destinations
	 * @param newNames
	 * @param force
	 */
	public RenamePHPElementsOperation(IModelElement[] elements,
			IModelElement[] destinations, String[] newNames, boolean force) {
		super(elements, destinations, newNames, force);

	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.dltk.internal.core.MultiOperation#processElements()
	 */
	@Override
	protected void processElements() throws ModelException {

		System.err.println("process elements");
		System.err.println(elementsToProcess.length);
		System.err.println(this.parentElements.length);
		
		for (IModelElement parent : parentElements) {
			
			if (parent instanceof SourceMethod) {
				
//				System.err.println("rename in method");
				
				SourceMethod method = (SourceMethod) parent;
				
				int i = 0;
				for (IModelElement toProcess : elementsToProcess) {

					
					for (IModelElement child : method.getChildren()) {
					
						if (toProcess.getClass().equals(child.getClass()) && 
								toProcess.getElementName().equals(child.getElementName())) {
						
							String newName = renamingsList[i];
							
							ISourceModule source = method.getSourceModule();
							
//							child.getModel().
							System.err.println(child.isReadOnly());
							
							
							
						}
						
						
					}
					
					i++;
					
				}
				
				
			}			
			
		}
		
		for (IModelElement elem : elementsToProcess) {
			
//			System.err.println(elem.getClass());
		}
		
		

	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.dltk.internal.core.CopyElementsOperation#processElement(org.eclipse.dltk.core.IModelElement)
	 */
	@Override
	protected void processElement(IModelElement element) throws ModelException {

		System.err.println("process " + element.getClass());

	}


}
