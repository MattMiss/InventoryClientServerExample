import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Product {
    private String name;
    private int count;
    private double cost;
    private double discount;
    private Lock countChangeLock;

    /**
     * Constructs a product with a given name, count of 0, cost of 0, and discount of 0
     */
    public Product(String name){
        this.name = name;
        count = 0;
        cost = 0;
        discount = 0;
        countChangeLock = new ReentrantLock();
    }

    /**
     * Constructs a product with a given name, count of 0, given cost, and discount of 0
     * @param initialCost the initial cost
     */
    public Product(String name, int initialCost){
        this.name = name;
        count = 0;
        cost = initialCost;
        discount = 0;
        countChangeLock = new ReentrantLock();
    }

    /**
     Add amount to the product count
     @param amount the amount to add
     */
    public void add(int amount){
        countChangeLock.lock();
        try{
            count += amount;
        }
        finally{
            countChangeLock.unlock();
        }
    }

    /**
     Remove amount from the product count
     @param amount the amount to remove
     */
    public void remove(int amount){
        countChangeLock.lock();
        try{
            count -= amount;
            count = count < 0 ? 0: count;
        }
        finally{
            countChangeLock.unlock();
        }
    }

    /**
     Set new percent for discount
     @param percent the new discount percentage
     @return the new cost of the product
     */
    public double setDiscount(double percent){
        discount = percent;
        if (percent == 0){
            return cost;
        }else{
            return cost * (percent / 100);
        }
    }

    /**
     Set new amount for cost
     @param amount the new cost amount
     @return the new cost of the product
     */
    public double setCost(double amount){
        cost = amount;
        return cost;
    }

    /**
     Set discount to zero
     @return the new cost of the product
     */
    public double removeDiscount(){
        discount = 0;
        return cost;
    }

    /**
     Gets the current count of the product.
     @return the current product count
     */
    public int getCount()
    {
        return count;
    }

    /**
     Gets the current cost of the product.
     @return the current product cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     Gets the current discount of the product.
     @return the current product discount
     */
    public double getDiscount()
    {
        return discount;
    }

    /**
     Gets the current name of the product.
     @return the current product name
     */
    public String getName()
    {
        return name;
    }
}
