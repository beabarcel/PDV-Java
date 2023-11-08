package pdv.controllers;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pdv.entities.Cliente;

public class ClienteController {

    private Connection conexao;
    private String sql;

    public ClienteController() throws SQLException {
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

    public void criarCliente(Cliente cliente) {
        sql = "INSERT INTO clientes (nome, telefone, email, logradouro, complemento, cep, bairro, cidade, estado, numero) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getLogradouro());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado());
            stmt.setString(10, cliente.getNumero());

            stmt.executeUpdate();

            System.out.println("Cliente criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente consultarCliente(String email) {
        Cliente cliente = null;
        sql = "SELECT * FROM clientes WHERE email = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setLogradouro(resultado.getString("logradouro"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setEstado(resultado.getString("estado"));
                cliente.setNumero(resultado.getString("numero"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public Cliente alterarCliente(String nome) {
        Cliente cliente = null;
    sql = "UPDATE clientes SET nome=?, telefone=?, email=?, logradouro=?, complemento=?, cep=?, bairro=?, cidade=?, estado=?, numero=? WHERE id=?";

    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getLogradouro());
        stmt.setString(5, cliente.getComplemento());
        stmt.setString(6, cliente.getCep());
        stmt.setString(7, cliente.getBairro());
        stmt.setString(8, cliente.getCidade());
        stmt.setString(9, cliente.getEstado());
        stmt.setString(10, cliente.getNumero());
        stmt.setInt(11, cliente.getId());

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Nenhum cliente foi alterado.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return cliente;
    }


    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM clientes";

        List<Cliente> clientes = new ArrayList<Cliente>();

        ResultSet resultado = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setLogradouro(resultado.getString("logradouro"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setEstado(resultado.getString("estado"));
                cliente.setNumero(resultado.getString("numero"));
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return clientes;
    }

    public void deletarCliente(int id) {
        sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
