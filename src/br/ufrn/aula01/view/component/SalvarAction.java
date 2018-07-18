package br.ufrn.aula01.view.component;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import br.ufrn.aula01.controller.AbstractController;
import br.ufrn.aula01.model.ModelInterface;
import br.ufrn.aula01.repository.AbstractRepository;

public class SalvarAction<T extends ModelInterface, C extends AbstractController<T, AbstractRepository<T>>>
		extends AbstractAction {
	private JFrame frame;

	private T obj;

	private C controller;

	public SalvarAction(JFrame frame, T obj, C controller) {
		super(" Salvar ");
		this.obj = obj;
		this.frame = frame;
		this.putValue(Action.SHORT_DESCRIPTION, " Salva formulario ");
	}

	public void actionPerformed(ActionEvent ev) {
		controller.salvar(obj);
	}

}
