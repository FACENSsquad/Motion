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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samsung
 */
public class Jpedido extends javax.swing.JFrame {
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

    public Jpedido(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        tabela_pedido();
        
        
    }
    
    
    
    private void tabela_pedido(){
        
        DefaultTableModel model = (DefaultTableModel) View_de_pedido.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        View_de_pedido.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        View_de_pedido.getColumnModel().getColumn(1).setPreferredWidth(10);
        View_de_pedido.getColumnModel().getColumn(2).setPreferredWidth(10);
        View_de_pedido.getColumnModel().getColumn(3).setPreferredWidth(10);
        View_de_pedido.getColumnModel().getColumn(4).setPreferredWidth(10);
        View_de_pedido.getColumnModel().getColumn(5).setPreferredWidth(10);

        try {
           Connection conn = new Conexao().Bd_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from pedido");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),

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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        produtos_inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lote = new javax.swing.JButton();
        quantidade = new javax.swing.JButton();
        data_validade1 = new javax.swing.JButton();
        data_validade2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_de_pedido = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        barra_top.setBackground(new java.awt.Color(235, 235, 235));
        barra_top.setForeground(new java.awt.Color(235, 235, 235));

        jTextField1.setBorder(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        jButton1.setBorder(null);

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
        jLabel2.setText("Pedido");

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

        lote.setBackground(new java.awt.Color(255, 255, 255));
        lote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_produto.png"))); // NOI18N
        lote.setBorder(null);
        lote.setBorderPainted(false);
        lote.setContentAreaFilled(false);
        lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteActionPerformed(evt);
            }
        });
        jPanel1.add(lote);
        lote.setBounds(410, 20, 56, 15);

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
        quantidade.setBounds(590, 20, 80, 15);

        data_validade1.setBackground(new java.awt.Color(255, 255, 255));
        data_validade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_descricao.png"))); // NOI18N
        data_validade1.setBorder(null);
        data_validade1.setBorderPainted(false);
        data_validade1.setContentAreaFilled(false);
        data_validade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_validade1ActionPerformed(evt);
            }
        });
        jPanel1.add(data_validade1);
        data_validade1.setBounds(780, 20, 65, 15);

        data_validade2.setBackground(new java.awt.Color(255, 255, 255));
        data_validade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_dataSaida.png"))); // NOI18N
        data_validade2.setBorder(null);
        data_validade2.setBorderPainted(false);
        data_validade2.setContentAreaFilled(false);
        data_validade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_validade2ActionPerformed(evt);
            }
        });
        jPanel1.add(data_validade2);
        data_validade2.setBounds(970, 20, 90, 15);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_lote.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 20, 41, 15);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_pedido.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 20, 48, 15);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusCycleRoot(true);
        jScrollPane1.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setInheritsPopupMenu(true);

        View_de_pedido.setAutoCreateRowSorter(true);
        View_de_pedido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        View_de_pedido.setTableHeader(null);
        View_de_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "codigo_produto", "lote", "produto", "quantidade", "descricao", "data_saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        View_de_pedido.setAlignmentY(2.0F);
        View_de_pedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        View_de_pedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        View_de_pedido.setDoubleBuffered(true);
        View_de_pedido.setDragEnabled(true);
        View_de_pedido.setFillsViewportHeight(true);
        View_de_pedido.setFocusCycleRoot(true);
        View_de_pedido.setFocusable(false);
        View_de_pedido.setGridColor(new java.awt.Color(255, 255, 255));
        View_de_pedido.setMaximumSize(new java.awt.Dimension(2147483647, 440));
        View_de_pedido.setMinimumSize(new java.awt.Dimension(100, 1040));
        View_de_pedido.setName(""); // NOI18N
        View_de_pedido.setPreferredSize(new java.awt.Dimension(400, 384));
        View_de_pedido.setRequestFocusEnabled(false);
        View_de_pedido.setRowHeight(40);
        View_de_pedido.setSelectionBackground(new java.awt.Color(255, 255, 255));
        View_de_pedido.setUpdateSelectionOnSort(false);
        View_de_pedido.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(View_de_pedido);
        if (View_de_pedido.getColumnModel().getColumnCount() > 0) {
            View_de_pedido.getColumnModel().getColumn(0).setResizable(false);
            View_de_pedido.getColumnModel().getColumn(1).setResizable(false);
            View_de_pedido.getColumnModel().getColumn(2).setResizable(false);
            View_de_pedido.getColumnModel().getColumn(3).setResizable(false);
            View_de_pedido.getColumnModel().getColumn(4).setResizable(false);
            View_de_pedido.getColumnModel().getColumn(5).setResizable(false);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(235, 235, 235));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botão_inserir.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barra_topLayout = new javax.swing.GroupLayout(barra_top);
        barra_top.setLayout(barra_topLayout);
        barra_topLayout.setHorizontalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barra_topLayout.createSequentialGroup()
                        .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(barra_topLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(barra_topLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        barra_topLayout.setVerticalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(barra_top);
        barra_top.setBounds(0, 0, 1200, 800);

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void data_validade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_validade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_validade1ActionPerformed

    private void data_validade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_validade2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_validade2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Jinserir_pedido jinserirPedido = new Jinserir_pedido();
        jinserirPedido.dispose();
        jinserirPedido.setSize(700, 600);
        jinserirPedido.setUndecorated(true);
        jinserirPedido.setLocationRelativeTo(null); 
        jinserirPedido.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Jpedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jpedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jpedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jpedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable View_de_pedido;
    private javax.swing.JPanel barra_top;
    private javax.swing.JButton data_validade1;
    private javax.swing.JButton data_validade2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lote;
    private javax.swing.JButton produtos_inicio;
    private javax.swing.JButton quantidade;
    // End of variables declaration//GEN-END:variables

    
}
