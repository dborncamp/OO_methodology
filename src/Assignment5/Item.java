package Assignment5;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 4, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Item {
    private int itemNumber;
    private double price;
    private String name;

    public Item(String name, int itemNumber, double price) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.price = price;
    }

    /**
     * Get the Item number
     * @return - itemNumber
     */
    public int getItemNumber() {
        return itemNumber;
    }

    /**
     * Get the items price
     * @return - price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the items name
     * @return - name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Print the item nicely.
     * @return 
     */
    @Override
    public String toString(){
        return name + " $ " + price;
    }
}
