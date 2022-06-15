/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Pedido_bean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class Pedido_dao {
        private Conexao conexao;
        private Connection conn;

    
        public Pedido_dao(){
     
        this.conexao = new Conexao();
        this.conn = this.conexao.Bd_Conexao();     
     }
    public void inserir(Pedido_bean pedido){
        String sql = "insert into pedidos(lote, produto, quantidade, descricao)"
        + " values(?,?,?,?)";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            
            pst.setInt(1, pedido.getLote());
            pst.setInt(2, pedido.getProduto());
            pst.setInt(3, pedido.getQuantidade());
            pst.setString(4, pedido.getDescricao());
            pst.execute();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em Pedido_dao " +e);
        } finally{
        this.conexao.fecha_bd();
            System.out.println("Banco fechado");
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso");
        }
    }

}
