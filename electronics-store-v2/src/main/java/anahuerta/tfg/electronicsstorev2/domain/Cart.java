package anahuerta.tfg.electronicsstorev2.domain;

import java.util.List;

import anahuerta.tfg.electronicsstorev2.persistence.StoreDataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
	List<Component> cartItems = new ArrayList<Component>();

    public void addToCart(Component component) {
    		cartItems.add(component);
    }

    public void removeComponentByRef(Integer reference) {
    		List<Component> aux = cartItems; //we make a copy of cartItems so we can delete while iterating
        Iterator<Component> iterator = cartItems.iterator();
        while(iterator.hasNext()) {
        		Component c = iterator.next();
        		if(c.getReference().equals(reference)) {
        			aux.remove(c);
        		}
        }
        cartItems.clear();
        cartItems.addAll(aux); //we update cartItems
    }

    public void printCartItems() {
        for (Component c: cartItems) {
        		if(c != null) {
        			System.out.println(c.getReference() +" : "+ c.getName());
        		}
        }
    }
    
    public List<Component> getCartItems() {
    		return cartItems;
    }
}
