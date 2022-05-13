
package DAO;

import BEAN.Lotes_bean; 
import CONEXAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;


/*
    private int lote;
    private int l_produto;
    private int quantidade;
    private float valor;
    private int alocacao;
    private String data_v;
    private int fornecedor;
    private String data_e;
*/

public class Lotes_dao {

    private Conexao conexao;
    private Connection conn;
    
    public Lotes_dao(){
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();
    }
    
    public void inserir(Lotes_bean lote){
        String sql = "insert into lote(l_produto, quantidade, valor, alocacao, data_v, fornecedor)"
        + " values(?,?,?,?,?,?)";
        try {
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em Lotes_dao " +e);
            return null;
            
        }
    }
    
}
