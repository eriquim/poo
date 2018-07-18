/**
 * 
 */
package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Cliente;

/**
 * @author eriquim
 *
 */
public class ClienteRepository extends AbstractRepository<Cliente> {

	@Override
	public void add(Cliente obj){
		String sql = "insert into public3.cliente(credito, cartao_fidelidade, nome , endereco, cpf, telefone ) values (?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setDouble(1, obj.getCredito());
				pst.setString(2, obj.getCartaoFidelidade());
				pst.setString(3, obj.getNome());
				pst.setString(4, obj.getEndereco());
				pst.setString(5, obj.getCpf());
				pst.setString(6, obj.getTelefone());
				pst.execute();
			} finally {
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Cliente obj) {
		String sql = "delete from public3.cliente where id_cliente=? ";
		
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1, obj.getId());
				pst.executeUpdate();
			} finally {
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from public3.cliente";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				if (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setCartaoFidelidade(rs.getString("cartao_fidelidade"));
					cliente.setCredito(rs.getDouble("credito"));

					clientes.add(cliente);
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	@Override
	public Cliente findById(Integer id) {
		Cliente cliente = new Cliente();
		String sql = "select * from public3.cliente where id_cliente=? ";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1,id);
				rs = pst.executeQuery();
				if (rs.next()) {
						cliente.setId(rs.getInt("id_cliente"));
						cliente.setNome(rs.getString("nome"));
						cliente.setCpf(rs.getString("cpf"));
						cliente.setTelefone(rs.getString("telefone"));
						cliente.setCartaoFidelidade(rs.getString("cartao_fidelidade"));
						cliente.setCredito(rs.getDouble("credito"));
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cliente;
	}

}
