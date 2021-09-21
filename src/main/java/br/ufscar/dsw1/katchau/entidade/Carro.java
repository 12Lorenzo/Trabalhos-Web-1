package br.ufscar.dsw1.katchau.entidade;
//É a representação da entidade do banco como uma classe
public class Carro {
    private Long id;
    private String cnpj;
    private String placa;
    private String modelo;
    private String chassi;
    private String descricao;
    private int ano;
    private float km;
    private float valor;

    public Carro(Long id,String cnpj,String placa,String modelo,String chassi,String descricao,int ano,float km,float valor){
        super();
        this.id = id;
        this.cnpj = cnpj;
        this.placa = placa;
        this.modelo = modelo;
        this.chassi = chassi;
        this.descricao = descricao;
        this.ano = ano;
        this.km = km;
        this.valor = valor;
    }
    public Carro(Long id) {
        this.id = id;
    }
    public Carro(String cnpj,String placa,String modelo,String chassi,String descricao,int ano,float km,float valor){
        super();
        this.cnpj = cnpj;
        this.placa = placa;
        this.modelo = modelo;
        this.chassi = chassi;
        this.descricao = descricao;
        this.ano = ano;
        this.km = km;
        this.valor = valor;
    }
    public Long getId() {
        return id;
    }

    public void setId
            (Long id) {
        this.id = id;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj
            (String cnpj) {
        this.cnpj = cnpj;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca
            (String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo
            (String modelo) {
        this.modelo = modelo;
    }
    public String getChassi() {
        return chassi;
    }

    public void setChassi
            (String chassi) {
        this.chassi = chassi;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao
            (String descricao) {
        this.descricao = descricao;
    }
    public int getAno() {
        return ano;
    }

    public void setAno
            (int ano) {
        this.ano = ano;
    }
    public float getKm() {
        return km;
    }

    public void setKm
            (float km) {
        this.km = km;
    }
    public float getValor() {
        return valor;
    }

    public void setValor
            (float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.id + ";"+this.modelo+";"+this.cnpj+";"+this.placa+";"+this.chassi+";"+this.descricao+
        ";"+this.ano+";"+this.km+";"+ this.valor;
    }
}
