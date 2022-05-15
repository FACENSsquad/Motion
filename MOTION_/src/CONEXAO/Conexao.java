
package CONEXAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    Connection conn;
    public Connection Bd_Conexao(){
        try{
            // Tentar estabelecer conexão

           conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd_motion?serverTimezone=UTC",  // linha de conexão
                "root", // usuario do MySQL
                "" // senha do MySQL
            );
            return conn;
        } 
        catch(Exception e){
            // Se der erro exiba:
            System.out.println("Erro ao conectar"+ e.getMessage());
            return null;
        }
    }
    
    public boolean fecha_bd(){
        
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao " + e.getMessage());
            return false;
        }
    }
    
    }
    

    
