package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends GenericDAO{

    public List<Carro> getAll() {

        List<Carro> listaCarros = new ArrayList<>();
        String sql1 = "SELECT * from Carro";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            resultSet = statement.executeQuery();

            /*
            Não funciona
            while (resultSet.next()) {

                //String id = resultSet.getString("id");
                String cnpj = resultSet.getString("cnpj");
                String placa = resultSet.getString("placa");
                String modelo = resultSet.getString("modelo");
                String chassi = resultSet.getString("chassi");
                int ano = resultSet.getInt("ano");
                float km = resultSet.getFloat("km");
                String desc = resultSet.getString("descricao");
                float val = resultSet.getFloat("valor");
                Carro car = new Carro(cnpj, placa,modelo,chassi, desc, ano,km, val);

                listaCarros.add(car);
            }
            */
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
        if (carroId == null)
            return null;
        String sql1 = "SELECT * from Carro c where c.id = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setLong(1, carroId);
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

    public List<Carro> getByModelo(String modelo){
        List<Carro> listaCarros;
        if (modelo == null)
            return getAll();

        String sql1 = "SELECT * from Carro c where c.modelo LIKE ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1,"%"+modelo+"%");
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


    public long insert(Carro carro){
        try {
            Connection conn = this.getConnection();

            String sqlInsert = "INSERT INTO Carro(cnpj, placa, modelo, chassi,  ano, km, descricao, valor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sqlInsert, new String[] {"id"});

            statement.setString(1, carro.getCnpj());
            statement.setString(2, carro.getPlaca());
            statement.setString(3, carro.getModelo());
            statement.setString(4, carro.getChassi());
            statement.setInt(5, carro.getAno());
            statement.setFloat(6, carro.getKm());
            statement.setString(7, carro.getDescricao());
            statement.setFloat(8, carro.getValor());

            long id_feito = -1;
            int affectedRows = statement.executeUpdate();
            try{
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                    id_feito = (long) generatedKeys.getInt(1);

            } catch (SQLException throwables) {
                return (long) -1;
            }
            return id_feito;
        } catch(SQLException e){
            return (long) -1;
        }
    }

}
