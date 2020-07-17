package pos.products.impl;

public class NonTaxableItem extends Item {

    public NonTaxableItem(String name, double price, boolean isImported) {
        super(name, price, isImported);
    }

    @Override
    public boolean isTaxable() {
        return false;
    }

}
