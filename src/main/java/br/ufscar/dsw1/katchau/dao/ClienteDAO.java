package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Erros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends GenericDAO implements Cloneable {
    public List<Cliente> read() {
        String sqlSelect = "SELECT * FROM Cliente";

        List<Cliente> listaClientes = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sqlSelect);
            resultSet = statement.executeQuery();

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

    public int insert(Cliente cliente){
        try {
            Connection conn = this.getConnection();

            String sqlInsert = "INSERT INTO Cliente(cpf, telefone, sexo, nascimento) VALUES(?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sqlInsert);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getSexo());
            statement.setDate(4, new java.sql.Date(cliente.getNascimento().getTime()));

            statement.executeUpdate();

            statement.close();
            conn.close();
            return 0;

        } catch(SQLException e){
            return Erros.erro(e);
        }
    }

    public int update(String telefone, String sexo, java.util.Date nascimento, String cpf){
        Cliente cli = new Cliente(cpf, telefone, sexo, nascimento);
        return update(cli);
    }

    public int update(Cliente cliente){
        try {
            Connection conn = this.getConnection();
            String sqlUpdate = "UPDATE Cliente cliente SET telefone = ?, sexo = ?, nascimento = ? WHERE cliente.cpf = ?";

            PreparedStatement statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1, cliente.getTelefone());
            statement.setString(2, cliente.getSexo());
            statement.setDate(3, new java.sql.Date(cliente.getNascimento().getTime()));
            statement.setString(4, cliente.getCpf());

            statement.executeUpdate();
            statement.close();
            conn.close();
            return 0;
        } catch(SQLException e){
            return Erros.erro(e);
        }
    }

    public int delete(String clicpf){
        try {
            Connection conn = this.getConnection();

            String sqlDelete = "DELETE FROM  Cliente WHERE cpf = ?";

            PreparedStatement stantement = conn.prepareStatement(sqlDelete);
            stantement.setString(1, clicpf);

            stantement.executeUpdate();
            stantement.close();
            conn.close();
            return 0;
        }catch(SQLException e){
            return Erros.erro(e);
        }
    }
    public Cliente clone(Cliente cli){
        Cliente novoCli = new  Cliente();
        novoCli.setCpf(cli.getCpf());
        novoCli.setTelefone(cli.getTelefone());
        novoCli.setSexo(cli.getSexo());
        novoCli.setNascimento(cli.getNascimento());

        return novoCli;
    }

    public Cliente retornaCli(String cpfReceber){

        String sqlSelect = "SELECT * FROM Cliente c WHERE c.cpf = ?";

        Cliente cli;
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;

            PreparedStatement statement = conn.prepareStatement(sqlSelect);
            statement.setString(1, cpfReceber);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date nascimento = resultSet.getDate("nascimento");
                String sexo = resultSet.getString("sexo");
                cli = new Cliente(cpf, telefone, sexo, nascimento);
            }else {
                return null;
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return cli;

    }


    @Override
    public ClienteDAO clone() {
        try {
            return (ClienteDAO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
