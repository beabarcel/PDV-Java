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
import pdv.entities.Produto;

/**
 *
 * @author barce
 */
public class ProdutoController {
    
private Connection conexao;
    private String sql;

    public ProdutoController() throws SQLException {
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

    public void criarProduto(Produto produto) {
        sql = "INSERT INTO produtos (quantidade estoque, unidade, nome, preco, data venda) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produto.getQuantProdEstoque());
            stmt.setInt(2, produto.getUnidProd());
            stmt.setString(3,produto.getNomeProd());
            stmt.setBigDecimal(4, produto.getPrecoProd());
            stmt.setDate(5, produto.getDataVendaProd());
        

            stmt.executeUpdate();

            System.out.println("Produto criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Produto encontrarProduto(String nome) {
        Produto produto = null;
        sql = "SELECT * FROM produtos WHERE email = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                produto = new Produto();
                produto.setIdProd(resultado.getInt("idProd"));
                produto.setQuantProdEstoque(resultado.getInt("quantidade estoque"));
                produto.setUnidProd(resultado.getInt("unidade"));
                produto.setNomeProd(resultado.getString("nome"));
                produto.setPrecoProd(resultado.getBigDecimal("data venda"));
             

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";

        List<Produto> produtos = new ArrayList<Produto>();

        ResultSet resultado = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setIdProd(resultado.getInt("idProd"));
                produto.setQuantProdEstoque(resultado.getInt("quantidade estoque"));
                produto.setUnidProd(resultado.getInt("unidade"));
                produto.setNomeProd(resultado.getString("nome"));
                produto.setPrecoProd(resultado.getBigDecimal("data venda"));
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return produtos;
    }

    public void deletarProduto(int id) {
        sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
