
package DAO;

import BEAN.Produtos_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Produtos_dao {
    
    private Conexao conexao;
    private Connection conn;
    
    public Produtos_dao(){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();
    }
    
    public void inserir(Produtos_bean produto){
    
        String sql = "insert into produto(produto, tipo, ncm) values "
                   + "(?, ?, ?)";
        
        try {
            
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, produto.getProduto());
            pst.setString(2, produto.getTipo());
            pst.setString(3, produto.getNcm());
            pst.execute();
            
        } catch (Exception e) {
            System.out.println("Erro em classe Produtos_dao");
        }
        
    }
}
 

