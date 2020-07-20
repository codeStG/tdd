package checkout;

import org.junit.jupiter.api.Test;
import pos.checkout.Receipt;
import pos.checkout.Register;
import pos.products.ShoppingCart;
import pos.products.impl.Item;
import pos.products.impl.NonTaxableItem;
import pos.products.impl.TaxableItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    Register testRegister = new Register(0.10, 0.5);
    ShoppingCart testCart = new ShoppingCart();
    Receipt testReceipt;

    @Test
    public void testAccuracyOfReceiptTotal() {
        testCart.addItem(new NonTaxableItem("Book", 12.49, false, testRegister));
        testCart.addItem(new TaxableItem("Music CD", 14.99, false, testRegister));
        testCart.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false, testRegister));

        List<Item> itemsInCart = testCart.getItems();
        for (Item i : itemsInCart) {
            testRegister.scan(i);
        }

        testReceipt = testRegister.submit(testCart.getItems());

        assertEquals(29.83, testReceipt.getTotal());
    }

    @Test
    public void testAccuracyOfReceiptSubtotal() {
        testCart.addItem(new NonTaxableItem("Box of Chocolates", 10.00, true, testRegister));
        testCart.addItem(new TaxableItem("Bottle of Perfume", 47.50, true, testRegister));

        List<Item> itemsInCart = testCart.getItems();
        for (Item i : itemsInCart) {
            testRegister.scan(i);
        }

        testReceipt = testRegister.submit(testCart.getItems());

        assertEquals(57.50, testReceipt.getSubtotal());
    }
}
