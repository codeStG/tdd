package pos.checkout;

import pos.products.impl.Item;

import java.util.List;

public class Receipt {
    List<Item> items;
    double subtotal;
    double total;

    public Receipt(List<Item> items, double subtotal, double total) {
        this.items = items;
        this.subtotal = subtotal;
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public double getTax() {
        return getTotal() - getSubtotal();
    }
}
