/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

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
public class Jestoque extends javax.swing.JFrame {
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

    public Jestoque(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        tabela_estoque();
        
        
    }
    
    
    
    private void tabela_estoque(){
        
        DefaultTableModel model = (DefaultTableModel) View_de_estoque.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        View_de_estoque.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        View_de_estoque.getColumnModel().getColumn(1).setPreferredWidth(10);
        View_de_estoque.getColumnModel().getColumn(2).setPreferredWidth(10);
        View_de_estoque.getColumnModel().getColumn(3).setPreferredWidth(10);
        View_de_estoque.getColumnModel().getColumn(4).setPreferredWidth(10);
        View_de_estoque.getColumnModel().getColumn(5).setPreferredWidth(10);
        View_de_estoque.getColumnModel().getColumn(6).setPreferredWidth(10);
        
        try {
           Connection conn = new Conexao().Bd_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from todos_lotes_quantidade");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getString(7),
                   
               });
           // Fechar banco aqui
           }
        } catch (SQLException e) {
            System.out.println("Erro tabela_estoque");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra_top = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        produtos_inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        produto = new javax.swing.JButton();
        lote = new javax.swing.JButton();
        quantidade = new javax.swing.JButton();
        valor_un = new javax.swing.JButton();
        alocacao = new javax.swing.JButton();
        data_validade = new javax.swing.JButton();
        data_validade1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_de_estoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(null);

        barra_top.setBackground(new java.awt.Color(235, 235, 235));
        barra_top.setForeground(new java.awt.Color(235, 235, 235));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));

        produtos_inicio.setBackground(new java.awt.Color(173, 216, 230));
        produtos_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_inicio.png"))); // NOI18N
        produtos_inicio.setBorder(null);
        produtos_inicio.setBorderPainted(false);
        produtos_inicio.setContentAreaFilled(false);
        produtos_inicio.setFocusPainted(false);
        produtos_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtos_inicioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 235, 235));
        jLabel1.setText("MotiON");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 235, 235));
        jLabel2.setText("Estoque");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(433, 433, 433)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(produtos_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(produtos_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

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
        produto.setBounds(20, 20, 56, 15);

        lote.setBackground(new java.awt.Color(255, 255, 255));
        lote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_lote.png"))); // NOI18N
        lote.setBorder(null);
        lote.setBorderPainted(false);
        lote.setContentAreaFilled(false);
        lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteActionPerformed(evt);
            }
        });
        jPanel1.add(lote);
        lote.setBounds(180, 20, 34, 15);

        quantidade.setBackground(new java.awt.Color(255, 255, 255));
        quantidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_quantidade.png"))); // NOI18N
        quantidade.setBorder(null);
        quantidade.setBorderPainted(false);
        quantidade.setContentAreaFilled(false);
        quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(quantidade);
        quantidade.setBounds(340, 20, 80, 15);

        valor_un.setBackground(new java.awt.Color(255, 255, 255));
        valor_un.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_valorUn.png"))); // NOI18N
        valor_un.setBorder(null);
        valor_un.setBorderPainted(false);
        valor_un.setContentAreaFilled(false);
        valor_un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valor_unActionPerformed(evt);
            }
        });
        jPanel1.add(valor_un);
        valor_un.setBounds(500, 20, 57, 15);

        alocacao.setBackground(new java.awt.Color(255, 255, 255));
        alocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_alocacao.png"))); // NOI18N
        alocacao.setBorder(null);
        alocacao.setBorderPainted(false);
        alocacao.setContentAreaFilled(false);
        alocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoActionPerformed(evt);
            }
        });
        jPanel1.add(alocacao);
        alocacao.setBounds(670, 20, 60, 15);

        data_validade.setBackground(new java.awt.Color(255, 255, 255));
        data_validade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_datavalidade.png"))); // NOI18N
        data_validade.setBorder(null);
        data_validade.setBorderPainted(false);
        data_validade.setContentAreaFilled(false);
        data_validade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_validadeActionPerformed(evt);
            }
        });
        jPanel1.add(data_validade);
        data_validade.setBounds(830, 20, 90, 15);

        data_validade1.setBackground(new java.awt.Color(255, 255, 255));
        data_validade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_dataEntrada.png"))); // NOI18N
        data_validade1.setBorder(null);
        data_validade1.setBorderPainted(false);
        data_validade1.setContentAreaFilled(false);
        data_validade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_validade1ActionPerformed(evt);
            }
        });
        jPanel1.add(data_validade1);
        data_validade1.setBounds(1000, 20, 82, 15);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusCycleRoot(true);
        jScrollPane1.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setInheritsPopupMenu(true);

        View_de_estoque.setAutoCreateRowSorter(true);
        View_de_estoque.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        View_de_estoque.setTableHeader(null);
        View_de_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "produto", "lote", "quantidade", "valor", "alocacao", "data_v", "data_e"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        View_de_estoque.setAlignmentY(2.0F);
        View_de_estoque.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        View_de_estoque.setColumnSelectionAllowed(false);
        View_de_estoque.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        View_de_estoque.setDoubleBuffered(true);
        View_de_estoque.setDragEnabled(true);
        View_de_estoque.setFillsViewportHeight(true);
        View_de_estoque.setFocusCycleRoot(true);
        View_de_estoque.setFocusable(false);
        View_de_estoque.setGridColor(new java.awt.Color(255, 255, 255));
        View_de_estoque.setMaximumSize(new java.awt.Dimension(2147483647, 440));
        View_de_estoque.setMinimumSize(new java.awt.Dimension(100, 1040));
        View_de_estoque.setName(""); // NOI18N
        View_de_estoque.setPreferredSize(new java.awt.Dimension(400, 384));
        View_de_estoque.setRequestFocusEnabled(false);
        View_de_estoque.setRowHeight(40);
        View_de_estoque.setSelectionBackground(new java.awt.Color(255, 255, 255));
        View_de_estoque.setUpdateSelectionOnSort(false);
        View_de_estoque.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(View_de_estoque);
        if (View_de_estoque.getColumnModel().getColumnCount() > 0) {
            View_de_estoque.getColumnModel().getColumn(0).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(1).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(2).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(3).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(4).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(5).setResizable(false);
            View_de_estoque.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout barra_topLayout = new javax.swing.GroupLayout(barra_top);
        barra_top.setLayout(barra_topLayout);
        barra_topLayout.setHorizontalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(barra_topLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        barra_topLayout.setVerticalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(barra_top);
        barra_top.setBounds(0, 0, 1200, 800);

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtoActionPerformed

    private void produtos_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtos_inicioActionPerformed
        Jhome jhome = new Jhome(isAdmin, userName);
        jhome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_produtos_inicioActionPerformed

    private void loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loteActionPerformed

    private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeActionPerformed

    private void valor_unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valor_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valor_unActionPerformed

    private void alocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoActionPerformed

    private void data_validadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_validadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_validadeActionPerformed

    private void data_validade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_validade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_validade1ActionPerformed

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
            java.util.logging.Logger.getLogger(Jestoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jestoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jestoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jestoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable View_de_estoque;
    private javax.swing.JButton alocacao;
    private javax.swing.JPanel barra_top;
    private javax.swing.JButton data_validade;
    private javax.swing.JButton data_validade1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lote;
    private javax.swing.JButton produto;
    private javax.swing.JButton produtos_inicio;
    private javax.swing.JButton quantidade;
    private javax.swing.JButton valor_un;
    // End of variables declaration//GEN-END:variables

    
}
