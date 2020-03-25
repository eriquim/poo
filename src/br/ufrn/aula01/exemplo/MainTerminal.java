/**
 * 
 */
package br.ufrn.aula01.exemplo;

import java.util.Scanner;

import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.view.ClienteView;

/**
 * @author Eric Moura
 *
 */
public class MainTerminal {

	public static void main(String[] args) {
        menuPrincipal();

    }

    static String[] nomes = new String[10];
    

    public static void menuPrincipal() {
    	Scanner ler = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" ****** Bem vindo ao Mesdibah - Menu Principal ******");
            System.out.println(" * 1 -> Operações com Cliente *");
            System.out.println(" * 2 -> Operações com Conta *");
            System.out.println(" * 3 -> Operações com Garçon *");
            System.out.println(" * 4 -> Operações com Item *");
            System.out.println(" * 5 -> Operações com Mesa *");
            System.out.println(" * 0 -> Sair *");
            System.out.println(" ********************************************");
            System.out.print("Informe somente uma das opções acima: ");
            opcao = ler.nextInt();
            Scanner nome;
            switch (opcao) {
                case 1:
                		new ClienteView(new Cliente()); 
                    opcao = 0;
                    break;
                case 2:
                    break;
                case 3:
                    opcao = 0;
                    break;
                case 4:
                    opcao = 0;
                    break;
                case 5:
	                	opcao = 0;
	                	break;
                case 0:
                    System.out.println("****** FIM DO PROGRAMA ******");
                    ler.close();
                    System.exit(0);
                default:
                    System.out.print("Essa não é uma opcao Válida ");
                    break;
            }
        } while (true);
    }

   
}
