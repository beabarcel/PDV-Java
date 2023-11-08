/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package PDV.views.janelas;

import conexao.Conexao;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pdv.entities.Produto;
import pdv.enums.CadastroProduto;

/**
 *
 * @author barce
 */
public class JanelaCadastroProduto extends javax.swing.JDialog {
    
    Conexao conectar = new Conexao();

    private CadastroProduto cadastroProduto;
    private Produto produto;
    private boolean confirmado;

    public boolean operacaoConfirmada() {
        return confirmado;
    }

    public static boolean executar(CadastroProduto cadastroProduto, Produto produto) {
        JanelaCadastroProduto janelaProduto = new JanelaCadastroProduto(null, cadastroProduto, produto);

        janelaProduto.setLocationRelativeTo(null);
        janelaProduto.setVisible(true);
        return janelaProduto.operacaoConfirmada();
    }

    /**
     * Creates new form JanelaCadastroProduto
     */
    public JanelaCadastroProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public JanelaCadastroProduto(java.awt.Frame parent, CadastroProduto cadastroProduto, Produto produto) {
        super(parent, true);
        confirmado = false;
        this.cadastroProduto = cadastroProduto;
        this.produto = produto;

        initComponents();
        //conectar.conexao();

        if (cadastroProduto == cadastroProduto.alterar || cadastroProduto == cadastroProduto.consultar) {
            /*int codProd = produto.getCodProd();
            edIdProduto.setText(Integer.toString(codProd));*/

            int quantProdEstoque = produto.getQuantProdEstoque();
            edQuantProdEstoque.setText(Integer.toString(quantProdEstoque));

            int unidProd = produto.getUnidProd();
            edUnidProd.setText(Integer.toString(unidProd));

            edNomeProd.setText(produto.getNomeProd());

            BigDecimal precoProd = produto.getPrecoProd();
            edPrecoProd.setText(precoProd.toString());

            Date dataVendaProd = produto.getDataVendaProd();
            SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formatoSaida.format(dataVendaProd);
            edDataVendaProd.setText(dataFormatada);
            edDataVendaProd.setText("");
        }

        botaoCancelar.setVisible(cadastroProduto != cadastroProduto.consultar);
        //edCodProd.setEnabled(cadastroProduto != cadastroProduto.consultar);
        edQuantProdEstoque.setEnabled(cadastroProduto != cadastroProduto.consultar);
        edUnidProd.setEnabled(cadastroProduto != cadastroProduto.consultar);
        edNomeProd.setEnabled(cadastroProduto != cadastroProduto.consultar);
        edPrecoProd.setEnabled(cadastroProduto != cadastroProduto.consultar);
        edDataVendaProd.setEnabled(cadastroProduto != cadastroProduto.consultar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelQuantProdEstoque = new javax.swing.JLabel();
        labelUnidProd = new javax.swing.JLabel();
        labelPrecoProd = new javax.swing.JLabel();
        labelDataVendaProd = new javax.swing.JLabel();
        labelNomeProd = new javax.swing.JLabel();
        edNomeProd = new javax.swing.JTextField();
        edDataVendaProd = new javax.swing.JTextField();
        edPrecoProd = new javax.swing.JTextField();
        edUnidProd = new javax.swing.JTextField();
        edQuantProdEstoque = new javax.swing.JTextField();
        labelCadastroProduto = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelQuantProdEstoque.setText("Quantidade em Estoque:");

        labelUnidProd.setText("Unidade:");

        labelPrecoProd.setText("Preço:");

        labelDataVendaProd.setText("Data da última venda: ");

        labelNomeProd.setText("Nome:");

        labelCadastroProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelCadastroProduto.setText("Cadastrar Produto");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelQuantProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edQuantProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(edNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(edPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(labelUnidProd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(edUnidProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(labelDataVendaProd)
                                            .addGap(18, 18, 18)
                                            .addComponent(edDataVendaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)))))))
                    .addComponent(labelNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelCadastroProduto)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeProd)
                    .addComponent(edNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edUnidProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUnidProd)
                    .addComponent(edPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecoProd))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelQuantProdEstoque)
                        .addComponent(edQuantProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDataVendaProd)
                        .addComponent(edDataVendaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOk))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed

        if (cadastroProduto != cadastroProduto.consultar) {
            /*String codProdTexto = edIdProduto.getText();
            int codProd = Integer.parseInt(codProdTexto);
            produto.setCodProd(codProd);*/

            String quantProdEstoqueTexto = edQuantProdEstoque.getText();
            int quantProdEstoque = Integer.parseInt(quantProdEstoqueTexto);
            produto.setQuantProdEstoque(quantProdEstoque);

            String unidProdTexto = edUnidProd.getText();
            int unidProd = Integer.parseInt(unidProdTexto);
            produto.setUnidProd(unidProd);

            produto.setNomeProd(edNomeProd.getText());

            String precoProdTexto = edPrecoProd.getText();
            BigDecimal precoProd = new BigDecimal(precoProdTexto);
            produto.setPrecoProd(precoProd);

            String dataVendaProdTexto = edDataVendaProd.getText();
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

            try {
                Date dataVendaProdUtil = formatoEntrada.parse(dataVendaProdTexto);
                java.sql.Date dataVendaProdSQL = new java.sql.Date(dataVendaProdUtil.getTime());
                produto.setDataVendaProd(dataVendaProdSQL);

            } catch (ParseException e) {
                System.err.println("Ocorreu um erro ao converter a data. Certifique-se de inserir a data no formato dd/MM/yyyy.");
            }

            /*ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.incluir(produto);*/
        }
        dispose();
    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed
    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        
        String [] Colunas = new String[]{"Código Produto", "Quantidade em estoque", "Unidade", "Nome", "Preço", "Data da venda"};
     
    }

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
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaCadastroProduto dialog = new JanelaCadastroProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField edDataVendaProd;
    private javax.swing.JTextField edNomeProd;
    private javax.swing.JTextField edPrecoProd;
    private javax.swing.JTextField edQuantProdEstoque;
    private javax.swing.JTextField edUnidProd;
    private javax.swing.JLabel labelCadastroProduto;
    private javax.swing.JLabel labelDataVendaProd;
    private javax.swing.JLabel labelNomeProd;
    private javax.swing.JLabel labelPrecoProd;
    private javax.swing.JLabel labelQuantProdEstoque;
    private javax.swing.JLabel labelUnidProd;
    // End of variables declaration//GEN-END:variables
}
