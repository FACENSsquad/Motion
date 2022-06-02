/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Cliente_bean;
import DAO.Cliente_dao;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Jcadastrar_cliente extends javax.swing.JFrame {

    private Conexao conexao;
    private Connection conn;
    
    
     public void conexao_cadastrar(){
     this.conexao = new Conexao();
     this.conn = this.conexao.Bd_Conexao();
    }
    
    
    public Jcadastrar_cliente() {
        initComponents();
        conexao_cadastrar();
        
    }
    
    public void update_c (){
   
        String sql = "update cliente set nome = ?, cpf_cnpj = ?, telefone = ?, "
                + "email = ?, cep = ?, uf = ?, municipio = ?, endereco = ? "
               + "where codigo = ?; ";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, Caixa_nome.getText());
            pst.setString(2, Caixa_cpf.getText());
            pst.setString(3, Caixa_telefone.getText());
            pst.setString(4, Caixa_email.getText());
            pst.setString(5, Caixa_cep.getText());
            pst.setString(6, (String) Campo_uf.getSelectedItem());
            pst.setString(7, Caixa_municipio.getText());
            pst.setString(8, Caixa_endereco.getText());
            pst.setInt(9, Integer.parseInt(Caixa_codigo.getText()));
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em  UPDATE cliente");
        }  
    }
    
        public void consultar (){
    
        String sql = "select * from cliente where codigo = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_nome.setText(rs.getString(2));
              Caixa_cpf.setText(rs.getString(3));
              Caixa_telefone.setText(rs.getString(4));
              Caixa_email.setText(rs.getString(5));
              Caixa_cep.setText(rs.getString(6));
              Campo_uf.setSelectedItem(7);
              Caixa_municipio.setText(rs.getString(8));
              Caixa_endereco.setText(rs.getString(9));
             
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Cliente não encontrado");
                
              Caixa_nome.setText(null);
              Caixa_cpf.setText(null);
              Caixa_telefone.setText(null);
              Caixa_email.setText(null);
              Caixa_cep.setText(null);
              Campo_uf.setSelectedItem(null);
              Caixa_municipio.setText(null);
              Caixa_endereco.setText(null);
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
    
        }
    }
        
        public void delete(){
        
        int confirmar;
        String message = "Deseja realmente remover este cliente?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from cliente where codigo = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo DELETE de cliente");
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TITULO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Caixa_nome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Caixa_cpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Caixa_endereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Caixa_cep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Caixa_municipio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Campo_uf = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Caixa_telefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Caixa_email = new javax.swing.JTextField();
        Botton_cadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Botton_deletar = new javax.swing.JButton();
        Botton_Atualizar = new javax.swing.JToggleButton();
        Codigo = new javax.swing.JLabel();
        Botton_consultar = new javax.swing.JToggleButton();
        Caixa_codigo = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(null);

        TITULO.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TITULO.setForeground(new java.awt.Color(0, 0, 0));
        TITULO.setText("CADASTRO DE CLIENTE");
        jPanel1.add(TITULO);
        TITULO.setBounds(220, 10, 220, 22);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 70, 50, 17);

        Caixa_nome.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_nome.setBorder(null);
        Caixa_nome.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_nome.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_nomeActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_nome);
        Caixa_nome.setBounds(90, 90, 240, 25);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CPF / CNPJ:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(360, 70, 90, 17);

        Caixa_cpf.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_cpf.setBorder(null);
        Caixa_cpf.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_cpf.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cpfActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_cpf);
        Caixa_cpf.setBounds(360, 90, 240, 25);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Endereço:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 130, 80, 17);

        Caixa_endereco.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_endereco.setBorder(null);
        Caixa_endereco.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_endereco.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_endereco);
        Caixa_endereco.setBounds(90, 150, 240, 25);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CEP:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 130, 40, 17);

        Caixa_cep.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_cep.setBorder(null);
        Caixa_cep.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_cep.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_cep);
        Caixa_cep.setBounds(360, 150, 240, 25);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Municipio:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 190, 80, 17);

        Caixa_municipio.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_municipio.setBorder(null);
        Caixa_municipio.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_municipio.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_municipio);
        Caixa_municipio.setBounds(90, 210, 240, 25);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("UF:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(360, 190, 34, 17);

        Campo_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(Campo_uf);
        Campo_uf.setBounds(360, 210, 50, 24);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Telefone");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 250, 90, 17);

        Caixa_telefone.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_telefone.setBorder(null);
        Caixa_telefone.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_telefone.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefoneActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_telefone);
        Caixa_telefone.setBounds(90, 270, 240, 25);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("E-mail");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(360, 250, 39, 17);

        Caixa_email.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_email.setBorder(null);
        Caixa_email.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_email.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_emailActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_email);
        Caixa_email.setBounds(360, 270, 270, 25);

        Botton_cadastrar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_cadastrar.setForeground(new java.awt.Color(208, 214, 216));
        Botton_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_salvar.png"))); // NOI18N
        Botton_cadastrar.setBorder(null);
        Botton_cadastrar.setBorderPainted(false);
        Botton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_cadastrar);
        Botton_cadastrar.setBounds(540, 330, 85, 40);

        jButton1.setBackground(new java.awt.Color(208, 214, 216));
        jButton1.setForeground(new java.awt.Color(208, 214, 216));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jPanel1.add(jButton1);
        jButton1.setBounds(440, 330, 80, 40);

        Botton_deletar.setBackground(new java.awt.Color(209, 214, 216));
        Botton_deletar.setForeground(new java.awt.Color(0, 0, 0));
        Botton_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_deletar.png"))); // NOI18N
        Botton_deletar.setBorder(null);
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(430, 500, 80, 40);

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
        Botton_Atualizar.setBounds(540, 500, 80, 40);

        Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Codigo.setForeground(new java.awt.Color(0, 0, 0));
        Codigo.setText("Codigo:");
        jPanel1.add(Codigo);
        Codigo.setBounds(110, 420, 60, 17);

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
        Botton_consultar.setBounds(330, 450, 30, 20);

        Caixa_codigo.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_codigo.setBorder(null);
        Caixa_codigo.setPreferredSize(new java.awt.Dimension(4, 25));
        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(110, 450, 249, 25);

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Atualizar ou Deletar ");
        jPanel1.add(titulo);
        titulo.setBounds(200, 340, 180, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Caixa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_nomeActionPerformed

    private void Caixa_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_emailActionPerformed

    private void Caixa_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_cpfActionPerformed

    private void Botton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cadastrarActionPerformed
        try {
            
             String nome, email, cpf, telefone, endereco, cep, municipio, uf;
             
             nome = Caixa_nome.getText();
             email = Caixa_email.getText();
             cpf = Caixa_cpf.getText();
             telefone = Caixa_telefone.getText();
             endereco = Caixa_endereco.getText();
             cep = Caixa_cep.getText();
             municipio = Caixa_municipio.getText();
             uf = (String) Campo_uf.getSelectedItem();
             
             
             Cliente_bean c_bean = new Cliente_bean();
             c_bean.setNome(nome);
             c_bean.setEmail(email);
             c_bean.setCpf(cpf);
             c_bean.setTelefone(telefone);
             c_bean.setEndereco(endereco);
             c_bean.setCep(cep);
             c_bean.setMunicipio(municipio);
             c_bean.setUf(uf);
             
             
             
             
             Cliente_dao c_dao =  new Cliente_dao();
             c_dao.inserir(c_bean);
             
             Caixa_nome.setText("");
             Caixa_cep.setText("");
             Caixa_email.setText("");
             Caixa_endereco.setText("");
             Caixa_municipio.setText("");
             Caixa_telefone.setText("");
             Caixa_cpf.setText("");
             
            
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
        }
        this.dispose();
        
        
        
    }//GEN-LAST:event_Botton_cadastrarActionPerformed

    private void Caixa_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_telefoneActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
        delete();
        
        dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
        update_c();

        dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

    private void Caixa_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoActionPerformed

    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed

        consultar();
    }//GEN-LAST:event_Botton_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(Jcadastrar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jcadastrar_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Botton_Atualizar;
    private javax.swing.JButton Botton_cadastrar;
    private javax.swing.JToggleButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_cep;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_cpf;
    private javax.swing.JTextField Caixa_email;
    private javax.swing.JTextField Caixa_endereco;
    private javax.swing.JTextField Caixa_municipio;
    private javax.swing.JTextField Caixa_nome;
    private javax.swing.JTextField Caixa_telefone;
    private javax.swing.JComboBox<String> Campo_uf;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel TITULO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
