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
import pdv.entities.Cliente;
import pdv.entities.Venda;
import pdv.enums.FormaPagamento;

/**
 *
 * @author barce
 */
public class VendaController {

    private Connection conexao;
    private String sql;

    public VendaController() throws SQLException {
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

    public void criarVenda(Venda venda) {
        sql = "INSERT INTO vendas (data e hora, valor total, id cliente, itens, forma pagamento) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, venda.getDataHora());
            stmt.setBigDecimal(2, venda.getValorTotal());
            stmt.setInt(3, venda.getIdCliente().getId());
            stmt.setInt(4, venda.getItens().indexOf(sql));
            stmt.setString(5, venda.getFormaPagamento().name());

            stmt.executeUpdate();

            System.out.println("Venda criada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Venda encontrarVenda(int idVenda) {
        Venda venda = null;
        sql = "SELECT * FROM vendas WHERE idVenda = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                venda = new Venda();
                venda.setIdVenda(resultado.getInt("idVenda"));
                venda.setDataHora(resultado.getDate("data hora"));
                venda.setValorTotal(resultado.getBigDecimal("valor total"));

                ClienteController clienteController = new ClienteController();
                Cliente cliente = clienteController.consultarCliente(resultado.getString("id_cliente"));
                venda.setIdCliente(cliente);

                /*ItemDAO itemDAO = new ItemDAO();
                List<Item> itens = itemDAO.encontrarItem(resultado.getInt("itens"));
                venda.setItens(itens);*/

                FormaPagamento formaPag = resultado.getObject("forma pagamento", FormaPagamento.class);
                venda.setFormaPagamento(formaPag);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return venda;
    }

    public List<Venda> ListarVendas() {
        String sql = "SELECT * FROM vendas";

        List<Venda> vendas = new ArrayList<Venda>();

        ResultSet resultado = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(resultado.getInt("idVenda"));
                venda.setDataHora(resultado.getDate("data hora"));
                venda.setValorTotal(resultado.getBigDecimal("valor total"));

                ClienteController clienteDAO = new ClienteController();
                Cliente cliente = clienteDAO.consultarCliente(resultado.getString("id_cliente"));
                venda.setIdCliente(cliente);

                /*ItemDAO itemDAO = new ItemDAO();
                List<Item> itens = itemDAO.encontrarItem(resultado.getInt("itens"));
                venda.setItens(itens);*/

                FormaPagamento formaPag = resultado.getObject("forma pagamento", FormaPagamento.class);
                venda.setFormaPagamento(formaPag);
            }
      
        } catch (Exception e) {

            e.printStackTrace();

        }
        return vendas;
    }

    public void deleterVenda(int id) {
        sql = "DELETE FROM vendas WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
