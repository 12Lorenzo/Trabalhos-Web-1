package br.ufscar.dsw1.katchau.entidade;

//É a representação da entidade do banco como uma classe

public class Loja {
    private String cnpj;
    private String descricao;
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj
            (String cnpj) {
        this.cnpj = cnpj;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao
            (String descricao) {
        this.descricao = descricao;
    }
    public Loja(String cnpj,String descricao){
        super();
        this.cnpj = cnpj;
        this.descricao = descricao;
    }

}
