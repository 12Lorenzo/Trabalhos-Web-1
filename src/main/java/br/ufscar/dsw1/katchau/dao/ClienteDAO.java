package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends GenericDAO {
    public List<Cliente> select() {
        String sqlSelect = "SELECT * FROM Cliente";

        List<Cliente> listaClientes = new ArrayList<>();
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
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date nascimento = resultSet.getDate("nascimento");
                String sexo = resultSet.getString("sexo");

                Cliente cliente = new Cliente(cpf, telefone, sexo, nascimento);

                listaClientes.add(cliente);
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void insert(Cliente cliente){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlInsert = "INSERT INTO Cliente VALUES(?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sqlInsert);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getSexo());
            statement.setDate(4, new java.sql.Date(cliente.getNascimento().getTime()));

            statement.executeQuery();

            statement.close();


        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlUpdate = "UPDATE Cliente SET telefone = ?, sexo = ?, nascimento = ? WHERE cliente.cpf = ?";

            PreparedStatement statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1, cliente.getTelefone());
            statement.setString(2, cliente.getSexo());
            statement.setDate(3, new java.sql.Date(cliente.getNascimento().getTime()));
            statement.setString(4, cliente.getCpf());

            statement.executeQuery();

            statement.close();

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Cliente cliente){
        try {
            Connection conn = this.getConnection();
            //ResultSet resultSet;

            String sqlDelete = "DELETE Cliente WHERE cpf = ?";

            PreparedStatement stantement = conn.prepareStatement(sqlDelete);
            stantement.setString(1, cliente.getCpf());

            stantement.executeQuery();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}
