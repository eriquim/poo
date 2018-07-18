/**
 * 
 */
package br.ufrn.aula01.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.aula01.model.Conta;

/**
 * @author eriquim
 *
 */
public class ContaRepository extends AbstractRepository<Conta> {

	@Override
	public void add(Conta obj) {
		String sql = "insert into public3.conta(id_conta,id_cliente, id_garcon,id_mesa, valor) values (?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			try {
				pst = getConnection().prepareStatement(sql);
				pst.setInt(1, obj.getId());
				pst.setInt(2, obj.getCliente().getId());
				pst.setInt(3, obj.getGarcon().getId());
				pst.setInt(4, obj.getMesa().getId());
				pst.setDouble(5, obj.getValor());
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
	public void remove(Conta obj) {
		String sql = "delete from public3.conta where id_conta=? ";

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
	public List<Conta> listar() {
		GarconRepository garconRepository = new GarconRepository();
		ClienteRepository clienteRepository = new ClienteRepository();
		ItemContaRepository itemContaRepository = new ItemContaRepository();
		MesaRepository mesaRepository = new MesaRepository();
		List<Conta> itens = new ArrayList<>();
		String sql = "select * from public3.conta";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					Conta conta = new Conta();
					
					conta.setId(rs.getInt("id_conta"));
					conta.setCliente(clienteRepository.findById(rs.getInt("id_cliente")));
					conta.setGarcon(garconRepository.findById(rs.getInt("id_garcon")));
					conta.setMesa(mesaRepository.findById(rs.getInt("id_mesa")));
					conta.setItens(itemContaRepository.listar(conta));

					itens.add(conta);
				}
			} finally {
				rs.close();
				pst.close();
				garconRepository.close();
				clienteRepository.close();
				itemContaRepository.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}

	@Override
	public Conta findById(Integer id) {
		GarconRepository garconRepository = new GarconRepository();
		ClienteRepository clienteRepository = new ClienteRepository();
		ItemContaRepository itemContaRepository = new ItemContaRepository();
		MesaRepository mesaRepository = new MesaRepository();
		Conta conta = new Conta();
		String sql = "select * from public3.conta where id_conta=?";
		PreparedStatement pst;
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				while(rs.next()) {
					conta.setId(rs.getInt("id_conta"));
					conta.setCliente(clienteRepository.findById(rs.getInt("id_cliente")));
					conta.setGarcon(garconRepository.findById(rs.getInt("id_garcon")));
					conta.setMesa(mesaRepository.findById(rs.getInt("id_mesa")));
					conta.setItens(itemContaRepository.listar(conta));
				}
			} finally {
				rs.close();
				pst.close();
				garconRepository.close();
				clienteRepository.close();
				itemContaRepository.close();
				close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

}
