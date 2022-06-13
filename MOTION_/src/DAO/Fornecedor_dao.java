/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Fornecedor_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class Fornecedor_dao {
        private Conexao conexao;
        private Connection conn;
     

        public Fornecedor_dao(){
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();    
     }
        
        public void inserir(Fornecedor_bean fornecedor){
    
        String sql = "insert into fornecedores(razão, nomeFantasia, cpf_cnpj, telefone, email, cep, uf, municipio, endereco) values "
                   + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
        try {            
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, fornecedor.getRazao());
            pst.setString(2, fornecedor.getNomefantasia());
            pst.setInt(3, fornecedor.getCpf_cnpj());
            pst.setString(4, fornecedor.getTelefone());
            pst.setString(5, fornecedor.getEmail());
            pst.setString(6, fornecedor.getCep());
            pst.setString(7, fornecedor.getUf());
            pst.setString(8, fornecedor.getMunicipio());
            pst.setString(9, fornecedor.getEndereco());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
            
        } catch (Exception e) {
            System.out.println("Erro em classe Fornecedores_dao");
        } finally{
        this.conexao.fecha_bd();
            System.out.println("Banco fechado");
            
        }
        
    }


}
