package br.ufscar.dsw1.katchau.entidade;

//É a representação da entidade do banco como uma classe

import java.util.Date;

public class Proposta {
    private Long id;
    private int status;
    private Date data;
    private float val;
    private String cnpj;
    private Long carro_id;

    public Long getId() {
        return id;
    }

    public void setId
            (Long id) {
        this.id = id;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus
            (int status) {
        this.status = status;
    }
    public Date getData() {
        return data;
    }

    public void setData
            (Date data) {
        this.data = data;
    }
    public float getVal() {
        return val;
    }

    public void setVal
            (float val) {
        this.val = val;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj
            (String cnpj) {
        this.cnpj = cnpj;
    }
    public Long getCarro_id() {
        return carro_id;
    }

    public void setCarro_id
            (Long carro_id) {
        this.carro_id = carro_id;
    }
    public Proposta(Long id,int status,Date data,float val,String cnpj,Long carro_id){
        super();
        this.id = id;
        this.status = status;
        this.data = data;
        this.val = val;
        this.cnpj = cnpj;
        this.carro_id = carro_id;
    }
    public Proposta(int status,Date data,float val,String cnpj,Long carro_id){
        super();
        this.status = status;
        this.data = data;
        this.val = val;
        this.cnpj = cnpj;
        this.carro_id = carro_id;
    }
    public Proposta(Long id){
        super();
        this.id = id;
    }

}
