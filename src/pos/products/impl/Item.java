package pos.products.impl;

import pos.products.IProduct;

public abstract class Item implements IProduct {
    private final String name;
    private final double price;
    private final boolean isImported;

    public Item(String name, double price, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public abstract boolean isTaxable();
}
