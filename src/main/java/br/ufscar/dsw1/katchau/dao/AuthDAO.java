package br.ufscar.dsw1.katchau.dao;

import br.ufscar.dsw1.katchau.entidade.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO extends  GenericDAO{
    public Usuario validate(String email, String senha) {
        String sql = "SELECT * from Usuario u where u.email = ?";
        String vSenha, codigo, nome;
        int papel;
        if(email == null || senha == null)
            return null;
        try {
            Connection conn = this.getConnection();
            ResultSet resultSet;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vSenha = resultSet.getString("senha");
                codigo = resultSet.getString("codigo");
                nome = resultSet.getString("nome");
                papel = resultSet.getInt("papel");

            }else {
                return null;
            }
            resultSet.close();
            statement.close();
            conn.close();
            if(vSenha != null && codigo != null && vSenha.equals(convert(senha))){
                return new Usuario(codigo,email,senha,papel,nome);
            }else {
                return null;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String convert(String secret){
        return secret;
    }


}
