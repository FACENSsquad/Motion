
package DAO;

import BEAN.Login_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Login_dao {
    
    Connection conn;
    Conexao conexao;
    
    public ResultSet autenticaUsuario(Login_bean login_usuario){
        conn = new Conexao().Bd_Conexao();
        
        try {
            String sql = "select * from usuario where usuario = ? and senha = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1,login_usuario.getUsuario());
            pst.setString(2,login_usuario.getSenha());
            
            ResultSet rs = pst.executeQuery();
            return rs;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro em Login_dao " +e);
            return null;
        }
    }
    
    }

