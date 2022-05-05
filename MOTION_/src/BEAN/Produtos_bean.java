
package BEAN;


public class Produtos_bean {
    
    private int codigo;
    private String produto;
    private String tipo;
    private String ncm;

    /*public Produtos_bean(int codigo, String produto, String tipo, String ncm) {
        this.codigo = codigo;
        this.produto = produto;
        this.tipo = tipo;
        this.ncm = ncm;
    } */

    public int getId() {
        return codigo;
    }

    public void setId(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    
}
