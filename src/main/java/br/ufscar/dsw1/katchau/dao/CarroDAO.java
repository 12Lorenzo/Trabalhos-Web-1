package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends GenericDAO{

    public List<Carro> getAll() {

        List<Carro> listaCarros;
        String sql1 = "SELECT * from Carro";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            resultSet = statement.executeQuery();
            listaCarros = getFromResult(resultSet);
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCarros;
    }

    public List<Carro> getAll(String lojaCnpj) {

        List<Carro> listaCarros;

        String sql1 = "SELECT * from Carro c where c.cnpj = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1, lojaCnpj);
            resultSet = statement.executeQuery();
            listaCarros = getFromResult(resultSet);

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCarros;
    }

    public Carro read(Long carroId){
        List<Carro> listaCarros;

        String sql1 = "SELECT * from Carro c where c.id = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setLong(1,carroId);
            resultSet = statement.executeQuery();
            listaCarros = getFromResult(resultSet);
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(listaCarros.size() == 0){
          return null;
        }
        return listaCarros.get(0);
    }

    private List<Carro> getFromResult(ResultSet resultSet){
        List<Carro> listaCarros = new ArrayList<>();
        try{
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String placa = resultSet.getString("placa");
                String modelo = resultSet.getString("modelo");
                String chassi = resultSet.getString("chassi");
                String descricao = resultSet.getString("descricao");
                int ano = resultSet.getInt("ano");
                float km = resultSet.getFloat("km");
                float valor = resultSet.getFloat("valor");

                Carro carro = new Carro(id,cnpj,placa,modelo,chassi,descricao,ano,km,valor);

                listaCarros.add(carro);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCarros;
    }
}
