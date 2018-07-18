/**
 * 
 */
package br.ufrn.aula01.view.component;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import br.ufrn.aula01.model.ModelInterface;

/**
 * @author eriquim
 *
 */
public class NovoAction<T extends ModelInterface> extends AbstractAction {

	private T obj;
	private JFrame frame;

	public NovoAction(JFrame frame, T obj) {
		super("Novo");
		this.frame = frame;
		this.obj = obj;
		this.putValue(Action.SHORT_DESCRIPTION, "Limpa o formulário");
		// Consultem a documenta ç ã o de javax.swing.Action para outras propriedades
	}

	public void actionPerformed(ActionEvent ev) {
		this.obj = null;
		this.frame.dispose();
		this.frame.setVisible(true);
	}

}
