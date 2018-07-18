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
	public void add(Cliente obj) throws SQLException {
		String sql = "insert into public3.cliente(credito, id_cliente, cartao_fidelidade, nome , endereco, cpf, telefone ) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = getConnection().prepareStatement(sql);
		try {
			pst.setDouble(1, obj.getCredito());
			pst.setInt(2, obj.getId());
			pst.setString(3, obj.getCartaoFidelidade());
			pst.setString(4, obj.getNome());
			pst.setString(5, obj.getEndereco());
			pst.setString(6, obj.getCpf());
			pst.setString(7, obj.getTelefone());
			pst.execute();
		} finally {
			pst.close();
		}
	}

	@Override
	public void remove(Cliente obj) throws SQLException {
		String sql = "delete from public3.cliente where id_cliente=? ";
		PreparedStatement pst = getConnection().prepareStatement(sql);
		try {
			pst.setInt(1, obj.getId());
			pst.executeUpdate();
		} finally {
			pst.close();
		}
		
	}

	@Override
	public List<Cliente> listar() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from public3.cliente";
		PreparedStatement pst = getConnection().prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		try {
			if(rs.next()) {
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
		}
		return clientes;
	}

}
