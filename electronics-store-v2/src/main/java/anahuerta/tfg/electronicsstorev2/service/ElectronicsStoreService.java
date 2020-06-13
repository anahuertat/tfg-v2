package anahuerta.tfg.electronicsstorev2.service;

import java.util.List;

import anahuerta.tfg.electronicsstorev2.domain.Cart;
import anahuerta.tfg.electronicsstorev2.domain.Component;

public interface ElectronicsStoreService {
	
	boolean addToCart(Integer reference, int quantity);
	
	Cart checkout();

	List<Component> showCart();

	void confirm();
}