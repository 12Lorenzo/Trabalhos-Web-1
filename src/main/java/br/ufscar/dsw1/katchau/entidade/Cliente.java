package br.ufscar.dsw1.katchau.entidade;
//É a representação da entidade do banco como uma classe

import java.util.Date;

//É a representação da classe Cliente

public class Cliente {
    private String cpf;
    private String telefone;
    private String sexo;
    private Date nascimento;
    public String getCpf() {
        return cpf;
    }

    public void setCpf
            (String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone
            (String telefone) {
        this.telefone = telefone;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo
            (String sexo) {
        this.sexo = sexo;
    }
    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento
            (Date nascimento) {
        this.nascimento = nascimento;
    }
    public Cliente(String cpf,String telefone,String sexo,Date nascimento){
        super();
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.nascimento = nascimento;
    }

    public Cliente(){
        super();
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "cpf='" + cpf + '\'' +
            ", telefone='" + telefone + '\'' +
            ", sexo='" + sexo + '\'' +
            ", nascimento=" + nascimento +
            '}';
    }
}
