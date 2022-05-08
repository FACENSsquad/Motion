
package CONEXAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public Connection Bd_Conexao(){
        try{
            // Tentar estabelecer conexão

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/bd_motion?serverTimezone=UTC",  // linha de conexão
                "root", // usuario do MySQL
                "12345" // senha do MySQL
            );
            return conn;
        } 
        catch(Exception e){
            // Se der erro exiba:
            System.out.println("Erro ao conectar"+ e.getMessage());
            return null;
        }
    }
}
    
