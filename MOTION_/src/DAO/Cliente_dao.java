
package DAO;

import BEAN.Cliente_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Cliente_dao {
    
     private Conexao conexao;
     private Connection conn;
     
     
     public Cliente_dao(){
     
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();
        
     
     }
     public void inserir(Cliente_bean cliente){
    
        String sql = "insert into cliente(nome, telefone, email, cep, uf, municipio, endereco, cpf_cnpj) values "
                   + "(?, ?, ?, ?, ?, ?, ?, ?)";
       
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
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            
        } catch (Exception e) {
            System.out.println("Erro em classe Cliente_dao");
        } finally{
        this.conexao.fecha_bd();
            System.out.println("Banco fechado");
            
        }
        
    }
     public void update(Cliente_bean update_cliente){
     
         String sql = "update cliente set =  ? where codigo = ?;";
         
         try {
            
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, update_cliente.getNome());
            pst.setString(2, update_cliente.getTelefone());
            pst.setString(3, update_cliente.getEmail());
            pst.setString(4, update_cliente.getCep());
            pst.setString(5, update_cliente.getUf());
            pst.setString(6, update_cliente.getMunicipio());
            pst.setString(7, update_cliente.getEndereco());
            pst.setString(8, update_cliente.getCpf());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro em classe Cliente_dao");
        } finally{
        this.conexao.fecha_bd();
            System.out.println("Banco fechado");
            
        }
         
     }
     
    
}
