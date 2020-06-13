package anahuerta.tfg.electronicsstorev2.persistence;

import java.sql.*;

public class DataBaseConnection {

	   // JDBC driver name and database URL
	   //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/test";
	   //static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	   // Database credentials
	   static final String USER = "root";
	   static final String PASS = "Iimthiwilris1";
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			//1. Create connection
			//Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Connecting to database...");
		    connection = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//2. Create statement object
		    System.out.println("Creating statement...");
			statement = connection.createStatement();
			
			//3. Execute SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM component");
			
			//4. Extract data from ResultSet
			while(resultSet.next()) {
				//Retrieve by column name
			      int reference  = resultSet.getInt("reference");
			      String name = resultSet.getString("name");
			      double price = resultSet.getDouble("price");
			      int stock = resultSet.getInt("stock");
			      String category = resultSet.getString("category");

			      //Display values
			      System.out.print("reference: " + reference);
			      System.out.print(", name: " + name);
			      System.out.print(", price: " + price);
			      System.out.print(", stock: " + stock);
			      System.out.println(", category: " + category);
			}
		
			 //STEP 5: Clean-up environment
			 resultSet.close();
			 statement.close();
			 connection.close();
			 
		}catch(SQLException se){
			   //Handle errors for JDBC
			   se.printStackTrace();
		}catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		}finally{
		   //finally block used to close resources
		   try{
		      if(statement!=null)
		         statement.close();
		   }catch(SQLException se2){
		   }// nothing we can do
		   try{
		      if(connection!=null)
		         connection.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }
		}

	}

}









