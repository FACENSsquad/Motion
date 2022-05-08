
package BEAN;


public class Produtos_bean {
    
    private int codigo;
    private String produto;
    private String unidade;
    private String ncm;

    /*public Produtos_bean(int codigo, String produto, String unidade, String ncm) {
        this.codigo = codigo;
        this.produto = produto;
        this.unidade = unidade;
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    
}
