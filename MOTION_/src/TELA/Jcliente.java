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


public class Jcliente extends javax.swing.JFrame {
    boolean isAdmin;
    String userName;

    public Jcliente(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        tabela_cliente();
        
    }

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
    
    
    
    private void tabela_cliente(){
        
        DefaultTableModel model = (DefaultTableModel) View_de_cliente.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        View_de_cliente.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        View_de_cliente.getColumnModel().getColumn(1).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(2).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(3).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(4).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(5).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(6).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(7).setPreferredWidth(10);
        View_de_cliente.getColumnModel().getColumn(8).setPreferredWidth(10);
        
        try {
           Connection conn = new Conexao().Bd_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from cliente");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getString(7),
                   rs.getString(8),
                   rs.getString(9)
                   
               });
           
           }
        } catch (SQLException e) {
            System.out.println("Erro tabela_cliente");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra_top = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cadastrar_produto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_de_cliente = new javax.swing.JTable();
        Botton_atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        barra_top.setBackground(new java.awt.Color(235, 235, 235));
        barra_top.setForeground(new java.awt.Color(235, 235, 235));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));

        jButton2.setBackground(new java.awt.Color(173, 216, 230));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_inicio.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 235, 235));
        jLabel1.setText("MotiON");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 235, 235));
        jLabel2.setText("Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(494, 494, 494)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("UF");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(820, 20, 30, 19);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Endereço");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1060, 20, 80, 19);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("CPF / CNPJ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 20, 80, 19);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Municipio");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(930, 20, 80, 19);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("CEP");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 20, 80, 19);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 20, 80, 19);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Código");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 20, 80, 19);

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Telefone");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(420, 20, 80, 19);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nome");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(170, 20, 80, 19);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        View_de_cliente.setAutoCreateRowSorter(true);
        View_de_cliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        View_de_cliente.setTableHeader(null);
        View_de_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF // CNPJ", "Telefone", "Email", "Cep", "UF", "Municipio", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        View_de_cliente.setAlignmentY(2.0F);
        View_de_cliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        View_de_cliente.setAutoscrolls(false);
        View_de_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        View_de_cliente.setDoubleBuffered(true);
        View_de_cliente.setDragEnabled(true);
        View_de_cliente.setEnabled(false);
        View_de_cliente.setFillsViewportHeight(true);
        View_de_cliente.setFocusable(false);
        View_de_cliente.setGridColor(new java.awt.Color(255, 255, 255));
        View_de_cliente.setMaximumSize(new java.awt.Dimension(2147483647, 440));
        View_de_cliente.setMinimumSize(new java.awt.Dimension(100, 1040));
        View_de_cliente.setPreferredSize(new java.awt.Dimension(400, 384));
        View_de_cliente.setRowHeight(40);
        View_de_cliente.setSelectionBackground(new java.awt.Color(255, 255, 255));
        View_de_cliente.setUpdateSelectionOnSort(false);
        View_de_cliente.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(View_de_cliente);
        if (View_de_cliente.getColumnModel().getColumnCount() > 0) {
            View_de_cliente.getColumnModel().getColumn(0).setResizable(false);
            View_de_cliente.getColumnModel().getColumn(1).setResizable(false);
            View_de_cliente.getColumnModel().getColumn(2).setResizable(false);
            View_de_cliente.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        Botton_atualizar.setBackground(new java.awt.Color(235, 235, 235));
        Botton_atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/atualizar.png"))); // NOI18N
        Botton_atualizar.setBorder(null);
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
            .addGroup(barra_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(barra_topLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        barra_topLayout.setVerticalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(barra_top);
        barra_top.setBounds(0, 0, 1200, 800);

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_produtoActionPerformed
        if (isAdmin == true){
        Jcadastrar_cliente jcadastrar = new Jcadastrar_cliente();
        jcadastrar.dispose();
        jcadastrar.setSize(700, 600);
        jcadastrar.setUndecorated(true);
        jcadastrar.setLocationRelativeTo(null); 
        jcadastrar.setVisible(true);
        }
        else{
        JOptionPane.showMessageDialog(null, "Você não possui privilégios de admin para realizar essa ação!");
        }
    }//GEN-LAST:event_Cadastrar_produtoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Jhome jhome = new Jhome(isAdmin, userName);
        jhome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Botton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_atualizarActionPerformed
        Jcliente jcliente = new Jcliente(isAdmin, userName);
        jcliente.setVisible(true);
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
            java.util.logging.Logger.getLogger(Jcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable View_de_cliente;
    private javax.swing.JPanel barra_top;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
