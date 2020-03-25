/**
 * 
 */
package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Garcon;

/**
 * @author eriquim
 *
 */
public class GarconRepository extends AbstractRepository<Garcon> {

	@Override
	public void add(Garcon obj) {
		String sql = "insert into public3.garcon(nome, cpf , endereco, telefone, carteira_trabalho, matricula, salario) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getCpf());
				pst.setString(3, obj.getEndereco());
				pst.setString(4, obj.getTelefone());
				pst.setString(5, obj.getCarteiraTrabalho());
				pst.setString(6, obj.getMatricula());
				pst.setDouble(7, obj.getSalario());
				pst.execute();
			} finally {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(Garcon obj) {
	String sql = "delete from public3.garcon where id_garcon=? ";
		
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
	public List<Garcon> listar() {
		List<Garcon> garcons = new ArrayList<>();
		String sql = "select * from public3.garcon";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					
					Garcon garcon = new Garcon();
					garcon.setId(rs.getInt("id_garcon"));
					garcon.setNome(rs.getString("nome"));
					garcon.setCpf(rs.getString("cpf"));
					garcon.setEndereco(rs.getString("endereco"));
					garcon.setTelefone(rs.getString("telefone"));
					garcon.setCarteiraTrabalho(rs.getString("carteira_trabalho"));
					garcon.setMatricula(rs.getString("matricula"));
					garcon.setSalario(rs.getDouble("salario"));
					
					garcons.add(garcon);
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return garcons;
	}
	
	@Override
	public Garcon findById(Integer id) {
		Garcon garcon = new Garcon();
		String sql = "select * from public3.garcon where id_garcon = ?";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			try {
				if (rs.next()) {
					
					garcon.setId(rs.getInt("id_garcon"));
					garcon.setNome(rs.getString("nome"));
					garcon.setCpf(rs.getString("cpf"));
					garcon.setEndereco(rs.getString("endereco"));
					garcon.setTelefone(rs.getString("telefone"));
					garcon.setCarteiraTrabalho(rs.getString("carteira_trabalho"));
					garcon.setMatricula(rs.getString("matricula"));
					garcon.setSalario(rs.getDouble("salario"));
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return garcon;
	}

}
