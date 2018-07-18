/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.Item;
import br.ufrn.aula01.repository.ItemRepository;

/**
 *
 * @author itamir.filho
 */
public class ItemController extends AbstractController<Item, ItemRepository>{

	public ItemController(ItemRepository repository) {
		super(repository);
	}
    
    
}
