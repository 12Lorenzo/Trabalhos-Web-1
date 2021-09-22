package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.


import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Proposta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PropostaDAO extends GenericDAO {

    public List<Proposta> read(Cliente cliente) {

        List<Proposta> listaPropostas;

        String sql1 = "SELECT * from Proposta p WHERE p.cpf = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1, cliente.getCpf());
            resultSet = statement.executeQuery();
            listaPropostas = getFromResult(resultSet);

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPropostas;
    }

    public List<Proposta> getAll() {

        List<Proposta> listaPropostas;

        String sql1 = "SELECT * from Proposta";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            resultSet = statement.executeQuery();
            listaPropostas = getFromResult(resultSet);
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPropostas;
    }

    public List<Proposta> getAll(String cnpj) {
        if (cnpj == null)
            return getAll();

        List<Proposta> listaPropostas;

        String sql1 = "SELECT * from Proposta p where p.cnpj = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1,cnpj);
            resultSet = statement.executeQuery();
            listaPropostas = getFromResult(resultSet);
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPropostas;
    }

    private List<Proposta> getFromResult(ResultSet resultSet){
        List<Proposta> listaPropostas = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                String condPag = resultSet.getString("condPag");
                int status = resultSet.getInt("status");
                Long carro_id = resultSet.getLong("carro_id");
                float val = resultSet.getFloat("val");
                Date data = resultSet.getDate("data");

                Proposta proposta = new Proposta(id, status, data, val, cnpj, carro_id, condPag, cpf);

                listaPropostas.add(proposta);

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaPropostas;
    }

    public int insert(Cliente cliente, Carro carro, Float valor, String proposta){
        if(cliente == null || carro == null || valor == null || proposta == null){
                return 400;
        }
            try {
                Connection conn = this.getConnection();
                String sqlInsert = "INSERT INTO Proposta(status, data, val, condPag, cnpj, cpf, carro_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                PreparedStatement statement = conn.prepareStatement(sqlInsert);
                statement.setInt(1, 0);
                statement.setDate(2, date); //data de hoje
                statement.setFloat(3, valor);
                statement.setString(4, proposta);
                statement.setString(5, carro.getCnpj());
                statement.setString(6, cliente.getCpf());
                statement.setLong(7, carro.getId());

                statement.executeUpdate();

                statement.close();


            } catch(SQLException e){
                System.out.println(e);
                return 3;
            }
            return 0;
        }

}
