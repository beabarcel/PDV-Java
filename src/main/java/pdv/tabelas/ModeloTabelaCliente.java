/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.tabelas;

import pdv.entities.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barce
 */
public class ModeloTabelaCliente extends AbstractTableModel {

    private ArrayList<Cliente> listaCliente;

    /**
     * @return the listaCliente
     */
    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    @Override
    public int getRowCount() {
        return getListaCliente().size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0: {
                return this.getListaCliente().get(linha).getNome();
            }
            case 1: {
                return this.getListaCliente().get(linha).getTelefone();
            }
            case 2: {
                return this.getListaCliente().get(linha).getEmail();
            }
            case 3: {
                return this.getListaCliente().get(linha).getLogradouro();
            }
            case 4: {
                return this.getListaCliente().get(linha).getComplemento();
            }
            case 5: {
                return this.getListaCliente().get(linha).getCep();
            }
            case 6: {
                return this.getListaCliente().get(linha).getBairro();
            }
            case 7: {
                return this.getListaCliente().get(linha).getCidade();
            }
            case 8: {
                return this.getListaCliente().get(linha).getEstado();
            }
            case 9: {
                return this.getListaCliente().get(linha).getNumero();
            }
        }

        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0: {
                return "nome";
            }
            case 1: {
                return "telefone";
            }
            case 2: {
                return "email";
            }
            case 3: {
                return "logradouro";
            }
            case 4: {
                return "complmento";
            }
            case 5: {
                return "cep";
            }
            case 6: {
                return "bairro";
            }
            case 7: {
                return "cidade";
            }
            case 8: {
                return "estado";
            }
            case 9: {
                return "numero";
            }
        }
        return null;
    }

    public void incluirCliente(Cliente cliente) {
        listaCliente.add(cliente);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void excluirCliente(int rowIndex) {
        listaCliente.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void alterarCliente(int rowIndex, Cliente novoCliente) {
        listaCliente.set(rowIndex, novoCliente);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Cliente consultarCliente (int id) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
