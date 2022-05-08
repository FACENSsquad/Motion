
package DAO;

import BEAN.Cliente_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Cliente_dao {
    
     private Conexao conexao;
     private Connection conn;
     
     public Cliente_dao(){
     
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();
     
     }
     public void inserir(Cliente_bean cliente){
    
        String sql = "insert into cliente(nome, telefone, email, cep, uf, municipio, endereco, cpf_cnpj) values "
                   + "(?, ?, ?, ?, ?, ?, ?, ?,)";
       
        try {
            
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCep());
            pst.setString(5, cliente.getUf());
            pst.setString(6, cliente.getMunicipio());
            pst.setString(7, cliente.getEndereco());
            pst.setString(8, cliente.getCpf());
            pst.execute();
            
        } catch (Exception e) {
            System.out.println("Erro em classe Cliente_dao");
        }
        
    }
    
}
