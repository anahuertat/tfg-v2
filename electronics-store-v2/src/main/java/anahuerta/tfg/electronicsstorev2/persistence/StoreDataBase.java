package anahuerta.tfg.electronicsstorev2.persistence;

import java.lang.Thread.State;
import java.nio.channels.SelectableChannel;
import java.sql.*;

public class StoreDataBase {
	//Database URL
	static final String DB_URL = "jdbc:mysql://localhost/tfg";
	//Database credentials
    static final String USER = "root";
    static final String PASS = "psswd";
    
   
	public boolean inStock(Integer reference, int quantity) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement;
		String queryInStock = "SELECT STOCK FROM components WHERE REFERENCE=?";
		try {
			//1. create connection
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection(DB_URL,USER,PASS);
		    //2. prepare statement
			preparedStatement = connection.prepareStatement(queryInStock);
			//3. set parameters in statement
			preparedStatement.setInt(1, reference);
			//4. Execute query
			resultSet = preparedStatement.executeQuery();
			//5. Extract data from ResultSet
			while(resultSet.next()) {
				if(resultSet.getInt("stock")>=quantity)
					return true;
				else
					return false;
			}
			 //6. Clean-up environment
			 resultSet.close();
			 preparedStatement.close();
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
		      if(connection!=null)
		         connection.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }
		}
		return false;
	}

	public void updateStock(Integer reference) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement;
		String updateStock = "UPDATE STOCK FROM components WHERE REFERENCE=?";
		try {
			//1. create connection
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection(DB_URL,USER,PASS);
		    //2. prepare statement
			preparedStatement = connection.prepareStatement(updateStock);
			//3. set parameters in statement
			preparedStatement.setInt(1, reference);
			//4. Execute query
			resultSet = preparedStatement.executeQuery();
			//5. Extract data from ResultSet
			while(resultSet.next()) {
				//resultSet.updateInt("stock", (resultSet.getInt("stock")-quantity));
				resultSet.updateInt("stock", (resultSet.getInt("stock")-1));
				
			}
			 //6. Clean-up environment
			 resultSet.close();
			 preparedStatement.close();
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
		      if(connection!=null)
		         connection.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }
		}
		
		
	}

	//public void updateStock(Integer reference, int quantity) {	}

}











