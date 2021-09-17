package br.ufscar.dsw1.katchau.entidade;

//É a representação da entidade do banco como uma classe

public class Usuario {
    private String codigo;
    private String email;
    private String senha;
    private int papel;
    private String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo
            (String codigo) {
        this.codigo = codigo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail
            (String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha
            (String senha) {
        this.senha = senha;
    }
    public int getPapel() {
        return papel;
    }

    public void setPapel
            (int papel) {
        this.papel = papel;
    }
    public String getNome() {
        return nome;
    }

    public void setNome
            (String nome) {
        this.nome = nome;
    }
    public Usuario(String codigo,String email,String senha,int papel,String nome){
        super();
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
        this.nome = nome;
    }

}
