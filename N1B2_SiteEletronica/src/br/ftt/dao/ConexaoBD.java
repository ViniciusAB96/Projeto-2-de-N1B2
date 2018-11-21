package br.ftt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    public static Connection getConexao() {
	Connection conexao = null;        
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// nome do driver de conexao
	            conexao = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
	                    + "database=JCadastro;" +
                              "user=sa;" +
                              "password=123456;");
	        
	        } catch (Exception erro) {
	            erro.printStackTrace();
	        }
        return conexao;
    }   
}
