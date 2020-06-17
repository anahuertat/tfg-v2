package anahuerta.tfg.electronicsstorev2.service;

import java.util.List;

import anahuerta.tfg.electronicsstorev2.domain.Cart;
import anahuerta.tfg.electronicsstorev2.domain.Component;
import anahuerta.tfg.electronicsstorev2.domain.Order;
import anahuerta.tfg.electronicsstorev2.domain.User;

public interface ElectronicsStoreService {
	
	boolean addToCart(Integer reference);
	
	Cart checkout();

	List<Component> showCart();

	void confirm(Order order);

	User login(String email, String password);

	boolean removeFromCart(Integer reference);
}