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
        String sql = "insert into pedidos(codigo, lote, produto, quantidade, descricao, dataSaida)"
        + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            
            pst.setInt(1, pedido.getCodigo());
            pst.setInt(2, pedido.getLote());
            pst.setString(3, pedido.getProduto());
            pst.setInt(4, pedido.getQuantidade());
            pst.setString(5, pedido.getDescricao());
            pst.setString(6, pedido.getDatasaida());
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
