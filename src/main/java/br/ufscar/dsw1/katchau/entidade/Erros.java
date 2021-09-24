package br.ufscar.dsw1.katchau.entidade;

import java.sql.SQLException;

public class Erros {
    public static int erro(SQLException e){
        System.out.println("ocorreu um erro: " +e);
        return 3;
    }
}
