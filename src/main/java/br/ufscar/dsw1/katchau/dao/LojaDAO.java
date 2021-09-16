package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Loja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LojaDAO extends GenericDAO{
    public List<Loja> select() {
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
}
