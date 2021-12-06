package behavioral_design_pattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a1101381
 */
public class StretegyPatternSimpleOneMain {
    public static void main(String[] args) {
        Shopping shopping;
        Region region = Region.EUR;

        if(region == Region.USA) {
            shopping = new AmericaShopping();
        } else {
            shopping = new EuropeShopping();
        }

        Cart cart = new Cart(shopping);
        cart.addProduct(new Product(0, "Dell", 125, Size.L));
        cart.addProduct(new Product(1, "Iphone", 1235, Size.S));
        cart.addProduct(new Product(2, "TV", 535, Size.XL));

        double totalPrice = cart.getTotalPrice();
        System.out.println("Total price : " + totalPrice);
    }
}

class AmericaShopping implements Shopping {

    @Override
    public double price(List<Product> products) {
        return 0.1;
    }
}

class EuropeShopping implements Shopping {
    @Override
    public double price(List<Product> products) {
        return 2.0;
    }
}

interface Shopping {
    double price(List<Product> products);

}


//Note: Dummy Class to do ignored
class Product {
    private int id;
    private String name;
    private double price;
    private Size size;

    public Product(int id, String name, double price, Size size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

enum Size {
    S(1),
    L(2),
    XL(3);

    private int size;

    Size(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return switch (size) {
            case 1 -> "S";
            case 2 -> "L";
            case 3 -> "XL";
            default -> "CUSTOM";
        };
    }
}

enum Currency {

    EUR(1),
    USD(2);

    private int currency;

    Currency(int currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return switch (currency) {
            case 1 -> "EUR";
            case 2 -> "USD";
            default -> "UNKNOWN";
        };
    }
}

enum Region {

    EUR(1),
    USA(2);

    private int region;

    Region(int regionNumber) {
        this.region = region;
    }

    public int getRegion() {
        return region;
    }

    @Override
    public String toString() {
        switch(region) {
            case 1:
                return "EUR";
            case 2:
                return "USA";
            default:
                return "UNKNOWN";
        }
    }
}

class Cart {
    private Shopping shopping;
    private List<Product> products;

    public Cart(Shopping shopping) {
        this.shopping = shopping;
        products = new ArrayList();
    }

    public double getTotalPrice() {
        return shopping.price(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}