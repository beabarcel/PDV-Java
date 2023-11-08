/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.tabelas;

import pdv.entities.Venda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pdv.entities.Produto;

/**
 *
 * @author barce
 */
public class ModeloTabelaVenda extends AbstractTableModel {

    private ArrayList<Venda> listaVenda;

    /**
     * @return the listaVenda
     */
    public ArrayList<Venda> getListaVenda() {
        return listaVenda;
    }

    /**
     * @param listaVenda the listaVenda to set
     */
    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    @Override
    public int getRowCount() {
        return getListaVenda().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0: {
                return this.getListaVenda().get(linha).getIdVenda();
            }
            case 1: {
                return this.getListaVenda().get(linha).getDataHora();
            }
            case 2: {
                return this.getListaVenda().get(linha).getValorTotal();
            }
            case 3: {
                return this.getListaVenda().get(linha).getIdCliente();
            }
            case 4: {
                return this.getListaVenda().get(linha).getItens();
            }
            case 5: {
                return this.getListaVenda().get(linha).getFormaPagamento();
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
                return "data";
            }
            case 2: {
                return "valor total";
            }
            case 3: {
                return "id cliente";
            }
            case 4: {
                return "itens";
            }
            case 5: {
                return "forma pagamento";
            }
        }
        return null;
    }

    public void incluirVenda(Venda venda) {
        listaVenda.add(venda);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void excluirVenda(int rowIndex) {
        listaVenda.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
   public void alterarVenda(int rowIndex, Venda novaVenda) {
        listaVenda.set(rowIndex, novaVenda);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
   
    public Venda consultarVenda(int id) {
        for (Venda venda : listaVenda) {
            if (venda.getIdVenda() == id) {
                return venda;
            }
        }
        return null;
    }
}