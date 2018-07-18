package br.ufrn.aula01.model;

import java.util.List;

public class Conta extends java.util.Observable implements ModelInterface  {

	private Integer id;
	
	private List<ItemConta> itens;
	
	private Garcon garcon;
	
	private Cliente cliente;
	
	private Mesa mesa;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the itens
	 */
	public List<ItemConta> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemConta> itens) {
		this.itens = itens;
	}

	/**
	 * @return the garcon
	 */
	public Garcon getGarcon() {
		return garcon;
	}

	/**
	 * @param garcon the garcon to set
	 */
	public void setGarcon(Garcon garcon) {
		this.garcon = garcon;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the mesa
	 */
	public Mesa getMesa() {
		return mesa;
	}

	/**
	 * @param mesa the mesa to set
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public Double getValor() {
		Double valorTotal = 0.0;
		for (ItemConta itemConta : itens) {
			valorTotal+=itemConta.getValor();
		}
		return valorTotal;
	}
	
	@Override
	public String toString() {
		
		return " Cliente: "+ getCliente() + " \n"+
			   " Mesa: " + getMesa() + "\n"+
			   " Garcon: "+ getGarcon()+ "\n"+
			   " Valor total: "+ getValor();
	}
	
}
