package pos.checkout;

import pos.products.IProduct;
import pos.products.impl.Item;

import java.util.List;

public class Register {
    private final double salesTax;
    private final double importDuty;
    private double subtotal;
    private double total;

    public Register(double salesTax, double importDuty) {
        this.salesTax = salesTax;
        this.importDuty = importDuty;
    }

    public void reset() {
        subtotal = 0;
        total = 0;
    }

    public Receipt submit(List<Item> items) {
        return new Receipt(items, subtotal, total);
    }

    public void scan(IProduct product) {
        double temp = 0;
        subtotal += product.getPrice();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getImportDuty() {
        return importDuty;
    }

    //    public double calculateTotal() {
//
//    }
//
//    public double calculateItemSalesTax() {
//
//    }
//
//    public double
//}


}