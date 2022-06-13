
package TELA;

import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class Jinserir_pedido extends javax.swing.JFrame {


    private Conexao conexao;
    private Connection conn;
    
    public void conexao_cadastrar(){
     this.conexao = new Conexao();
     this.conn = this.conexao.Bd_Conexao();
    }

    public Jinserir_pedido() {
        initComponents();
        
       
        
       
    }
    
     public void inserir(){
    
        String sql = "insert into pedidos(codigo, lote, produto, quantidade, descricao, dataSaida)"
                + " values(?, ?, ?, ?, ?, ?)";
    
        try {
            
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(Caixa_CodigoProduto.getText()));
            pst.setInt(2, Integer.parseInt(Caixa_codigoLote.getText()));
            pst.setString(3, Caixa_NomeProduto.getText());
            pst.setInt(4, Integer.parseInt(Caixa_quantidade.getText()));
            pst.setString(5, Caixa_descricao.getText());
            pst.setString(6, Caixa_dataSaida.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Pedido realizado");
            
        } catch (Exception e) {
            System.out.println(e);
        } 
        
     }

    public void update (){
    
        String sql = "update pedidos set codigo = ?, lote = ?, produto = ?, quantidade = ?, descricao = ?, dataSaida = ? "
               + "where codigo = ?;";
        try {
            PreparedStatement pst2 = this.conn.prepareStatement(sql);
            pst2.setInt(1, Integer.parseInt(Caixa_CodigoProduto.getText()));
            pst2.setInt(2, Integer.parseInt(Caixa_codigoLote.getText()));
            pst2.setString(3, Caixa_NomeProduto.getText());
            pst2.setInt(4, Integer.parseInt(Caixa_quantidade.getText()));
            pst2.setString(5, Caixa_descricao.getText());
            pst2.setString(6, Caixa_dataSaida.getText());
            
            pst2.execute();
            
            JOptionPane.showMessageDialog(null, "Pedido atualizado");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em metodo update de pedidos");
        }  
    }
    
    
    public void consultar (){
    
        String sql = "select * from pedidos where codigo = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_CodigoProduto.setText(rs.getString(2));
             
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Pedido não encontrado");
                
               Caixa_CodigoProduto.setText(null);
               Caixa_NomeProduto.setText(null);
               Caixa_codigo.setText(null);
               Caixa_codigoLote.setText(null);
               Caixa_dataSaida.setText(null);
               Caixa_descricao.setText(null);
               Caixa_quantidade.setText(null);
              
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
        }
        

    }
    
    public void delete(){
        
        int confirmar;
        String message = "Deseja realmente remover este pedido?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from pedidos where codigo = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo DELETE");
            System.out.println(e);
                if (e instanceof SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null,"error");
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
        Caixa_codigoLote = new javax.swing.JTextField();
        decrição = new javax.swing.JLabel();
        Caixa_descricao = new javax.swing.JTextField();
        produto = new javax.swing.JLabel();
        Caixa_CodigoProduto = new javax.swing.JTextField();
        Botton_cadastrar = new javax.swing.JButton();
        Botton_cancelar = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JToggleButton();
        Codigo = new javax.swing.JLabel();
        Caixa_codigo = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JToggleButton();
        Botton_deletar = new javax.swing.JButton();
        Caixa_NomeProduto = new javax.swing.JTextField();
        produto2 = new javax.swing.JLabel();
        Caixa_quantidade = new javax.swing.JTextField();
        produto3 = new javax.swing.JLabel();
        Caixa_dataSaida = new javax.swing.JTextField();
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

        Caixa_codigoLote.setBorder(null);
        Caixa_codigoLote.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_codigoLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoLoteActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigoLote);
        Caixa_codigoLote.setBounds(470, 100, 90, 25);

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

        Caixa_CodigoProduto.setBorder(null);
        Caixa_CodigoProduto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_CodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_CodigoProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_CodigoProduto);
        Caixa_CodigoProduto.setBounds(100, 101, 313, 25);

        Botton_cadastrar.setBackground(new java.awt.Color(196, 196, 196));
        Botton_cadastrar.setForeground(new java.awt.Color(196, 196, 196));
        Botton_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_salvar.png"))); // NOI18N
        Botton_cadastrar.setBorder(null);
        Botton_cadastrar.setBorderPainted(false);
        Botton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_cadastrar);
        Botton_cadastrar.setBounds(500, 290, 85, 40);

        Botton_cancelar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        Botton_cancelar.setBorder(null);
        Botton_cancelar.setBorderPainted(false);
        Botton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_cancelar);
        Botton_cancelar.setBounds(400, 290, 80, 40);

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
        Botton_consultar.setBounds(370, 430, 30, 30);

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

        Caixa_NomeProduto.setBorder(null);
        Caixa_NomeProduto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_NomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_NomeProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_NomeProduto);
        Caixa_NomeProduto.setBounds(100, 160, 313, 25);

        produto2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto2.setText("Produto");
        jPanel1.add(produto2);
        produto2.setBounds(100, 140, 260, 17);

        Caixa_quantidade.setBorder(null);
        Caixa_quantidade.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_quantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_quantidade);
        Caixa_quantidade.setBounds(470, 160, 90, 25);

        produto3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto3.setText("Quantidade:");
        jPanel1.add(produto3);
        produto3.setBounds(470, 140, 100, 17);

        Caixa_dataSaida.setBorder(null);
        Caixa_dataSaida.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_dataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_dataSaidaActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_dataSaida);
        Caixa_dataSaida.setBounds(470, 240, 140, 25);

        produto4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto4.setText("Data saída:");
        jPanel1.add(produto4);
        produto4.setBounds(470, 220, 100, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 550);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void Botton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cadastrarActionPerformed
        
       inserir();
        
       dispose();
        
    }//GEN-LAST:event_Botton_cadastrarActionPerformed

    private void Caixa_CodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_CodigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_CodigoProdutoActionPerformed

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

    private void Caixa_codigoLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoLoteActionPerformed

    private void Caixa_NomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_NomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_NomeProdutoActionPerformed

    private void Caixa_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_quantidadeActionPerformed

    private void Caixa_dataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_dataSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_dataSaidaActionPerformed

    private void Botton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_Botton_cancelarActionPerformed

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
    private javax.swing.JButton Botton_cadastrar;
    private javax.swing.JButton Botton_cancelar;
    private javax.swing.JToggleButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_CodigoProduto;
    private javax.swing.JTextField Caixa_NomeProduto;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_codigoLote;
    private javax.swing.JTextField Caixa_dataSaida;
    private javax.swing.JTextField Caixa_descricao;
    private javax.swing.JTextField Caixa_quantidade;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel decrição;
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
