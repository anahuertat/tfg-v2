package anahuerta.tfg.electronicsstorev2.service.impl;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import anahuerta.tfg.electronicsstorev2.domain.Cart;
import anahuerta.tfg.electronicsstorev2.domain.Component;
import anahuerta.tfg.electronicsstorev2.domain.Order;
import anahuerta.tfg.electronicsstorev2.domain.User;
import anahuerta.tfg.electronicsstorev2.persistence.StoreDataBase;
import anahuerta.tfg.electronicsstorev2.service.ElectronicsStoreService;



@Service
public class ElectronicsStoreServiceImpl implements ElectronicsStoreService{
	private Cart cart = new Cart();
	private StoreDataBase storeDB = new StoreDataBase();
	
	@Override
	public boolean addToCart(Integer reference) {
		if(storeDB.getStock(reference)>0) {
			Component c = storeDB.getComponentByRef(reference);
			cart.addToCart(c);
			System.out.println(cart.toString());
			return true;
		}
		return false;
	}

	@Override
	public Cart checkout() {
		return cart;
	}

	@Override
	public List<Component> showCart() {
		return cart.getCartItems();
	}

	@Override
	public void confirm(Order order) {
		List<Component> items = cart.getCartItems();
		Iterator<Component> it = items.iterator();
		while(it.hasNext()) {
			Component c = it.next();
			storeDB.updateStock(c.getReference());
		}
		storeDB.createOrder(order);
	}

	@Override
	public User login(String email, String password) {
		return storeDB.login(email, password);
	}

	@Override
	public boolean removeFromCart(Integer reference) {
		return cart.removeComponentByRef(reference);
	}

}