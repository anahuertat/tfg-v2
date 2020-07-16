package anahuerta.tfg.electronicsstorev2.persistence;

import java.sql.*;

import anahuerta.tfg.electronicsstorev2.domain.Component;
import anahuerta.tfg.electronicsstorev2.domain.Order;
import anahuerta.tfg.electronicsstorev2.domain.User;

public class StoreDataBase {
	//Database URL
	static final String DB_URL = "jdbc:mysql://localhost/tfg";
	//Database credentials
    static final String USER = "root";
    static final String PASS = "psswd";
    
    public Component getComponentByRef(Integer reference) {
    		Component component = null;
    		Connection connection = null;
    		ResultSet resultSet = null;
    		PreparedStatement preparedStatement;
    		String query = "SELECT * FROM product WHERE reference=?";
    		try {
    			//1. Create connection
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			connection = DriverManager.getConnection(DB_URL, USER, PASS);
    			//2. Prepare statement
    			preparedStatement = connection.prepareStatement(query);
    			//3. Set parameters in statement
    			preparedStatement.setInt(1, reference);
    			//4. Execute query
    			resultSet = preparedStatement.executeQuery();
    			//5. Extract data from resultset 
    			if(resultSet.next()) {
    				component = new Component(
        					resultSet.getString("category"), 
        					resultSet.getString("name"), 
        					resultSet.getDouble("price"), 
        					reference, 
        					resultSet.getInt("stock"));
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
    		return component;
    }
   
	public int getStock(Integer reference) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement;
		String queryInStock = "SELECT STOCK FROM product WHERE REFERENCE=?";
		int stock = -1;
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
			if(resultSet.next()) {
				stock = resultSet.getInt("stock");
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
		return stock;
	}

	public void updateStock(Integer reference) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		String updateStock = "UPDATE product SET stock=? WHERE reference=?";
		int stock = this.getStock(reference);
		try {
			//1. create connection
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection(DB_URL,USER,PASS);
		    //2. prepare statement
			preparedStatement = connection.prepareStatement(updateStock);
			//3. set parameters in statement
			preparedStatement.setInt(1, stock-1);
			preparedStatement.setInt(2, reference);
			//4. Execute query
			int row = preparedStatement.executeUpdate(updateStock);
			//5. Number of rows affected
			System.out.println(row);	
			 //6. Clean-up environment
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

	public User login(String email, String password) {
		User user = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement;
		String query = "SELECT * FROM user WHERE email=? AND password=?";
		try {
			//1. Create connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//2. Prepare statement
			preparedStatement = connection.prepareStatement(query);
			//3. Set parameters in statement
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			//4. Execute query
			resultSet = preparedStatement.executeQuery();
			//5. Extract data from resultset 
			if(resultSet.next()) {
				user = new User(
						resultSet.getInt("user_id"), 
						resultSet.getString("name"), 
						resultSet.getString("last_name"), 
						resultSet.getString("address"), email, password);
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
		return user;
	}

	public void createOrder(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		String update = "INSERT INTO order_details (address, user_id) VALUES (address=?, user_id=?)";
		try {
			//1. Create connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//2. Prepare statement
			preparedStatement = connection.prepareStatement(update);
			//3. Set parameters in statement
			preparedStatement.setString(1, order.getAddress());
			preparedStatement.setInt(2, order.getUser().getUserId());
			//4. Execute query
			int row = preparedStatement.executeUpdate(update);
			//5. Number of rows affected 
			System.out.println(row);
			//6. Clean-up environment
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











