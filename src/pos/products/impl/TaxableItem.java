package pos.products.impl;

public class TaxableItem extends Item {

    public TaxableItem(String name, double price, boolean isImported) {
        super(name, price, isImported);
    }

    @Override
    public boolean isTaxable() {
        return true;
    }
}
