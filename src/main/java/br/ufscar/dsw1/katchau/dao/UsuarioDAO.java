package br.ufscar.dsw1.katchau.dao;

//São as chamadas sql.

import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Erros;
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

    public int insert(Usuario usuario){
        try {
            Connection conn = this.getConnection();

            String sqlInsert = "INSERT INTO Usuario(email, nome, senha, codigo, papel) VALUES(?, ?, ?, ?, 3)";

            PreparedStatement statement = conn.prepareStatement(sqlInsert);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getCodigo());

            statement.executeUpdate();

            statement.close();
            conn.close();
            return 0;

        } catch(SQLException e){
            return Erros.erro(e);
        }
    }

    public int update(String oldcpf, Usuario usuario){
        try {
            Connection conn = this.getConnection();
            String sqlUpdate = "UPDATE Usuario u SET email = ?, nome = ?, senha = ?, codigo = ? WHERE u.codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getCodigo());
            statement.setString(5, oldcpf);

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

            String sqlDelete = "DELETE FROM  Usuario WHERE codigo = ?";

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
}
