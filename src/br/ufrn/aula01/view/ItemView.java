/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.aula01.view;

import javax.swing.JOptionPane;

import br.ufrn.aula01.controller.ItemController;
import br.ufrn.aula01.model.Item;
import br.ufrn.aula01.repository.ItemRepository;

/**
 *
 * @author itamir.filho
 */
public class ItemView {
    
    private ItemController itemController;
    
    private ItemRepository itemRepository;
    
    public ItemView() {
        itemRepository = new ItemRepository();
        itemController = new ItemController(itemRepository);
    }

    public ItemController getItemController() {
        return itemController;
    }

    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    
    public static void main(String args[]) {
        
        String descricao = JOptionPane.showInputDialog("Descrição:");
        String marca = JOptionPane.showInputDialog("Marca:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));
        
        Item item = new Item();
        item.setDescricao(descricao);
        item.setMarca(marca);
        item.setValor(valor);
       
        ItemView itemView = new ItemView();
        itemView.getItemController().salvar(item);
        
        JOptionPane.showMessageDialog(null, 
                itemView.getItemController().listar());
              
        
    }
    
    
    
}
