package pos;

import pos.checkout.Receipt;
import pos.checkout.Register;
import pos.products.ShoppingCart;
import pos.products.impl.Item;
import pos.products.impl.NonTaxableItem;
import pos.products.impl.TaxableItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Register register = new Register(0.1, 0.05);
        ShoppingCart cartOne = new ShoppingCart();
        List<Item> itemsInCart = cartOne.getItems();

        cartOne.addItem(new NonTaxableItem("Book", 12.49, false));
        cartOne.addItem(new TaxableItem("Music CD", 14.99, false));
        cartOne.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false));

        register.reset();

        for(Item item : itemsInCart){
            register.scan(item);
        }

        Receipt receipt = register.submit(itemsInCart);
        receipt.print();

        ShoppingCart cartTwo = new ShoppingCart();

        cartTwo.addItem(new NonTaxableItem("Box of Chocolates", 10.00, true));
        cartTwo.addItem(new TaxableItem("Perfume", 47.50, true));

        register.reset();
        itemsInCart = cartTwo.getItems();

        for(Item item : itemsInCart) {
            register.scan(item);
        }

        receipt = register.submit(itemsInCart);
        receipt.print();

    }

}
