/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Item;

/**
 *
 * @author itamir.filho
 */
public class ItemRepository extends AbstractRepository<Item> {
	@Override
	public void add(Item obj) {
		String sql = "insert into public3.item(id_item,marca, descricao, valor) values (?,?,?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1, obj.getId());
				pst.setString(2, obj.getMarca());
				pst.setString(3, obj.getDescricao());
				pst.setDouble(4, obj.getValor());
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
	public void remove(Item obj) {
		String sql = "delete from public3.item where id_item=? ";

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
	public List<Item> listar() {
		List<Item> itens = new ArrayList<>();
		String sql = "select * from public3.item";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					Item item = new Item();
					item.setId(rs.getInt("id_item"));
					item.setMarca(rs.getString("marca"));
					item.setDescricao(rs.getString("descricao"));
					item.setValor(rs.getDouble("valor"));

					itens.add(item);
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
	public Item findById(Integer id) {
		Item item = new Item();
		String sql = "select * from public3.item where id_item =?";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			try {
				if (rs.next()) {
					item.setId(rs.getInt("id_item"));
					item.setMarca(rs.getString("marca"));
					item.setDescricao(rs.getString("descricao"));
					item.setValor(rs.getDouble("valor"));

				}
			} finally {
				rs.close();
				pst.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
}
