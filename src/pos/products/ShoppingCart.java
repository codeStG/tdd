package pos.products;

import pos.products.impl.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> removeItem(String itemName) {
        items.remove(itemName);
        return items;
    }

    public List<Item> getItems() {
        return items;
    }
}
