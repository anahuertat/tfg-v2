package anahuerta.tfg.electronicsstorev2.domain;

import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
	List<Component> cartItems = new ArrayList<Component>();

    public void addToCart(Component component) {
    		cartItems.add(component);
    }

    public boolean removeComponentByRef(Integer reference) {
    		if(cartItems.isEmpty()) {
			return false;
		}else{
			Iterator<Component> it = cartItems.iterator();
			while(it.hasNext()) {
				Component component = it.next();
				if(component.getReference().equals(reference)) {
					cartItems.remove(component);
					return true;
				}
			}
		}
    		return false;
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
    
    public boolean containsByRef(Integer reference) {
    		if(cartItems.isEmpty()) {
    			return false;
    		}else {
    			Iterator<Component> it = cartItems.iterator();
    			while(it.hasNext()) {
    				if(it.next().getReference().equals(reference))
    					return true;
    			}
    		}
    		return false;
    }
}
