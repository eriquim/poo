/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.MesaCliente;
import br.ufrn.aula01.repository.MesaClienteRepository;

/**
 * @author eriquim
 *
 */
public class MesaClienteController extends AbstractController<MesaCliente,MesaClienteRepository> {

	public MesaClienteController(MesaClienteRepository repository) {
		super(repository);
	}

}
