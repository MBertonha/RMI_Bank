package rmiMM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
   public String url = "jdbc:postgresql://localhost:5432/banco";  
   public String usuario = "postgres";  
   public String senha = "postgre";  
   
   public Connection Conexao() throws SQLException
   {
        Connection conex;   
        conex = DriverManager.getConnection(url, usuario, senha);    
        System.out.println("Conexão realizada com sucesso.");  
        return conex; 
   }
}
