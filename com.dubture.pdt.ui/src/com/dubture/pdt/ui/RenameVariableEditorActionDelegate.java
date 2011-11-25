package com.dubture.pdt.ui;

import org.eclipse.dltk.internal.ui.refactoring.reorg.RenameLocalVariableWizard;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class RenameVariableEditorActionDelegate implements
		IEditorActionDelegate {

	public RenameVariableEditorActionDelegate() {

	}

	@Override
	public void run(IAction action) {

//		RenameElementsOperation rename = new RenameElementsOperation(elements, destinations, newNames, force)
	    
//	    TextFileChange change = new TextFileChange(name, file)
//	    RenameLocalVariableWizard

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
		System.err.println(selection.getClass());

	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {

		System.err.println(targetEditor.getClass());

	}

}
