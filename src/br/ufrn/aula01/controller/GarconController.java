package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Garcon;
import br.ufrn.aula01.repository.GarconRepository;

public class GarconController extends AbstractController<Garcon,GarconRepository> {

	public GarconController(GarconRepository repository) {
		super(repository);
	}

}
