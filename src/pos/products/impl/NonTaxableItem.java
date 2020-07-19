package pos.products.impl;

import pos.checkout.Register;

public class NonTaxableItem extends Item {
    private double itemTax = 0.0;

    //Items exempt from taxes include books, food, and medical supplies.
    public NonTaxableItem(String name, double price, boolean isImported, Register register) {
        super(name, price, isImported);
        if(isImported()) {
            itemTax += Math.round((price * register.getImportDuty()) * 20.0) / 20.0;
        }
    }

    public double getItemTax() {
        return itemTax;
    }

    @Override
    public boolean isTaxable() {
        return false;
    }

}
