package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAO{
    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql1 = "SELECT * from Usuario";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String codigo = resultSet.getString("codigo");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                int papel = resultSet.getInt("papel");
                Usuario user = new Usuario(codigo,email,senha,papel,nome);

                listaUsuarios.add(user);
            }
//
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaUsuarios;
    }

    public Usuario read(String userCodigo) {
        if(userCodigo == null)
            return null;
        Usuario user;

        String sql1 = "SELECT * from Usuario u where u.codigo = ?";
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1, userCodigo);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                int papel = resultSet.getInt("papel");
                user = new Usuario(codigo,email,senha,papel,nome);
            }else {
                return null;
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
