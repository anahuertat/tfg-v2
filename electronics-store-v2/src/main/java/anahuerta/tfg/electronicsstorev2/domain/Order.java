package anahuerta.tfg.electronicsstorev2.domain;

import java.sql.Timestamp;

public class Order {
	public Integer order_number;
	public String address;
	public Timestamp order_date;
	public User user;
	
	public Order(Integer order_number, String address, Timestamp order_date, User user) {
		this.order_number = order_number;
		this.address = address;
		this.order_date = order_date;
		this.user = user;
	}
	
	public Order(String address, User user) {
		this.address = address;
		this.user = user;
	}
	
	public Integer getOrderNumber(){
		return order_number;
	}
	
	public void setOrderNumber(Integer n) {
		this.order_number = n;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String a) {
		this.address = a;
	}
	
	public Timestamp getOrderDate(){
		return order_date;
	}
	
	public void setOrderDate(Timestamp d) {
		this.order_date = d;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
}

