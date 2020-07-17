package pos.checkout;

import pos.products.IProduct;

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

    }

    public Receipt submit() {
        return new Receipt();
    }

    public double scan(IProduct product) {
        total += product.getPrice();
        return total;
    }

    public double calculateTotal() {

    }

    public double calculateItemSalesTax() {

    }

    public double
}
