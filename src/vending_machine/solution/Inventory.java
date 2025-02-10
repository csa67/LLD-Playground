package vending_machine.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Inventory {
    private final Map<Product,Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product p, int quantity) {
        products.put(p, quantity);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public void updateQuantity(Product p, int quantity) {
        products.put(p, quantity);
    }

    public int getQuantity(Product p) {
        return products.get(p);
    }

    public boolean isProductAvailable(Product p) {
        return products.containsKey(p) && products.get(p) > 0;
    }
}
