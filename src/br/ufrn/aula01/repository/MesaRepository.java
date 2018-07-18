package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Mesa;

public class MesaRepository extends AbstractRepository<Mesa> {

	@Override
	public void add(Mesa obj) {
		String sql = "insert into public3.mesa(id_mes,numero) values (?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1, obj.getId());
				pst.setInt(2, obj.getNumero());
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
	public void remove(Mesa obj) {
	String sql = "delete from public3.mesa where id_mesa=? ";
		
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
	public List<Mesa> listar() {
		List<Mesa> itens = new ArrayList<>();
		String sql = "select * from public3.mesa";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				if (rs.next()) {
					Mesa mesa = new Mesa();
					mesa.setId(rs.getInt("id_mesa"));
					mesa.setNumero(rs.getInt("numero"));

					itens.add(mesa);
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}
	
	@Override
	public Mesa findById(Integer id) {
		Mesa mesa = new Mesa();
		String sql = "select * from public3.mesa where id_mesa = ?";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			try {
				if (rs.next()) {
					mesa.setId(rs.getInt("id_mesa"));
					mesa.setNumero(rs.getInt("numero"));
				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesa;
	}

}
