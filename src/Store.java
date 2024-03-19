import java.util.Objects;

/**
 A store consisting of multiple products
 */
public class Store {
    private Product[] products;

    /**
     * Constructs a store with a given number of products
     */
    public Store(int size){
        products = new Product[size];
        products[0] = new Product("HAT", 20);
        products[1] = new Product("SHIRT", 50);
        products[2] = new Product("GLOVES", 10);
        products[3] = new Product("PANTS", 70);
        products[4] = new Product("WATCH", 100);
        products[5] = new Product("SHOES", 60);
        products[6] = new Product("SOCKS", 15);
        products[7] = new Product("BRUSH", 5);
        products[8] = new Product("RING", 25);
        products[9] = new Product("BELT", 20);
    }

    /**
     * Increases the count of a product
     * @param productName the name of the product
     * @param amount the amount to increase the product by
     */
    public void add(String productName, int amount){
        Product product = getProduct(productName);
        if (product != null){
            getProduct(productName).add(amount);
        }
    }

    /**
     * Descreases the count of a product
     * @param productName the name of the product
     * @param amount the amount to decrease the product by
     */
    public void remove(String productName, int amount){
        Product product = getProduct(productName);
        if (product != null){
            getProduct(productName).remove(amount);
        }
    }


    /**
     * Set the percentage amount for discount
     * @param productName the name of the product
     * @param percent the percentage to discount
     */

    public void setDiscount(String productName, double percent){
        Product product = getProduct(productName);
        if (product != null){
            getProduct(productName).setDiscount(percent);
        }
    }

    /**
     * Gets the count of a product
     * @param productName the name of the product
     * @return the product count
     */
    public int getCount(String productName){
        int count = 0;
        Product product = getProduct(productName);
        if (product != null){
            count = product.getCount();
        }
        return count;
    }

    /**
     * Gets the cost of a product
     * @param productName the name of the product
     * @return the product cost
     */
    public double getCost(String productName){
        double cost = 0;
        Product product = getProduct(productName);
        if (product != null){
            cost = product.getCost();
        }
        return cost;
    }

    /**
     * Gets the cost of a product
     * @param productName the name of the product
     * @return the product cost
     */
    public double getDiscount(String productName){
        double cost = 0;
        Product product = getProduct(productName);
        if (product != null){
            cost = product.getCost();
        }
        return cost;
    }

    /**
     * Gets the cost of a product
     * @param productName the name of the product
     * @return the product cost
     */
    public double getDiscountedCost(String productName){

        Product product = getProduct(productName);
        double discountedCost = 0;
        if (product != null){
            discountedCost = product.getDiscount() == 0 ? product.getCost() : product.getCost() * (product.getDiscount() / 100);
        }
        return discountedCost;
    }

    /**
     * Removes the discount percent from a product
     * @param productName the name of the product
     */
    public void removeDiscount(String productName){
        Product product = getProduct(productName);
        if (product != null){
            product.removeDiscount();
        }
    }

    /**
     * Removes the discount percent from a product
     * @param productName the name of the product
     * @return a Product if product exists, null if it does not
     */
    private Product getProduct(String productName){
        for(Product p : products){
            if (Objects.equals(p.getName(), productName)){
                return p;
            }
        }
        return null;
    }
}
