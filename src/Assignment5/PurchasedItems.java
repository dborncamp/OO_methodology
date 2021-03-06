package Assignment5;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 4, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */

public class PurchasedItems {
    private ArrayList<Item> purchasedItems;
    private final Date date;

    public PurchasedItems(Date date) {
        this.purchasedItems = new ArrayList<Item>();
        this.date = date;
    }

    /**
     * Get the array list of items being purchased.
     * @return purchasedItems
     */
    public ArrayList<Item> getPurchasedItems() {
        return purchasedItems;
    }
    
    /**
     * Add an item to the ArrayList or purchased items.
     * @param item - Item to add.
     */
    public void addItem(Item item){
        purchasedItems.add(item);
    }
    
    public Item getItem(int itemNumber){
        for (Item i:purchasedItems){
            if (i.getItemNumber() == itemNumber){
                return i;
            }
        }
        return null;
    }
    /**
     * Removes a given item from the purchased items
     * @param item  - Item to remove.
     */
    public void removeItem(Item item){
        purchasedItems.remove(item);
    }
    
    /**
     * Get the total cost of the purchased items
     * @return Total price.
     */
    public double getTotal(){
        double total = 0;
        
        for (Item i:purchasedItems){
            total += i.getPrice();
        }
        return total;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Make a good string to return the entire list
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder strList = new StringBuilder();
        
        for (Item i:purchasedItems){
            strList.append(i.toString());
        }
        return strList.toString();
    }
}
