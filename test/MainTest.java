import org.junit.jupiter.api.Test;
import pos.checkout.Register;
import pos.products.ShoppingCart;
import pos.products.impl.Item;
import pos.products.impl.NonTaxableItem;
import pos.products.impl.TaxableItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class MainTest {

    @Test
    public void testReceiptRecordsAccurateTax() {
        var register = new Register(0.1, 0.05);
        var cart1 = new ShoppingCart();
        cart1.addItem(new NonTaxableItem("Lord of the Rings, the 2 towers", 12.49, false));
        cart1.addItem(new TaxableItem("Music CD", 14.99, false));
        cart1.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false));

        register.reset();

        List<Item> itemsInCart = cart1.getItems();
        for(Item i : itemsInCart){
            register.scan(i);
        }
        var receipt = register.submit(itemsInCart);
        assertEquals(1.50, receipt.getTax());
    }

    @Test
    public void testReceiptRecordsAccurateTotal() {
        var register = new Register(0.1, 0.05);
        var cart1 = new ShoppingCart();
        cart1.addItem(new NonTaxableItem("Lord of the Rings, the 2 towers", 12.49, false));
        cart1.addItem(new TaxableItem("Music CD", 14.99, false));
        cart1.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false));

        register.reset();

        List<Item> itemsInCart = cart1.getItems();
        for(Item i : itemsInCart){
            register.scan(i);
        }
        var receipt = register.submit(itemsInCart);
        assertEquals(29.83, receipt.getTotal());
    }
}
