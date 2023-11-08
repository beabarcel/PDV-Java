/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.tabelas;

import pdv.entities.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barce
 */
public class ModeloTabelaProduto extends AbstractTableModel {

    private ArrayList<Produto> listaProduto;

    /**
     * @return the listaProduto
     */
    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    /**
     * @param listaProduto the listaProduto to set
     */
    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    @Override
    public int getRowCount() {
        return getListaProduto().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0: {
                return this.getListaProduto().get(linha).getIdProd();
            }
            case 1: {
                return this.getListaProduto().get(linha).getQuantProdEstoque();
            }
            case 2: {
                return this.getListaProduto().get(linha).getUnidProd();
            }
            case 3: {
                return this.getListaProduto().get(linha).getNomeProd();
            }
            case 4: {
                return this.getListaProduto().get(linha).getPrecoProd();
            }
            case 5: {
                return this.getListaProduto().get(linha).getDataVendaProd();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0: {
                return "Id";
            }
            case 1: {
                return "quantidade estoque";
            }
            case 2: {
                return "unidade";
            }
            case 3: {
                return "nome";
            }
            case 4: {
                return "preco";
            }
            case 5: {
                return "data venda";
            }
        }
        return null;
    }

    public void incluirProduto(Produto produto) {
        listaProduto.add(produto);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void excluirProduto(int rowIndex) {
        listaProduto.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
   public void alterarProduto(int rowIndex, Produto novoProduto) {
        listaProduto.set(rowIndex, novoProduto);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
   
    public Produto consultarProduto(int id) {
        for (Produto produto : listaProduto) {
            if (produto.getIdProd() == id) {
                return produto;
            }
        }
        return null;
    }
}
