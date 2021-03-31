
//Andy Liao
import java.util.HashMap;
import java.util.Set;

public class Cart {
    HashMap<String, Integer> cart = new HashMap<String, Integer>();
    Inventory inventory = new Inventory();

    void add(String item, int amount) {
        cart.put(item, amount);
        inventory.addToCart(item, amount);
    }

    void takeFromCart(String item, int amount) {
        if (amount < cart.get(item)) {
            cart.replace(item, cart.get(item) - amount);
        } else if (amount == cart.get(item)) {
            cart.remove(item);
        }
    }

    public double itemPrice(String item) {
        double itemPrice = inventory.getPrice(item) * cart.get(item);
        return itemPrice;
    }

    public double currentPrice() {
        double currentPrice = 0;
        for (String i : cart.keySet()) {
            currentPrice += (inventory.getPrice(i) * cart.get(i));
        }
        return currentPrice;
    }

    public boolean isInCart(String item) {
        return cart.containsKey(item);
    }

    public int size() {
        return cart.size();
    }

    public Set<String> keySet() {
        return cart.keySet();
    }

    public int qtyInCart(String item) {
        return cart.get(item);
    }

    public void printCart() {
        for (String key : cart.keySet()) {
            System.out.println(Integer.toString(cart.get(key)) + " " + key);
        }
    }

    public int itemsInCart() {
        int itemsInCart = 0;
        for (String key : cart.keySet()) {
            itemsInCart += cart.get(key);
        }
        return itemsInCart;
    }
}