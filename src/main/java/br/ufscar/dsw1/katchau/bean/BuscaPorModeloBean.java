package br.ufscar.dsw1.katchau.bean;

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;

import java.util.List;

public class BuscaPorModeloBean {
    public List<Carro> getCarros() {
        CarroDAO dao = new CarroDAO();
        return dao.getAll();
    }

    public List<Carro> getCarros(String modelo) {
        CarroDAO dao = new CarroDAO();
        List<Carro> lista;
        if (modelo!= null  && modelo.length() > 0) {
            lista = dao.getByModelo(modelo);
        } else {

            lista = dao.getAll();
        }
        return lista;
    }
}
