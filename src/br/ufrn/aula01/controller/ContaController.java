package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Conta;
import br.ufrn.aula01.repository.ContaRepository;

public class ContaController extends AbstractController<Conta,ContaRepository> {

	public ContaController(ContaRepository repository) {
		super(repository);
	}

}
