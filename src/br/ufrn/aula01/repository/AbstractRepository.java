/**
 * 
 */
package br.ufrn.aula01.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PreDestroy;

import br.ufrn.aula01.conn.Conexao;
import br.ufrn.aula01.model.ModelInterface;

/**
 * @author eriquim
 *
 */
public abstract class AbstractRepository<T extends ModelInterface> {
	
		private Connection connection;
		
	  
	  public Connection getConnection() {
			try {
				if(connection ==null || connection.isClosed()) {
					connection = Conexao.getConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}


	    public AbstractRepository() {
	    		connection = Conexao.getConnection();
	    	
	    }
	    
	    
	    public abstract T findById(Integer id);
	    
	    public abstract void add(T obj);
	    
	    public abstract void remove(T obj);
	      
	    public abstract List<T> listar();

	    @PreDestroy
		public void close() {
			try {
				if(connection !=null && !connection.isClosed()) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    

}
