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
public class Jfornecedor extends javax.swing.JFrame {
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

    public Jfornecedor(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        tabela_fonecedores();
        
        
    }
    
    
    
    private void tabela_fonecedores(){
        
        DefaultTableModel model = (DefaultTableModel) View_de_fornecedores.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        View_de_fornecedores.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        View_de_fornecedores.getColumnModel().getColumn(1).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(2).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(3).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(4).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(5).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(6).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(7).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(8).setPreferredWidth(10);
        View_de_fornecedores.getColumnModel().getColumn(9).setPreferredWidth(10);
        
        try {
           Connection conn = new Conexao().Bd_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from fornecedores");  // passando conexao para pst
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
                   rs.getString(9),
                   rs.getString(10)
                   
               });
           // Fechar banco aqui
           }
        } catch (SQLException e) {
            System.out.println("Erro tabela_fornecedores");
        }
    }

    /*Connection conn;
    
    public ResultSet view_produtos(Produtos_bean p_bean){
        conn = new Conexao().Bd_Conexao(); 
        return null;
    }
    
    public Jproduto() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        show_produtos();
        
         
        
    }
    public ArrayList<Produtos_bean> userList(){
        ArrayList<Produtos_bean> userList = new ArrayList<>();
        try{ 
            String sql = "select * from produto";
            Statement st = this.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            Produtos_bean produtos_b = new Produtos_bean();
            while(rs.next()){
            produtos_b(rs.getInt("codigo"),rs.getString("produto"),rs.getString("tipo"),rs.getString("ncm"));
            userList.add(produtos_b);
            }
            
        }   
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao exibir produtos em ArrayList "+e);
        }
        return userList;
    }
    public void show_produtos(){
        
        ArrayList<Produtos_bean> list = userList();
        DefaultTableModel model = (DefaultTableModel)View_de_produtos.getModel();
    
        Object[] row =  new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getProduto();
            row[2] = list.get(i).getTipo();
            row[4] = list.get(i).getNcm();
            model.addRow(row);
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
        produtos_inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cadastrar_produto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        codigo = new javax.swing.JButton();
        ncm = new javax.swing.JButton();
        ncm1 = new javax.swing.JButton();
        ncm2 = new javax.swing.JButton();
        ncm3 = new javax.swing.JButton();
        ncm4 = new javax.swing.JButton();
        ncm5 = new javax.swing.JButton();
        ncm6 = new javax.swing.JButton();
        ncm7 = new javax.swing.JButton();
        ncm8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_de_fornecedores = new javax.swing.JTable();
        Botton_atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel2.setText("Fornecedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(425, 425, 425)
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

        Cadastrar_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cadastrar_item.png"))); // NOI18N
        Cadastrar_produto.setBorder(null);
        Cadastrar_produto.setOpaque(false);
        Cadastrar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar_produtoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        jButton1.setBorder(null);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);

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
        codigo.setBounds(10, 20, 52, 15);

        ncm.setBackground(new java.awt.Color(255, 255, 255));
        ncm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_telefone.png"))); // NOI18N
        ncm.setBorder(null);
        ncm.setBorderPainted(false);
        ncm.setContentAreaFilled(false);
        jPanel1.add(ncm);
        ncm.setBounds(470, 20, 60, 15);

        ncm1.setBackground(new java.awt.Color(255, 255, 255));
        ncm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_endereco.png"))); // NOI18N
        ncm1.setBorder(null);
        ncm1.setBorderPainted(false);
        ncm1.setContentAreaFilled(false);
        jPanel1.add(ncm1);
        ncm1.setBounds(1040, 20, 70, 15);

        ncm2.setBackground(new java.awt.Color(255, 255, 255));
        ncm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_razao.png"))); // NOI18N
        ncm2.setBorder(null);
        ncm2.setBorderPainted(false);
        ncm2.setContentAreaFilled(false);
        jPanel1.add(ncm2);
        ncm2.setBounds(130, 20, 43, 15);

        ncm3.setBackground(new java.awt.Color(255, 255, 255));
        ncm3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_nomeFantasia.png"))); // NOI18N
        ncm3.setBorder(null);
        ncm3.setBorderPainted(false);
        ncm3.setContentAreaFilled(false);
        jPanel1.add(ncm3);
        ncm3.setBounds(240, 20, 100, 15);

        ncm4.setBackground(new java.awt.Color(255, 255, 255));
        ncm4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_cnpj.png"))); // NOI18N
        ncm4.setBorder(null);
        ncm4.setBorderPainted(false);
        ncm4.setContentAreaFilled(false);
        jPanel1.add(ncm4);
        ncm4.setBounds(360, 20, 39, 15);

        ncm5.setBackground(new java.awt.Color(255, 255, 255));
        ncm5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_email.png"))); // NOI18N
        ncm5.setBorder(null);
        ncm5.setBorderPainted(false);
        ncm5.setContentAreaFilled(false);
        jPanel1.add(ncm5);
        ncm5.setBounds(590, 20, 50, 15);

        ncm6.setBackground(new java.awt.Color(255, 255, 255));
        ncm6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_cep.png"))); // NOI18N
        ncm6.setBorder(null);
        ncm6.setBorderPainted(false);
        ncm6.setContentAreaFilled(false);
        jPanel1.add(ncm6);
        ncm6.setBounds(700, 20, 30, 15);

        ncm7.setBackground(new java.awt.Color(255, 255, 255));
        ncm7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_uf.png"))); // NOI18N
        ncm7.setBorder(null);
        ncm7.setBorderPainted(false);
        ncm7.setContentAreaFilled(false);
        jPanel1.add(ncm7);
        ncm7.setBounds(810, 20, 20, 15);

        ncm8.setBackground(new java.awt.Color(255, 255, 255));
        ncm8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/filtro_cidade.png"))); // NOI18N
        ncm8.setBorder(null);
        ncm8.setBorderPainted(false);
        ncm8.setContentAreaFilled(false);
        jPanel1.add(ncm8);
        ncm8.setBounds(930, 20, 50, 15);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusCycleRoot(true);
        jScrollPane1.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setInheritsPopupMenu(true);

        View_de_fornecedores.setAutoCreateRowSorter(true);
        View_de_fornecedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        View_de_fornecedores.setTableHeader(null);
        View_de_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "razão", "nomefantasia", "cpf_cnpj", "telefone", "email", "cep", "uf", "municipio", "endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        View_de_fornecedores.setAlignmentY(2.0F);
        View_de_fornecedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        View_de_fornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        View_de_fornecedores.setDoubleBuffered(true);
        View_de_fornecedores.setDragEnabled(true);
        View_de_fornecedores.setFillsViewportHeight(true);
        View_de_fornecedores.setFocusCycleRoot(true);
        View_de_fornecedores.setFocusable(false);
        View_de_fornecedores.setGridColor(new java.awt.Color(255, 255, 255));
        View_de_fornecedores.setMaximumSize(new java.awt.Dimension(2147483647, 440));
        View_de_fornecedores.setMinimumSize(new java.awt.Dimension(100, 1040));
        View_de_fornecedores.setName(""); // NOI18N
        View_de_fornecedores.setPreferredSize(new java.awt.Dimension(400, 384));
        View_de_fornecedores.setRequestFocusEnabled(false);
        View_de_fornecedores.setRowHeight(40);
        View_de_fornecedores.setSelectionBackground(new java.awt.Color(255, 255, 255));
        View_de_fornecedores.setUpdateSelectionOnSort(false);
        View_de_fornecedores.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(View_de_fornecedores);
        if (View_de_fornecedores.getColumnModel().getColumnCount() > 0) {
            View_de_fornecedores.getColumnModel().getColumn(0).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(1).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(2).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(3).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(4).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(5).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(6).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(7).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(8).setResizable(false);
            View_de_fornecedores.getColumnModel().getColumn(9).setResizable(false);
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

        Botton_atualizar.setBackground(new java.awt.Color(235, 235, 235));
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
            .addGroup(barra_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, barra_topLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barra_topLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        barra_topLayout.setVerticalGroup(
            barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_topLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(barra_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Cadastrar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botton_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(barra_top);
        barra_top.setBounds(0, 0, 1200, 800);

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_produtoActionPerformed
        if (isAdmin == true){
        Jcadastrar_fornecedores jcadastrar = new Jcadastrar_fornecedores();
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

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void produtos_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtos_inicioActionPerformed
        Jhome jhome = new Jhome(isAdmin, userName);
        jhome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_produtos_inicioActionPerformed

    private void Botton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_atualizarActionPerformed
        Jfornecedor jproduto = new Jfornecedor(isAdmin, userName);
        jproduto.setVisible(true);
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
            java.util.logging.Logger.getLogger(Jfornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jfornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jfornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jfornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable View_de_fornecedores;
    private javax.swing.JPanel barra_top;
    private javax.swing.JButton codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton ncm;
    private javax.swing.JButton ncm1;
    private javax.swing.JButton ncm2;
    private javax.swing.JButton ncm3;
    private javax.swing.JButton ncm4;
    private javax.swing.JButton ncm5;
    private javax.swing.JButton ncm6;
    private javax.swing.JButton ncm7;
    private javax.swing.JButton ncm8;
    private javax.swing.JButton produtos_inicio;
    // End of variables declaration//GEN-END:variables

    
}
