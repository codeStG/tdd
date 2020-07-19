package pos.products.impl;

import pos.checkout.Register;

public class TaxableItem extends Item {
    private double itemTax = 0.0;

    public TaxableItem(String name, double price, boolean isImported, Register register) {
        super(name, price, isImported);
        if(isImported()) {
            itemTax = Math.round((price * register.getSalesTax()) * 20.0) / 20.0;
            itemTax += Math.round((price * register.getImportDuty()) * 20.0) / 20.0;
        } else {
            itemTax = Math.round((price * register.getSalesTax()) * 20.0) / 20.0;
        }
    }

    public double getItemTax() {
        return itemTax;
    }

    @Override
    public boolean isTaxable() {
        return true;
    }
}
