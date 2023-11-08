package PDV;

import PDV.views.janelas.JanelaPrincipal;
import conexao.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pdv.entities.Cliente;
import pdv.tabelas.ModeloTabelaCliente;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conexao = Conexao.criarConexao();
        if (conexao != null) {
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            try {
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar.");
        }

        JanelaPrincipal janelaPrincipal = new JanelaPrincipal(null, true);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setVisible(true);
    }
      
}
