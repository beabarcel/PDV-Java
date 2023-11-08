/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.controllers;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pdv.entities.Item;
import pdv.entities.Produto;

/**
 *
 * @author barce
 */
public class ItemController {
private Connection conexao;
    private String sql;

    public ItemController() throws SQLException {
        conexao = Conexao.criarConexao();
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criarItem(Item item) {
        sql = "INSERT INTO itens (nome, preco, quantidade venda, preco total, id produto) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, item.getNomeItem());
            stmt.setBigDecimal(2, item.getPrecoItem());
            stmt.setInt(3,item.getQuantVendalItem());
            stmt.setBigDecimal(4, item.getPrecoTotalItem());
            stmt.setInt(5, item.getIdProd().getIdProd());
        

            stmt.executeUpdate();

            System.out.println("Item criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Item encontrarItem(int id) {
        Item item = null;
        sql = "SELECT * FROM itens WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                item = new Item();
                item.setIdItem(resultado.getInt("id"));
                item.setNomeItem(resultado.getString("nome"));
                item.setPrecoItem(resultado.getBigDecimal("preco"));
                item.setQuantVendaItem(resultado.getInt("quantidade venda"));
                item.setPretoTotalItem(resultado.getBigDecimal("preco total"));
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.encontrarProduto(resultado.getString("id produto"));
                produto.getIdProd();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    public List<Item> listarItens() {
        String sql = "SELECT * FROM itens";

        List<Item> itens = new ArrayList<Item>();

        ResultSet resultado = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Item item = new Item();
                item.setIdItem(resultado.getInt("id"));
                item.setNomeItem(resultado.getString("nome"));
                item.setPrecoItem(resultado.getBigDecimal("preco"));
                item.setQuantVendaItem(resultado.getInt("quantidade venda"));
                item.setPretoTotalItem(resultado.getBigDecimal("preco total"));
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.encontrarProduto(resultado.getString("id produto"));
                produto.getIdProd();
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return itens;
    }

    public void deletarItem(int id) {
        sql = "DELETE FROM itens WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
