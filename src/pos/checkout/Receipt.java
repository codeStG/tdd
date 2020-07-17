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

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public double getTax() {
        return getTotal() - getSubtotal();
    }

    public void print() {
        for(Item item : items) {
            System.out.println(item.getName());
            System.out.println("\t\t\t\t\t" + Math.round(item.getPrice() * 100.0) / 100.0);
            System.out.println("--------------------------");
        }
        System.out.println("\nSubtotal: \t\t\t" + Math.round(subtotal * 100.0) / 100.0);
        System.out.println("Tax: \t\t\t\t" + Math.round((total - subtotal) * 100.0) / 100.0);
        System.out.println("Total: \t\t\t\t" + Math.round(total * 100.0) / 100.0);
        System.out.println();
    }
}
