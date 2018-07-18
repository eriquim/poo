/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Mesa;
import br.ufrn.aula01.repository.MesaRepository;

/**
 * @author eriquim
 *
 */
public class MesaController extends AbstractController<Mesa, MesaRepository> {

	public MesaController(MesaRepository repository) {
		super(repository);
	}

}
