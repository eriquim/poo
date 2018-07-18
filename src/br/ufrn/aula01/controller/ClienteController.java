/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Cliente;
import br.ufrn.aula01.repository.ClienteRepository;

/**
 * @author eriquim
 *
 */
public class ClienteController extends AbstractController<Cliente, ClienteRepository> {

	public ClienteController(ClienteRepository repository) {
		super(repository);
	}

}
