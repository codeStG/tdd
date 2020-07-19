package pos.products;

public interface IProduct {
    String getName();

    double getPrice();

    double getItemTax();

    boolean isImported();

    boolean isTaxable();
}
