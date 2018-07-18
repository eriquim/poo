package br.ufrn.aula01.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufrn.aula01.controller.ClienteController;
import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.repository.ClienteRepository;

public class ClienteView extends AbstractView<Cliente>{
	
	private JTextField cartaoFidelidade = new JTextField();
	private JTextField credito = new JTextField();
	private JTextField nome = new JTextField();
	private JTextField cpf = new JTextField();
	private JTextField endereco = new JTextField();
	private JTextField telefone = new JTextField();
	
	private ClienteController clienteController;
	private ClienteRepository clienteRepository;
	

	public ClienteView(Cliente obj) {
		super(obj, "Cliente");
		setPanel(new JPanel());
		clienteRepository = new ClienteRepository();
		clienteController = new ClienteController(clienteRepository);
		
		this.addAtualizarListener(new AtualizarListener());
		this.addNovoListener(new NovoListener());
		this.addRemoverListener(new RemoverListener());
		this.addSalvarListener(new SalvarListener());
		
		getPanel().add(nome);
		getPanel().add(cpf);
		getPanel().add(endereco);
		getPanel().add(telefone);
		getPanel().add(cartaoFidelidade);
		getPanel().add(credito);
		
		getPanel().add(getSalvarBt());
		getPanel().add(getAtualizarBt());
		getPanel().add(getRemoverBt());
		getPanel().add(getNovoBt());
		getPanel().setVisible(true);
	}
	
	private void init() {
		cartaoFidelidade.setText("");
		credito.setText("");
		nome.setText("");
		cpf.setText("");
		endereco.setText("");
		telefone.setText("");
		setObj(new Cliente());
	}

	@Override
	public void update(Observable o, Object arg) {
		cartaoFidelidade.setText(getObj().getCartaoFidelidade());
		credito.setText(getObj().getCredito().toString());
		nome.setText(getObj().getNome());
		cpf.setText(getObj().getCpf());
		endereco.setText(getObj().getEndereco());
		telefone.setText(getObj().getTelefone());
	}
	
	 //Controller Atualizar
    class AtualizarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clienteController.atualizar(getObj(), getObj());
        }
    }
    //Controller Novo
    class NovoListener implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			init();
    		}
    }
    //Controller Remover
    class RemoverListener implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			clienteController.remover(getObj());
    		}
    }
    //Controller Remover
    class SalvarListener implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			clienteController.remover(getObj());
    		}
    }
	

}
