package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends GenericDAO{

    public List<Carro> getAll(String lojaCnpj) {

        List<Carro> listaCarros = new ArrayList<>();

//        String sql = "SELECT * from Carro c where c.cnpj = ?";
        String sql1 = "SELECT * from Carro";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
//            if(lojaCnpj != null) {
//                PreparedStatement statement = conn.prepareStatement(sql);
//
//                statement.setString(1, lojaCnpj);
//                resultSet = statement.executeQuery();
//                statement.close();
//            } else {
                PreparedStatement statement = conn.prepareStatement(sql1);
                resultSet = statement.executeQuery();

//            }
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
//
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCarros;
    }
}
