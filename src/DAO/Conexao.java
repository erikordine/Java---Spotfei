
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
    public static Connection getConnection() throws SQLException{
        java.sql.Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/spotfei",
                "postgres", 
                "@Ordine2310");
        return conexao;
    }
}

