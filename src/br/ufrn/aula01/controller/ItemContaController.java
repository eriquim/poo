/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.ItemConta;
import br.ufrn.aula01.repository.ItemContaRepository;

/**
 * @author eriquim
 *
 */
public class ItemContaController extends AbstractController<ItemConta,ItemContaRepository> {

	public ItemContaController(ItemContaRepository repository) {
		super(repository);
	}

}
