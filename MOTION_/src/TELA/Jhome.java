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

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class Jhome extends javax.swing.JFrame {
    boolean isAdmin;
    String userName;
    String lote_vencer = "0", valor, lote_velho, p_vendido, produtoCode, produtoNome;
    String loteMaisvelho, produtoCode2, produtoNome2;
    ResultSet rs;
    
     private Conexao conexao;
     private Connection conn;
    
    public void informacoes(){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();
    
        String sql1 = "select min(data_v), l_produto, produto.produto as produto\n" +
                      "from lote\n" +
                      "left join produto on lote.l_produto = produto.codigo;";
        
        //1º lote a vencer
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            
            while (rs.next()) {
                
                
            lote_vencer = rs.getString(1); 
            produtoCode = rs.getString(2); 
            produtoNome = rs.getString(3); 
            
            Label_vencer.setText(lote_vencer);
            Label_vencer2.setText(produtoCode);
            label_nome.setText(produtoNome);
            
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        
        //Valor do estoque
        try {
            PreparedStatement pst = this.conn.prepareStatement("select * from valor_estoque;");
            rs = pst.executeQuery();
            
            
            while (rs.next()) {
                
                
            valor = rs.getString(1); 
                        
            valorr.setText(valor);

            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        
        //leto mais velho
        String sql2 = "select min(data_e), l_produto, produto.produto as produto\n" +
               "from lote\n" +
               "left join produto on lote.l_produto = produto.codigo;";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            
            
            while (rs.next()) {
                
                
            loteMaisvelho = rs.getString(1); 
            produtoCode2 = rs.getString(2); 
            produtoNome2 = rs.getString(3); 
                        
            velho1.setText(produtoNome2);
            velho2.setText(produtoCode2);
            velho3.setText(loteMaisvelho);

            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        
        //Lote com maior quantidade.
        try {
            PreparedStatement pst = this.conn.prepareStatement("select * from lote_maior_quantidade;");
            rs = pst.executeQuery();
            
            String quantidadeM, loteM, produtoM;
            
            while (rs.next()) {
                
                
            quantidadeM = rs.getString(1); 
            loteM = rs.getString(2); 
            produtoM = rs.getString(3); 
                        
            quantidadeMM.setText(quantidadeM);
            loteMM.setText(loteM);
            produtoMM.setText(produtoM);

            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
    
    }

    public Jhome(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        initComponents();
        informacoes();
        System.out.println(lote_vencer);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JButton getEntrar_Produtos() {
        return Entrar_Produtos;
    }

    public void setEntrar_Produtos(JButton Entrar_Produtos) {
        this.Entrar_Produtos = Entrar_Produtos;
    }
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    private Jhome() {
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Entrar_Produtos = new javax.swing.JButton();
        Cadastro_fornecedor = new javax.swing.JButton();
        Cadastro_lote = new javax.swing.JButton();
        Cadastro_cliente = new javax.swing.JButton();
        Estoque = new javax.swing.JButton();
        Pedidos = new javax.swing.JButton();
        lupa = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Movimentação1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dash_produto = new javax.swing.JPanel();
        titulo_dash = new javax.swing.JLabel();
        label_nome = new javax.swing.JLabel();
        Label_vencer2 = new javax.swing.JLabel();
        Label_vencer = new javax.swing.JLabel();
        bt_dash_produto = new javax.swing.JButton();
        Label_vencer1 = new javax.swing.JLabel();
        dash_lote = new javax.swing.JPanel();
        titulo_dash1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorr = new javax.swing.JLabel();
        bt_dash_lote = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        titulo_dash3 = new javax.swing.JLabel();
        velho1 = new javax.swing.JLabel();
        velho2 = new javax.swing.JLabel();
        velho3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        titulo_dash4 = new javax.swing.JLabel();
        quantidadeMM = new javax.swing.JLabel();
        loteMM = new javax.swing.JLabel();
        produtoMM = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(176, 216, 230));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText(String.valueOf(userName));

        logo.setBackground(new java.awt.Color(235, 235, 235));
        logo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("MotiON");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logo))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/tresBolas.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(12, 21, 40, 10);

        Entrar_Produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_produto.png"))); // NOI18N
        Entrar_Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Entrar_ProdutosActionPerformed(evt);
            }
        });
        jPanel2.add(Entrar_Produtos);
        Entrar_Produtos.setBounds(0, 270, 200, 30);

        Cadastro_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_fornecedor.png"))); // NOI18N
        Cadastro_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastro_fornecedorActionPerformed(evt);
            }
        });
        jPanel2.add(Cadastro_fornecedor);
        Cadastro_fornecedor.setBounds(0, 300, 200, 30);

        Cadastro_lote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_lote.png"))); // NOI18N
        Cadastro_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastro_loteActionPerformed(evt);
            }
        });
        jPanel2.add(Cadastro_lote);
        Cadastro_lote.setBounds(0, 330, 200, 30);

        Cadastro_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_cliente.png"))); // NOI18N
        Cadastro_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastro_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(Cadastro_cliente);
        Cadastro_cliente.setBounds(0, 360, 200, 30);

        Estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_estoque.png"))); // NOI18N
        Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstoqueActionPerformed(evt);
            }
        });
        jPanel2.add(Estoque);
        Estoque.setBounds(0, 390, 200, 30);

        Pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_pedidos.png"))); // NOI18N
        Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosActionPerformed(evt);
            }
        });
        jPanel2.add(Pedidos);
        Pedidos.setBounds(0, 420, 200, 30);

        lupa.setBackground(new java.awt.Color(255, 255, 255));
        lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        jPanel2.add(lupa);
        lupa.setBounds(0, 230, 20, 30);

        jTextField1.setBorder(null);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(20, 230, 180, 30);

        Movimentação1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bt_home_movimentacao.png"))); // NOI18N
        Movimentação1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Movimentação1ActionPerformed(evt);
            }
        });
        jPanel2.add(Movimentação1);
        Movimentação1.setBounds(0, 450, 200, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Precisa de ajuda?");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);

        dash_produto.setBackground(new java.awt.Color(235, 235, 235));
        dash_produto.setPreferredSize(new java.awt.Dimension(475, 265));
        dash_produto.setLayout(null);

        titulo_dash.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        titulo_dash.setForeground(new java.awt.Color(126, 126, 126));
        titulo_dash.setText("1º lote a vencer");
        dash_produto.add(titulo_dash);
        titulo_dash.setBounds(70, 40, 150, 19);

        label_nome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label_nome.setForeground(new java.awt.Color(51, 51, 51));
        label_nome.setText("produto");
        dash_produto.add(label_nome);
        label_nome.setBounds(90, 70, 100, 40);

        Label_vencer2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_vencer2.setForeground(new java.awt.Color(51, 51, 51));
        Label_vencer2.setText("lote");
        dash_produto.add(Label_vencer2);
        Label_vencer2.setBounds(250, 70, 80, 40);

        Label_vencer.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        Label_vencer.setForeground(new java.awt.Color(153, 0, 0));
        Label_vencer.setText("DATA");
        dash_produto.add(Label_vencer);
        Label_vencer.setBounds(90, 120, 300, 80);

        bt_dash_produto.setBackground(new java.awt.Color(235, 235, 235));
        bt_dash_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/DASHBORD.png"))); // NOI18N
        bt_dash_produto.setBorder(null);
        bt_dash_produto.setContentAreaFilled(false);
        bt_dash_produto.setMinimumSize(new java.awt.Dimension(238, 10));
        bt_dash_produto.setPreferredSize(new java.awt.Dimension(250, 100));
        bt_dash_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dash_produtoActionPerformed(evt);
            }
        });
        dash_produto.add(bt_dash_produto);
        bt_dash_produto.setBounds(40, 60, 397, 179);

        Label_vencer1.setText(String.valueOf(lote_vencer));
        dash_produto.add(Label_vencer1);
        Label_vencer1.setBounds(100, 105, 270, 90);

        dash_lote.setBackground(new java.awt.Color(235, 235, 235));
        dash_lote.setPreferredSize(new java.awt.Dimension(475, 265));
        dash_lote.setLayout(null);

        titulo_dash1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        titulo_dash1.setForeground(new java.awt.Color(126, 126, 126));
        titulo_dash1.setText("Valor do estoque");
        dash_lote.add(titulo_dash1);
        titulo_dash1.setBounds(70, 40, 150, 19);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("R$:");
        dash_lote.add(jLabel3);
        jLabel3.setBounds(150, 140, 30, 30);

        valorr.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        valorr.setForeground(new java.awt.Color(64, 64, 64));
        valorr.setText("valor estoque");
        dash_lote.add(valorr);
        valorr.setBounds(180, 100, 190, 90);

        bt_dash_lote.setBackground(new java.awt.Color(235, 235, 235));
        bt_dash_lote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/DASHBORD.png"))); // NOI18N
        bt_dash_lote.setBorder(null);
        bt_dash_lote.setContentAreaFilled(false);
        bt_dash_lote.setMinimumSize(new java.awt.Dimension(238, 10));
        bt_dash_lote.setPreferredSize(new java.awt.Dimension(250, 100));
        dash_lote.add(bt_dash_lote);
        bt_dash_lote.setBounds(40, 60, 397, 179);

        jPanel6.setBackground(new java.awt.Color(235, 235, 235));
        jPanel6.setPreferredSize(new java.awt.Dimension(475, 265));
        jPanel6.setLayout(null);

        titulo_dash3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        titulo_dash3.setForeground(new java.awt.Color(126, 126, 126));
        titulo_dash3.setText("Lote mais velho");
        jPanel6.add(titulo_dash3);
        titulo_dash3.setBounds(70, 40, 150, 19);

        velho1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        velho1.setForeground(new java.awt.Color(51, 51, 51));
        velho1.setText("produto");
        jPanel6.add(velho1);
        velho1.setBounds(90, 70, 110, 40);

        velho2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        velho2.setForeground(new java.awt.Color(51, 51, 51));
        velho2.setText("lote");
        jPanel6.add(velho2);
        velho2.setBounds(260, 70, 100, 40);

        velho3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        velho3.setForeground(new java.awt.Color(64, 64, 64));
        velho3.setText("DATA");
        jPanel6.add(velho3);
        velho3.setBounds(80, 120, 320, 80);

        jButton4.setBackground(new java.awt.Color(235, 235, 235));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/DASHBORD.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setMinimumSize(new java.awt.Dimension(238, 10));
        jButton4.setPreferredSize(new java.awt.Dimension(250, 100));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(39, 61, 397, 179);

        jPanel7.setBackground(new java.awt.Color(235, 235, 235));
        jPanel7.setPreferredSize(new java.awt.Dimension(448, 265));
        jPanel7.setLayout(null);

        titulo_dash4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        titulo_dash4.setForeground(new java.awt.Color(126, 126, 126));
        titulo_dash4.setText("Lote com maior quantidade");
        jPanel7.add(titulo_dash4);
        titulo_dash4.setBounds(70, 40, 200, 19);

        quantidadeMM.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        quantidadeMM.setForeground(new java.awt.Color(64, 64, 64));
        quantidadeMM.setText("QUANTIDADE");
        jPanel7.add(quantidadeMM);
        quantidadeMM.setBounds(170, 110, 180, 90);

        loteMM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loteMM.setForeground(new java.awt.Color(51, 51, 51));
        loteMM.setText("jLabel4");
        jPanel7.add(loteMM);
        loteMM.setBounds(90, 90, 46, 17);

        produtoMM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produtoMM.setForeground(new java.awt.Color(51, 51, 51));
        produtoMM.setText("jLabel4");
        jPanel7.add(produtoMM);
        produtoMM.setBounds(200, 90, 46, 17);

        jButton5.setBackground(new java.awt.Color(235, 235, 235));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/DASHBORD.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setMinimumSize(new java.awt.Dimension(238, 10));
        jButton5.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanel7.add(jButton5);
        jButton5.setBounds(39, 61, 397, 179);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dash_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dash_lote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dash_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dash_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 800);

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Entrar_ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Entrar_ProdutosActionPerformed
       Jproduto jprodutos = new Jproduto(isAdmin, userName);
       jprodutos.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Entrar_ProdutosActionPerformed

    private void Cadastro_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastro_fornecedorActionPerformed
       Jfornecedor jfornecedor = new Jfornecedor(isAdmin, userName);
       jfornecedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Cadastro_fornecedorActionPerformed

    private void Cadastro_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastro_loteActionPerformed
        Jlote jlote = new Jlote(isAdmin, userName);
        jlote.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Cadastro_loteActionPerformed

    private void EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstoqueActionPerformed
        Jestoque jestoque = new Jestoque(isAdmin, userName);
        jestoque.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EstoqueActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_PedidosActionPerformed

    private void Cadastro_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastro_clienteActionPerformed
        if (isAdmin == true){
        Jcliente jcliente = new Jcliente(true, userName);
        jcliente.setVisible(true);
        }
        else{
        Jcliente jcliente = new Jcliente(false, userName);
        jcliente.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_Cadastro_clienteActionPerformed

    private void bt_dash_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dash_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_dash_produtoActionPerformed

    private void Movimentação1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Movimentação1ActionPerformed
        Jmovimentação jmovimentação = new Jmovimentação(isAdmin, userName);
        jmovimentação.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Movimentação1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nome_usuarioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
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
            java.util.logging.Logger.getLogger(Jhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jhome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastro_cliente;
    private javax.swing.JButton Cadastro_fornecedor;
    private javax.swing.JButton Cadastro_lote;
    private javax.swing.JButton Entrar_Produtos;
    private javax.swing.JButton Estoque;
    private javax.swing.JLabel Label_vencer;
    private javax.swing.JLabel Label_vencer1;
    private javax.swing.JLabel Label_vencer2;
    private javax.swing.JButton Movimentação1;
    private javax.swing.JButton Pedidos;
    private javax.swing.JButton bt_dash_lote;
    private javax.swing.JButton bt_dash_produto;
    private javax.swing.JPanel dash_lote;
    private javax.swing.JPanel dash_produto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_nome;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel loteMM;
    private javax.swing.JLabel lupa;
    private javax.swing.JLabel produtoMM;
    private javax.swing.JLabel quantidadeMM;
    private javax.swing.JLabel titulo_dash;
    private javax.swing.JLabel titulo_dash1;
    private javax.swing.JLabel titulo_dash3;
    private javax.swing.JLabel titulo_dash4;
    private javax.swing.JLabel valorr;
    private javax.swing.JLabel velho1;
    private javax.swing.JLabel velho2;
    private javax.swing.JLabel velho3;
    // End of variables declaration//GEN-END:variables

    private String setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
