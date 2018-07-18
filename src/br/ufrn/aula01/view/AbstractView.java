package br.ufrn.aula01.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractView<X extends java.util.Observable> implements Observer {

	private String titulo;

	private X obj;

	private JPanel panel;

	private JButton novoBt = new JButton("Novo");
	private JButton salvarBt = new JButton("Salvar");
	private JButton atualizarBt = new JButton("Atualizar");
	private JButton removerBt = new JButton("Remover");

	public AbstractView(X obj, String titulo) {
		this.obj = obj;
		this.titulo = titulo;
		obj.addObserver(this);
	}

	public void addNovoListener(ActionListener a) {
		salvarBt.addActionListener(a);
	}
	
	public void addSalvarListener(ActionListener a) {
		salvarBt.addActionListener(a);
	}

	public void addAtualizarListener(ActionListener a) {
		atualizarBt.addActionListener(a);
	}

	public void addRemoverListener(ActionListener a) {
		removerBt.addActionListener(a);
	}

	public static class CloseListener extends WindowAdapter {
		public void WindowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}

}
