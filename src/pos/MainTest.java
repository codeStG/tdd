package pos;

import pos.checkout.Register;
import org.junit.jupiter.api.Test;
import pos.products.ShoppingCart;
import pos.products.impl.NonTaxableItem;
import pos.products.impl.TaxableItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void test1() {
        var register = new Register(0.1, 0.05);
        var cart1 = new ShoppingCart();
        cart1.add(new NonTaxableItem("Lord of the Rings, the 2 towers", 12.49, false));
        cart1.add(new TaxableItem("Music CD", 14.99, false));
        cart1.add(new NonTaxableItem("Chocolate Bar", 0.85, false));

        register.reset();
        for each (IProduct p in cart1){
            register.scan(p);
        }
        var receipt = register.submit();
        assertEquals(1.50, receipt.salesTax);
        assertEquals(29.83, receipt.total);
    }

}
