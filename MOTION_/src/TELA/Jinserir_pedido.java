
package TELA;

import BEAN.Pedido_bean;
import CONEXAO.Conexao;
import DAO.Pedido_dao;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class Jinserir_pedido extends javax.swing.JFrame {

    private Object Unidades;
    private Conexao conexao;
    private Connection conn;
    
    public void conexao_cadastrar(){
     this.conexao = new Conexao();
     this.conn = this.conexao.Bd_Conexao();
    }

    public Jinserir_pedido() {
        initComponents();
        //conexao_cadastrar();
       
        
       
    }

    public void update (){
    
        String sql = "update produto set produto = ?, unidade = ?, ncm = ? "
               + "where codigo = ?;";
        try {
            PreparedStatement pst2 = this.conn.prepareStatement(sql);
            pst2.setString(1, Caixa_produto.getText());
            //pst2.setString(2, (String) Campo_unidade.getSelectedItem());
            //pst2.setString(3, Caixa_ncm.getText());
            pst2.setInt(4, Integer.parseInt(Caixa_codigo.getText()));
            pst2.execute();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em classe Produtos_dao UPDATE");
        }  
    }
    
    
    public void consultar (){
    
        String sql = "select * from produto where codigo = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_produto.setText(rs.getString(2));
              //Campo_unidade.setSelectedItem(3);
              //Caixa_ncm.setText(rs.getString(4));
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Produto não encontrado");
                
               Caixa_produto.setText(null);
              //Campo_unidade.setSelectedItem(null);
              //Caixa_ncm.setText(null);
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
        }
        

    }
    
    public void delete(){
        
        int confirmar;
        String message = "Deseja realmente remover este produto?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from produto where codigo = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo DELETE");
            System.out.println(e);
                if (e instanceof SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null,"Possivelmente o item que você está tentando deletar está contido dentro de um LOTE. Tente apagar o lote desse produto e tente novamente.");
                }
            
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        produto1 = new javax.swing.JLabel();
        Caixa_produto1 = new javax.swing.JTextField();
        decrição = new javax.swing.JLabel();
        Caixa_descricao = new javax.swing.JTextField();
        produto = new javax.swing.JLabel();
        Caixa_produto = new javax.swing.JTextField();
        bt_cadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JToggleButton();
        Codigo = new javax.swing.JLabel();
        Caixa_codigo = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JToggleButton();
        Botton_deletar = new javax.swing.JButton();
        Caixa_produto2 = new javax.swing.JTextField();
        produto2 = new javax.swing.JLabel();
        Caixa_produto3 = new javax.swing.JTextField();
        produto3 = new javax.swing.JLabel();
        Caixa_produto4 = new javax.swing.JTextField();
        produto4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(697, 515));
        setName("cadasto de produtos"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 550));
        jPanel1.setLayout(null);

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setText("Atualizar ou Deletar ");
        jPanel1.add(titulo);
        titulo.setBounds(280, 350, 180, 22);

        produto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto1.setText("Lote:");
        jPanel1.add(produto1);
        produto1.setBounds(470, 80, 80, 17);

        Caixa_produto1.setBorder(null);
        Caixa_produto1.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produto1ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto1);
        Caixa_produto1.setBounds(470, 100, 90, 25);

        decrição.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        decrição.setText("Descrição:");
        jPanel1.add(decrição);
        decrição.setBounds(100, 200, 70, 17);

        Caixa_descricao.setBorder(null);
        jPanel1.add(Caixa_descricao);
        Caixa_descricao.setBounds(100, 220, 310, 50);

        produto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto.setText("Código do produto:");
        jPanel1.add(produto);
        produto.setBounds(100, 78, 260, 17);

        Caixa_produto.setBorder(null);
        Caixa_produto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produtoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto);
        Caixa_produto.setBounds(100, 101, 313, 25);

        bt_cadastrar.setBackground(new java.awt.Color(196, 196, 196));
        bt_cadastrar.setForeground(new java.awt.Color(196, 196, 196));
        bt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_salvar.png"))); // NOI18N
        bt_cadastrar.setBorder(null);
        bt_cadastrar.setBorderPainted(false);
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_cadastrar);
        bt_cadastrar.setBounds(500, 290, 85, 41);

        jButton1.setBackground(new java.awt.Color(208, 214, 216));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 290, 81, 40);

        Botton_consultar.setBackground(new java.awt.Color(255, 255, 255));
        Botton_consultar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        Botton_consultar.setBorder(null);
        Botton_consultar.setBorderPainted(false);
        Botton_consultar.setContentAreaFilled(false);
        Botton_consultar.setFocusCycleRoot(true);
        Botton_consultar.setFocusTraversalPolicyProvider(true);
        Botton_consultar.setRequestFocusEnabled(false);
        Botton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_consultar);
        Botton_consultar.setBounds(320, 375, 30, 20);

        Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Codigo.setText("Codigo:");
        jPanel1.add(Codigo);
        Codigo.setBounds(110, 410, 60, 17);

        Caixa_codigo.setBorder(null);
        Caixa_codigo.setPreferredSize(new java.awt.Dimension(4, 25));
        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(110, 430, 249, 25);

        titulo1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo1.setText("INSERIR PEDIDO");
        jPanel1.add(titulo1);
        titulo1.setBounds(280, 20, 150, 22);

        Botton_Atualizar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_Atualizar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_atualizar.png"))); // NOI18N
        Botton_Atualizar.setBorder(null);
        Botton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_AtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_Atualizar);
        Botton_Atualizar.setBounds(510, 480, 80, 40);

        Botton_deletar.setBackground(new java.awt.Color(209, 214, 216));
        Botton_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_deletar.png"))); // NOI18N
        Botton_deletar.setBorder(null);
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(410, 480, 80, 40);

        Caixa_produto2.setBorder(null);
        Caixa_produto2.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produto2ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto2);
        Caixa_produto2.setBounds(100, 160, 313, 25);

        produto2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto2.setText("Produto");
        jPanel1.add(produto2);
        produto2.setBounds(100, 140, 260, 17);

        Caixa_produto3.setBorder(null);
        Caixa_produto3.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produto3ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto3);
        Caixa_produto3.setBounds(470, 160, 90, 25);

        produto3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto3.setText("Quantidade:");
        jPanel1.add(produto3);
        produto3.setBounds(470, 140, 100, 17);

        Caixa_produto4.setBorder(null);
        Caixa_produto4.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produto4ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto4);
        Caixa_produto4.setBounds(470, 240, 140, 25);

        produto4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto4.setText("Data saída:");
        jPanel1.add(produto4);
        produto4.setBounds(470, 220, 100, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 550);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        
        try {
            String codigo, lote, produto, quantidade, descricao, datasaida;
            
            codigo = Caixa_produto.getText();
            lote = Caixa_produto1.getText();
            produto = Caixa_produto2.getText();
            quantidade = Caixa_produto3.getText();
            descricao = Caixa_descricao.getText();
            datasaida = Caixa_produto4.getText();

             
             Pedido_bean p_bean = new Pedido_bean();
             p_bean.setCodigo(parseInt(codigo));
             p_bean.setLote(parseInt(lote));
             p_bean.setProduto(produto);
             p_bean.setQuantidade(parseInt(quantidade));
             p_bean.setDescricao(descricao);
             p_bean.setDatasaida(datasaida);             
             
             Pedido_dao p_dao =  new Pedido_dao();
             p_dao.inserir(p_bean);
             
             Caixa_produto.setText("");
             Caixa_produto1.setText("");
             Caixa_produto2.setText("");
             Caixa_descricao.setText("");
             Caixa_produto4.setText("");
            
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
        }
        this.dispose();
        
        
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void Caixa_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produtoActionPerformed

    @SuppressWarnings("empty-statement")
    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed
        
     consultar();
    }//GEN-LAST:event_Botton_consultarActionPerformed

    private void Caixa_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
        update();
        
        dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
         delete();
         
         dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Caixa_produto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produto1ActionPerformed

    private void Caixa_produto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produto2ActionPerformed

    private void Caixa_produto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produto3ActionPerformed

    private void Caixa_produto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produto4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produto4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jinserir_pedido().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Botton_Atualizar;
    private javax.swing.JToggleButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_descricao;
    private javax.swing.JTextField Caixa_produto;
    private javax.swing.JTextField Caixa_produto1;
    private javax.swing.JTextField Caixa_produto2;
    private javax.swing.JTextField Caixa_produto3;
    private javax.swing.JTextField Caixa_produto4;
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JLabel decrição;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel produto;
    private javax.swing.JLabel produto1;
    private javax.swing.JLabel produto2;
    private javax.swing.JLabel produto3;
    private javax.swing.JLabel produto4;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
