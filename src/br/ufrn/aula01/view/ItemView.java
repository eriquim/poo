/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.aula01.view;

import java.util.Observable;
import java.util.Scanner;

import br.ufrn.aula01.controller.ClienteController;
import br.ufrn.aula01.controller.ItemController;
import br.ufrn.aula01.exemplo.MainTerminal;
import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.model.Item;
import br.ufrn.aula01.repository.ClienteRepository;
import br.ufrn.aula01.repository.ItemRepository;

/**
 *
 * @author eric.pereira
 */
public class ItemView extends AbstractView<Item>{
    
	private ItemController clienteController;
	private ItemRepository clienteRepository;
	

	public ItemView(Item obj) {
		super(obj,"Item");
		clienteRepository = new ClienteRepository();
		clienteController = new ClienteController(clienteRepository);
		clearConsole();
		StringBuffer menu = new StringBuffer(" ****** Mesdibah - Menu Cliente ******\n");
	    menu.append(" * 1 -> Inserir  *\n");
	    menu.append(" * 2 -> Remover  *\n");
	    menu.append(" * 3 -> Listar *\n");
	    menu.append(" * 0 -> Sair *\n");
	    menu.append(" ********************************************\n");
	    menu.append("Informe somente uma das opções acima: ");
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

                 System.out.print("Informe um endereço: ");
                 getObj().setEndereco(clienteScanner.nextLine());

				 System.out.print("Informe um telefone: ");
                 getObj().setTelefone(clienteScanner.nextLine());

                 System.out.print("Informe um cartão fidelidade: ");
                 getObj().setCartaoFidelidade(clienteScanner.nextLine());

                 System.out.print("Informe um crédito: ");
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
                 System.out.print(" Essa não é uma opcao Válida ");
                 break;
         }
	}

	@Override
	public void update(Observable o, Object arg) {
	}
	
	

    
    
}
