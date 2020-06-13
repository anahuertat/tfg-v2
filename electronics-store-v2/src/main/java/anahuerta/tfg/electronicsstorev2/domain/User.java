package anahuerta.tfg.electronicsstorev2.domain;

import java.util.List;

public class User {
	public Integer user_id;
	public String name;
	public String address;
	public String email;
	private List<Order> orders;
	
	public User(Integer user_id, String name, String address, String email) {
		this.user_id = user_id;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	public User(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
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
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public List<Order> getOrders(){
		return orders;
	}
}
