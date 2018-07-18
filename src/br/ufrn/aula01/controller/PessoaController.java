/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Pessoa;
import br.ufrn.aula01.repository.PessoaRepository;

/**
 * @author eriquim
 *
 */
public class PessoaController extends AbstractController<Pessoa,PessoaRepository> {

	public PessoaController(PessoaRepository repository) {
		super(repository);
	}

}
