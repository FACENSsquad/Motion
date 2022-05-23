/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Produtos_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samsung
 */
public final class Jlote extends javax.swing.JFrame {
    boolean isAdmin;
    String userName;

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Jlote(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        tabela_lote();

    }
    
    public void tabela_lote(){
        
        DefaultTableModel model = (DefaultTableModel) View_de_lotes.getModel();
        model.setNumRows(0);
        
        View_de_lotes.getColumnModel().getColumn(0).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(1).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(2).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(3).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(4).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(5).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(6).setPreferredWidth(10);
        View_de_lotes.getColumnModel().getColumn(7).setPreferredWidth(10);
        
        try{
            Connection connl = new Conexao().Bd_Conexao();
            PreparedStatement pst;
            ResultSet rs;
            
            pst = connl.prepareStatement("select * from lote");
            rs = pst.executeQuery();
            
            while (rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                });
            }
        }
        catch(SQLException e ){
            System.out.println("Erro tabela_produto "+ e);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra_top = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cadastrar_produto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        codigo = new javax.swing.JButton();
        produto = new javax.swing.JButton();
        unidade = new javax.swing.JButton();
        quantidade = new javax.swing.JButton();
        valor = new javax.swing.JButton();
        fornecedor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_de_lotes = new javax.swing.JTable();
        Botton_atualizar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(null);

        barra_top.setBackground(new java.awt.Color(235, 235, 235));
        barra_top.setForeground(new java.awt.Color(235, 235, 235));
        barra_top.setMinimumSize(new java.awt.Dimension(1200, 800));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));

        inicio.setBackground(new java.awt.Color(173, 216, 230));
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_inicio.png"))); // NOI18N
        inicio.setBorder(null);
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setFocusPainted(false);
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 235, 235));
        jLabel1.setText("MotiON");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 235, 235));
        jLabel2.setText("Lotes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(444, 444, 444)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Cadastrar_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cadastrar_item.png"))); // NOI18N
        Cadastrar_produto.setBorder(null);
        Cadastrar_produto.setOpaque(false);
        Cadastrar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar_produtoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        codigo.setBackground(new java.awt.Color(255, 255, 255));
        codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_codigo.png"))); // NOI18N
        codigo.setBorder(null);
        codigo.setBorderPainted(false);
        codigo.setContentAreaFilled(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        jPanel1.add(codigo);
        codigo.setBounds(20, 20, 52, 15);

        produto.setBackground(new java.awt.Color(255, 255, 255));
        produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_produto.png"))); // NOI18N
        produto.setBorder(null);
        produto.setBorderPainted(false);
        produto.setContentAreaFilled(false);
        produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoActionPerformed(evt);
            }
        });
        jPanel1.add(produto);
        produto.setBounds(210, 20, 56, 15);

        unidade.setBackground(new java.awt.Color(255, 255, 255));
        unidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_unidade.png"))); // NOI18N
        unidade.setBorder(null);
        unidade.setBorderPainted(false);
        unidade.setContentAreaFilled(false);
        jPanel1.add(unidade);
        unidade.setBounds(400, 20, 60, 15);

        quantidade.setBackground(new java.awt.Color(255, 255, 255));
        quantidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_quantidade.png"))); // NOI18N
        quantidade.setBorder(null);
        quantidade.setBorderPainted(false);
        quantidade.setContentAreaFilled(false);
        jPanel1.add(quantidade);
        quantidade.setBounds(590, 20, 80, 15);

        valor.setBackground(new java.awt.Color(255, 255, 255));
        valor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_valor.png"))); // NOI18N
        valor.setBorder(null);
        valor.setBorderPainted(false);
        valor.setContentAreaFilled(false);
        jPanel1.add(valor);
        valor.setBounds(790, 20, 50, 15);

        fornecedor.setBackground(new java.awt.Color(255, 255, 255));
        fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_fornecedor.png"))); // NOI18N
        fornecedor.setBorder(null);
        fornecedor.setBorderPainted(false);
        fornecedor.setContentAreaFilled(false);
        fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(fornecedor);
        fornecedor.setBounds(980, 20, 80, 15);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusTraversalPolicyProvider(true);

        View_de_lotes.setBackground(new java.awt.Color(255, 255, 255));
        View_de_lotes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        View_de_lotes.setTableHeader(null);
        View_de_lotes.setForeground(new java.awt.Color(0, 0, 0));
        View_de_lotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "lote", "l_produto", "quantidade", "valor", "alocacao", "data_v", "fornecedor", "data_e"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        View_de_lotes.setColumnSelectionAllowed(false);
        View_de_lotes.setEnabled(false);
        View_de_lotes.setFillsViewportHeight(true);
        View_de_lotes.setFocusTraversalPolicyProvider(true);
        View_de_lotes.setGridColor(new java.awt.Color(255, 255, 255));
        View_de_lotes.setPreferredSize(new java.awt.Dimension(400, 384));
        View_de_lotes.setRowHeight(40);
        View_de_lotes.setSelectionBackground(new java.awt.Color(255, 255, 255));
        View_de_lotes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        View_de_lotes.setShowHorizontalLines(false);
        View_de_lotes.setShowVerticalLines(false);
        jScrollPane1.setViewportView(View_de_lotes);
        if (View_de_lotes.getColumnModel().getColumnCount() > 0) {
            View_de_lotes.getColumnModel().getColumn(0).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(1).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(2).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(3).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(4).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(5).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(6).setResizable(false);
            View_de_lotes.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Botton_atualizar.setBackground(new java.awt.Color(235, 235, 235));
        Botton_atualizar.setForeground(new java.awt.Color(0, 0, 0));
        Botton_atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/atualizar.png"))); // NOI18N
        Botton_atualizar.setBorder(null);
        Botton_atualizar.setContentAreaFilled(false);
        Botton_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barra_topLayout = new javax.swing.GroupLayout(barra_top);
        barra_top.setLayout(barra_topLayout);
        barra_topLayout.setHorizontalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barra_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barra_topLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(barra_topLayout.createSequentialGroup()
                        .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        barra_topLayout.setVerticalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5, Short.MAX_VALUE))
        );

        getContentPane().add(barra_top);
        barra_top.setBounds(0, 0, 1340, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_produtoActionPerformed
       if (isAdmin == true){
        Jcadastrar_lote jcadastrar = new Jcadastrar_lote();
       jcadastrar.setVisible(true);}
       else{
       JOptionPane.showMessageDialog(null, "Você não possui privilégios de admin para realizar essa ação!");
        }

    }//GEN-LAST:event_Cadastrar_produtoActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtoActionPerformed

    private void fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedorActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        Jhome jhome = new Jhome(isAdmin, userName);
        jhome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicioActionPerformed

    private void Botton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_atualizarActionPerformed
        Jlote jlote = new Jlote(isAdmin, userName);
        jlote.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Botton_atualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Jlote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jlote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jlote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jlote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botton_atualizar;
    private javax.swing.JButton Cadastrar_produto;
    private javax.swing.JTable View_de_lotes;
    private javax.swing.JPanel barra_top;
    private javax.swing.JButton codigo;
    private javax.swing.JButton fornecedor;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton produto;
    private javax.swing.JButton quantidade;
    private javax.swing.JButton unidade;
    private javax.swing.JButton valor;
    // End of variables declaration//GEN-END:variables

    private void Bd_Conexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void produtos_b(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
