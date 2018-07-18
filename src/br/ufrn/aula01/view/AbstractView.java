package br.ufrn.aula01.view;

import java.util.Observer;
import java.util.Scanner;

public abstract class AbstractView<X extends java.util.Observable> implements Observer {

	private String menu;

	private X obj;
	
	private Scanner ler;

	public AbstractView(X obj, String menu) {
		this.obj = obj;
		this.menu = menu;
		this.ler = new Scanner(System.in);
		obj.addObserver(this);
	}
	public abstract void iniciarLeitura();

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public X getObj() {
		return obj;
	}

	public void setObj(X obj) {
		this.obj = obj;
	}
	
	public final static void clearConsole(){
        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        }
    }

	public Scanner getLer() {
		return ler;
	}

	public void setLer(Scanner ler) {
		this.ler = ler;
	}
	
	
	

}
