package br.ufscar.dsw1.katchau.entidade;

//import javax.faces.context.ExternalContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> imagens;

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

    public void setImagens(List<String> imagens){
        this.imagens = imagens;
    }

    public List<String> getImagens(){
        return imagens;
    }

    public void setValor
            (float valor) {
        this.valor = valor;
    }

    public List<String> getImages(String uploadPath){
        System.out.println("cheguei -:> " + uploadPath);
        uploadPath = uploadPath + File.separator + this.id.toString();
        List<String> fileList = new ArrayList<String>();
        File dir = new File(uploadPath);

        File[] files = dir.listFiles();
        if (files != null) {
            for (final File file : files) {
                String relative = file.getPath().split("webapps")[1];
                fileList.add(relative);
            }
        }
        return fileList;
    }


    @Override
    public String toString() {
        return this.id + ";"+this.modelo+";"+this.cnpj+";"+this.placa+";"+this.chassi+";"+this.descricao+
        ";"+this.ano+";"+this.km+";"+ this.valor;
    }
}
