package anahuerta.tfg.electronicsstorev2.domain;

import java.util.List;

public class User {
	public Integer user_id;
	public String name;
	public String last_name;
	public String address;
	public String email;
	public String password;
	private List<Order> orders;
	
	public User(Integer user_id, String name, String last_name, String address, String email, String password) {
		this.user_id = user_id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String last_name, String address, String email, String password) {
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	public Integer getUserId() {
		return user_id;
	}
	
	public void setUserId(Integer id) {
		this.user_id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String a) {
		this.name = a;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public List<Order> getOrders(){
		return orders;
	}
}
