package anahuerta.tfg.electronicsstorev2.service.impl;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import anahuerta.tfg.electronicsstorev2.domain.Cart;
import anahuerta.tfg.electronicsstorev2.domain.Component;
import anahuerta.tfg.electronicsstorev2.persistence.StoreDataBase;
import anahuerta.tfg.electronicsstorev2.service.ElectronicsStoreService;



@Service
public class ElectronicsStoreServiceImpl implements ElectronicsStoreService{
	private Cart cart = new Cart();
	private StoreDataBase storeDB = new StoreDataBase();
	
	@Override
	public boolean addToCart(Integer reference, int quantity) {
		if(storeDB.inStock(reference, quantity)) {
			for(int i=0; i<quantity; i++){
				cart.addToCartByRef(reference, quantity);
			}
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
	public void confirm() {
		//como ver si un item tiene quantity>1?
		List<Component> items = cart.getCartItems();
		Iterator<Component> it = items.iterator();
		while(it.hasNext()) {
			Component c = it.next();
			storeDB.updateStock(c.getReference());
		}
		
	}

}