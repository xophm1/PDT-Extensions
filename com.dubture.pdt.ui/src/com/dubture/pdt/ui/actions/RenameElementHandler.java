package com.dubture.pdt.ui.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptModel;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.php.internal.ui.actions.SelectionHandler;

import com.dubture.pdt.ui.refactoring.RenamePHPElementsOperation;

@SuppressWarnings("restriction")
public class RenameElementHandler extends SelectionHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IModelElement element = getCurrentModelElement(event);
		
		if (element == null)
			return null;
		
		

		IModelElement parent = element.getParent();
		
		if (parent instanceof SourceMethod) {
			
			IModelElement[] elements = new IModelElement[]{element};
			IModelElement[] destinations = new IModelElement[]{parent};
			String[] newNames = new String[]{"somemane"};
			
			
			try {
				
				element.getModel().rename(elements, destinations, newNames, true, new NullProgressMonitor());
//				RenamePHPElementsOperation op = new RenamePHPElementsOperation(elements, destinations, newNames, true);
//				op.run(new NullProgressMonitor());
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	
	public IScriptModel getModel(IModelElement current) {
		
		do {
			if (current instanceof IScriptModel)
				return (IScriptModel) current;
		} while ((current = current.getParent()) != null);
		return null;
	}
	

}
