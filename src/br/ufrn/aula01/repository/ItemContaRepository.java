package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Conta;
import br.ufrn.aula01.model.Item;
import br.ufrn.aula01.model.ItemConta;

public class ItemContaRepository extends AbstractRepository<ItemConta> {

	@Override
	public void add(ItemConta obj) {
		String sql = "insert into public3.item_conta(id_item_conta,id_conta,id_item, quantidade) values (?,?,?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1, obj.getId());
				pst.setInt(2, obj.getConta().getId());
				pst.setInt(3, obj.getItem().getId());
				pst.setInt(4, obj.getQuantidade());
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
	public void remove(ItemConta obj) {
		String sql = "delete from public3.item_conta where id_item_conta=? ";

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
	public List<ItemConta> listar() {
		ContaRepository contaRepository = new ContaRepository();
		ItemRepository itemRepository = new ItemRepository();
		List<ItemConta> itens = new ArrayList<>();
		String sql = "select * from public3.item_conta";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					ItemConta item = new ItemConta();
					item.setId(rs.getInt("id_item"));
					item.setConta(contaRepository.findById(rs.getInt("id_conta")));
					item.setItem(itemRepository.findById(rs.getInt("id_item")));
					item.setQuantidade(rs.getInt("quantidade"));

					itens.add(item);
				}
			} finally {
				rs.close();
				pst.close();
				contaRepository.close();
				itemRepository.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}

	@Override
	public ItemConta findById(Integer id) {
		ContaRepository contaRepository = new ContaRepository();
		ItemRepository itemRepository = new ItemRepository();
		String sql = "select * from public3.item_conta where id_item_conta=?";
		ItemConta item = new ItemConta();
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					item.setId(rs.getInt("id_item"));
					item.setConta(contaRepository.findById(rs.getInt("id_conta")));
					item.setItem(itemRepository.findById(rs.getInt("id_item")));
					item.setQuantidade(rs.getInt("quantidade"));
				}
			} finally {
				rs.close();
				pst.close();
				contaRepository.close();
				itemRepository.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<ItemConta> listar(Conta conta) {
		ContaRepository contaRepository = new ContaRepository();
		ItemRepository itemRepository = new ItemRepository();
		List<ItemConta> itens = new ArrayList<>();
		String sql = "select * from public3.item_conta where id_conta=?";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, conta.getId());
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					ItemConta item = new ItemConta();
					item.setId(rs.getInt("id_item"));
					item.setConta(contaRepository.findById(rs.getInt("id_conta")));
					item.setItem(itemRepository.findById(rs.getInt("id_item")));
					item.setQuantidade(rs.getInt("quantidade"));

					itens.add(item);
				}
			} finally {
				rs.close();
				pst.close();
				contaRepository.close();
				itemRepository.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}

}
