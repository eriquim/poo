package br.ufrn.aula01.view;

import java.util.Observable;
import java.util.Scanner;

import br.ufrn.aula01.controller.ClienteController;
import br.ufrn.aula01.exemplo.MainTerminal;
import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.repository.ClienteRepository;

public class ClienteView extends AbstractView<Cliente>{
	
	private ClienteController clienteController;
	
	private ClienteRepository clienteRepository;
	

	public ClienteView(Cliente obj) {
		super(obj,"Cliente");
		clienteRepository = new ClienteRepository();
		clienteController = new ClienteController(clienteRepository);
		clearConsole();
		StringBuffer menu = new StringBuffer(" ****** Mesdibah - Menu Cliente ******\n");
	    menu.append(" * 1 -> Inserir  *\n");
	    menu.append(" * 2 -> Remover  *\n");
	    menu.append(" * 3 -> Listar *\n");
	    menu.append(" * 0 -> Sair *\n");
	    menu.append(" ********************************************\n");
	    menu.append("Informe somente uma das op��es acima: ");
	    setMenu(menu.toString());
	    iniciarLeitura();
	    
	}
	
	public void iniciarLeitura() {
		System.out.println(getMenu());
		int opcao = getLer().nextInt();
         Scanner clienteScanner;
         switch (opcao) {
             case 1:
            	 clienteScanner = new Scanner(System.in);
                 System.out.print("Informe um nome: ");
                 getObj().setNome(clienteScanner.nextLine());
                
                 System.out.print("Informe um cpf: ");
                 getObj().setCpf(clienteScanner.nextLine());

                 System.out.print("Informe um endere�o: ");
                 getObj().setEndereco(clienteScanner.nextLine());

				 System.out.print("Informe um telefone: ");
                 getObj().setTelefone(clienteScanner.nextLine());

                 System.out.print("Informe um cart�o fidelidade: ");
                 getObj().setCartaoFidelidade(clienteScanner.nextLine());

                 System.out.print("Informe um cr�dito: ");
                 getObj().setCredito(clienteScanner.nextDouble());
                 
                 clienteController.salvar(getObj());
                 
                 opcao = 0;
                 break;
             case 2:
            	 clienteScanner = new Scanner(System.in);
                 System.out.print("Informe um id : ");
                 int idCliente = clienteScanner.nextInt();
                 setObj(new Cliente());
                 getObj().setId(idCliente);
                 clienteController.remover(getObj());
                 opcao = 0;
                 break;
             case 3:
                 System.out.print("Todos os registros de cliente: ");
                 System.out.println("Resultado: ");
                 System.out.println(clienteController.listar());
                 opcao = 0;
                 break;
            
             case 0:
                 clearConsole();
                 MainTerminal.main(null);
             default:
                 System.out.print(" Essa n�o � uma opcao V�lida ");
                 break;
         }
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

}
