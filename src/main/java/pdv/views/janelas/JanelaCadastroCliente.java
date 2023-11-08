package PDV.views.janelas;

import pdv.controllers.ClienteController;
import pdv.entities.Cliente;
import pdv.enums.CadastroCliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 *
 * @author barce
 */
public class JanelaCadastroCliente extends javax.swing.JDialog {

    private CadastroCliente cadastroCliente;
    private Cliente cliente;
    private boolean confirmado;
    private ClienteController clienteController;

    public boolean operacaoConfirmada() {
        return confirmado;
    }

    public static boolean executar(CadastroCliente cadastroCliente, Cliente cliente) {
        JanelaCadastroCliente janelaCliente = new JanelaCadastroCliente(null, cadastroCliente, cliente);

        janelaCliente.setLocationRelativeTo(null);
        janelaCliente.setVisible(true);
        return janelaCliente.operacaoConfirmada();
        
    }

    /**
     * Creates new form Janela_Clientee
     */
    public JanelaCadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    

    public JanelaCadastroCliente(java.awt.Frame parent, CadastroCliente cadastroCliente, Cliente cliente) {
        super(parent, true);
        confirmado = false;
        this.cadastroCliente = cadastroCliente;
        this.cliente = cliente;

        initComponents();
        
        if (cadastroCliente == cadastroCliente.alterar || cadastroCliente == cadastroCliente.consultar) {
            /*int idCliente = cliente.getIdCliente();
            edIdCliente.setText(Integer.toString(idCliente));*/

            edNome.setText(cliente.getNome());
            edTel.setText(cliente.getTelefone());
            edEmail.setText(cliente.getEmail());
            edLogradouro.setText(cliente.getLogradouro());
            edNum.setText(cliente.getNumero());
            edComplemento.setText(cliente.getComplemento());
            edBairro.setText(cliente.getBairro());
            edCidade.setText(cliente.getCidade());
            edCep.setText(cliente.getCep());
        }

        botaoCancelar.setVisible(cadastroCliente != cadastroCliente.consultar);
        //edIdCliente.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edNome.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edTel.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edEmail.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edLogradouro.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edNum.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edComplemento.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edBairro.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edCidade.setEnabled(cadastroCliente != cadastroCliente.consultar);
        jComboEstado.setEnabled(cadastroCliente != cadastroCliente.consultar);
        edCep.setEnabled(cadastroCliente != cadastroCliente.consultar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        labelNum = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelLogradouro = new javax.swing.JLabel();
        labelComplemento = new javax.swing.JLabel();
        labelCidade = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        labelCep = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox<>();
        edNome = new javax.swing.JTextField();
        edEmail = new javax.swing.JTextField();
        edBairro = new javax.swing.JTextField();
        edLogradouro = new javax.swing.JTextField();
        edNum = new javax.swing.JTextField();
        edComplemento = new javax.swing.JTextField();
        edTel = new javax.swing.JTextField();
        edCidade = new javax.swing.JTextField();
        edCep = new javax.swing.JTextField();
        labelEstado = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelCadastroCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");

        labelNome.setText("Nome: ");

        labelTel.setText("Telefone:");

        labelNum.setText("Nº:");

        labelEmail.setText("E-mail:");

        labelLogradouro.setText("Logradouro:");

        labelComplemento.setText("Complemento:");

        labelCidade.setText("Cidade:");

        labelBairro.setText("Bairro:");

        labelCep.setText("CEP:");

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        jComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstadoActionPerformed(evt);
            }
        });

        edNome.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        edNome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        edNome.setSelectionColor(new java.awt.Color(153, 204, 255));
        edNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edNomeActionPerformed(evt);
            }
        });

        edEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edEmailActionPerformed(evt);
            }
        });

        edCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCidadeActionPerformed(evt);
            }
        });

        labelEstado.setText("Estado: ");

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        labelCadastroCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelCadastroCliente.setText("Cadastrar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCadastroCliente)
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelNome)
                                    .addGap(58, 58, 58))
                                .addComponent(labelTel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelLogradouro)
                                        .addComponent(labelComplemento, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(labelCidade)
                                    .addComponent(labelEstado))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(edCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(154, 154, 154))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edTel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(150, 150, 150))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCep)
                            .addComponent(labelNum)
                            .addComponent(labelEmail)
                            .addComponent(labelBairro))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(edEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addGap(38, 38, 38))
                                    .addComponent(edBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edCep, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edNum, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastroCliente)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(labelBairro))
                                    .addComponent(labelEmail))
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCep)
                                    .addComponent(edCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(edEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelNum)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(edBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLogradouro))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelComplemento))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoOk)
                    .addComponent(botaoCancelar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstadoActionPerformed

        String estadoSelecionado = (String) jComboEstado.getSelectedItem();
        cliente.setEstado(estadoSelecionado);
    }//GEN-LAST:event_jComboEstadoActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
           if (cadastroCliente != cadastroCliente.consultar) {
        clienteController.criarCliente(cliente);

        dispose();
    }
    dispose();

    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void edCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCidadeActionPerformed

    private void edNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edNomeActionPerformed

    private void edEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaCadastroCliente dialog = new JanelaCadastroCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoOk;
    private javax.swing.JTextField edBairro;
    private javax.swing.JTextField edCep;
    private javax.swing.JTextField edCidade;
    private javax.swing.JTextField edComplemento;
    private javax.swing.JTextField edEmail;
    private javax.swing.JTextField edLogradouro;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edNum;
    private javax.swing.JTextField edTel;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCadastroCliente;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelLogradouro;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNum;
    private javax.swing.JLabel labelTel;
    // End of variables declaration//GEN-END:variables
}
