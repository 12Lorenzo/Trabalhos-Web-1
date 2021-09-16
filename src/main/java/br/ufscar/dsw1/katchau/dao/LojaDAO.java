package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Loja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LojaDAO extends GenericDAO{
    public List<Loja> read() {
        String sqlSelect = "SELECT * FROM Loja";

        List<Loja> listaLojas = new ArrayList<>();
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
            PreparedStatement statement = conn.prepareStatement(sqlSelect);
            resultSet = statement.executeQuery();

//            }
            while (resultSet.next()) {
                String cnpj = resultSet.getString("cnpj");
                String descricao = resultSet.getString("descricao");



                Loja lojas = new Loja(cnpj, descricao);

                listaLojas.add(lojas);
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaLojas;
    }

    public void insert(Loja loja){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlInsert = "INSERT INTO Loja VALUES(?, ?)";

            PreparedStatement statement = conn.prepareStatement(sqlInsert);
            statement.setString(1, loja.getCnpj());
            statement.setString(2, loja.getDescricao());

            statement.executeQuery();

            statement.close();


        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Loja loja){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlUpdate = "UPDATE Loja SET descricao = ? WHERE loja.cnpj = ?";

            PreparedStatement statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1, loja.getDescricao());
            statement.setString(2, loja.getCnpj());

            statement.executeQuery();

            statement.close();

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Loja loja){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlDelete = "DELETE Loja WHERE cnpj = ?";

            PreparedStatement stantement = conn.prepareStatement(sqlDelete);
            stantement.setString(1, loja.getCnpj());

            stantement.executeQuery();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
