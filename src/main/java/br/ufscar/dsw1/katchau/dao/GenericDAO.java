package br.ufscar.dsw1.katchau.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//São as chamadas sql.


abstract public class GenericDAO {

    public GenericDAO() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {

        /* Conexão banco de dados MySQL */
        return DriverManager.getConnection(System.getenv("DATABASE_URI"), System.getenv("KATCHAU_DATABASE_USER"), System.getenv("KATCHAU_DATABASE_PASSWORD"));
    }
}