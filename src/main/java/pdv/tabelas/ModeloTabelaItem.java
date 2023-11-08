/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.tabelas;

import pdv.entities.Item;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pdv.entities.Cliente;

/**
 *
 * @author barce
 */
public class ModeloTabelaItem extends AbstractTableModel{
    
private ArrayList<Item> listaItem;
     /**
     * @return the listaItem
     */
    public ArrayList<Item> getListaItem() {
        return listaItem;
    }

    /**
     * @param listaItem the listaItem to set
     */
    public void setListaItem(ArrayList<Item> listaItem) {
        this.listaItem = listaItem;
    }
    @Override
    public int getRowCount() {
        return getListaItem().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:{
                return this.getListaItem().get(linha).getIdItem();
            }
            case 1:{
                return this.getListaItem().get(linha).getNomeItem();
            }
            case 2:{
                return this.getListaItem().get(linha).getPrecoItem();
            }
            case 3:{
                return this.getListaItem().get(linha).getQuantVendalItem();
            }
            case 4: {
                return this.getListaItem().get(linha).getPrecoTotalItem();
            }
            case 5: {
                return this.getListaItem().get(linha).getIdProd();
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0:{
                return "Id";
            }
            case 1:{
                return "nome";
            }
             case 2:{
                return "preco";
            }
             case 3:{
                return "quantidade venda";
            }
             case 4: {
                 return "preco total";
             }
             case 5: {
                 return "id produto";
             }
        }
        return null;
    }
    
    public void incluirItem(Item item) {
        listaItem.add(item);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void excluirItem(int rowIndex) {
        listaItem.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void alterarItem(int rowIndex, Item novoItem) {
        listaItem.set(rowIndex, novoItem);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Item consultarItem (int id) {
        for (Item item : listaItem) {
            if (item.getIdItem() == id) {
                return item;
            }
        }
        return null;
    }
}