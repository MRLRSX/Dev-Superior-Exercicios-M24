package mode.DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {
   
   private static Connection connection = null;
   public static Connection getConnection() {
	   try {
		   Properties props = loadProperties();
		   String url = props.getProperty("dburl");
	       connection  = DriverManager.getConnection(url, props);  	   
		   return connection;
	   }catch(SQLException erro) {
		   throw new DBException(erro.getMessage());
	   }
   }
   
   private static Properties loadProperties() {
	   try(FileInputStream fileInput = new FileInputStream("C:\\Curso Java\\Codigo Projeto 07\\JAVAFX-TESTE\\src\\db.properties")){
		   Properties props = new Properties();
		   props.load(fileInput);
		   return props; 
	   }catch(IOException erro) {
		   throw new DBException(erro.getMessage());
	   }
   } 
   public static void closeConnection(Connection connection) {
	   try {
		   if(connection != null) {
			   connection.close();
		   }
	   }catch(SQLException erro) {
		   throw new DBException(erro.getMessage());
	   }
   }
   
   public static void closeStatement(Statement statement) {
	   try {
		   if(statement != null) {
			   statement.close();
		   }
	   }catch(SQLException erro) {
		   throw new DBException(erro.getMessage());
	   }
   }
   
   public static void closeResultSet(ResultSet result) {
	   try {
		   if(result != null) {
			   result.close();
		   }
	   }catch(SQLException erro) {
		   throw new DBException(erro.getMessage());
	   }
   }
}
