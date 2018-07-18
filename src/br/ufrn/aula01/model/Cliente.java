/**
 * 
 */
package br.ufrn.aula01.model;

/**
 * @author eriquim
 *
 */
public class Cliente extends Pessoa {

	private String cartaoFidelidade;
	
	private Double credito;

	/**
	 * @return the cartaoFidelidade
	 */
	public String getCartaoFidelidade() {
		return cartaoFidelidade;
	}

	/**
	 * @param cartaoFidelidade the cartaoFidelidade to set
	 */
	public void setCartaoFidelidade(String cartaoFidelidade) {
		this.cartaoFidelidade = cartaoFidelidade;
	}

	/**
	 * @return the credito
	 */
	public Double getCredito() {
		return credito;
	}

	/**
	 * @param credito the credito to set
	 */
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	
	@Override
	public String toString() {
		
		return getNome() + " - "+ getTelefone() + " - "+ getCartaoFidelidade()+ " - "+ getCredito() ;
	}
	
	
}
