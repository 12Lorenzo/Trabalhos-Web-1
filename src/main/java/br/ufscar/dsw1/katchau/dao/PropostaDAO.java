package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.


import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Proposta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PropostaDAO extends GenericDAO {

    public List<Proposta> read(Cliente cliente) {

        List<Proposta> listaPropostas = new ArrayList<>();

        String sql1 = "SELECT * from Proposta WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
//            if(lojaCnpj != null) {
//                PreparedStatement statement = conn.prepareStatement(sql);
//
//                statement.setString(1, lojaCnpj);
//                resultSet = statement.executeQuery();
//                state ment.close();
//            } else {
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1, cliente.getCpf());
            resultSet = statement.executeQuery();

//            }
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String condPag = resultSet.getString("condPag");
                int status = resultSet.getInt("status");
                String descricao = resultSet.getString("descricao");
                Long carro_id = resultSet.getLong("carro_id");
                float val = resultSet.getFloat("val");
                Date data = resultSet.getDate("data");

                Proposta proposta = new Proposta(id, status, data, val, cnpj, carro_id, condPag);

                listaPropostas.add(proposta);
            }
//
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPropostas;
    }

}
