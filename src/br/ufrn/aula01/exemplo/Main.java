/**
 * 
 */
package br.ufrn.aula01.exemplo;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.view.ClienteView;

/**
 * @author eriquim
 *
 */
public class Main extends JFrame{
	
	ClienteView clienteView;
	 
	
	public Main() {
//		 clienteView = new ClienteView(new Cliente());
//		 setSize(300, 400);
//	     setDefaultCloseOperation(EXIT_ON_CLOSE);
//	     setLocationRelativeTo(null);
//	     setTitle("JFrame, FUCK YEAH!");
//	     this.add(clienteView.getPanel());
//	     initComponents();
	}
     
	private void initComponents() {
//        JPanel painel = new JPanel(new GridLayout(1, 3));
//        JLabel jLabel1 = new JLabel("Pasta:");
//        add(jLabel1);
//        add(jTxtField1);
//        JButton jButton1 = new JButton("Atualizar");
//        add(jButton1);
//        this.add(painel, BorderLayout.NORTH);
    }
      
    public static void main (String [] args) {  
        new ClienteView(new Cliente());
    }  

}
