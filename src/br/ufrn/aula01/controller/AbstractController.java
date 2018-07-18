/**
 * 
 */
package br.ufrn.aula01.controller;

import br.ufrn.aula01.model.ModelInterface;
import br.ufrn.aula01.repository.AbstractRepository;

/**
 * @author eriquim
 *
 */
public abstract class AbstractController<T extends ModelInterface, V extends AbstractRepository<T>> {
	
	 private V repository;
	    
     
	    public AbstractController(V repository) {
	        this.repository = repository;
	    }

	    public void salvar(T obj) {
	    		repository.add(obj);
	    }
	    
	    public void remover(T obj) {
	    		repository.remove(obj);
	    }
	    
	    public void atualizar(T oldObj, T newObj){
	    		repository.remove(oldObj);
	    		repository.add(newObj);
	    }
	    
	    public String listar() {
	        String lista ="Lista \n";
	        for (T obj : repository.listar()) {
	            lista += obj + "\n";
	        }
	        return lista;
	    }
	
	
}
