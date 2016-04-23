package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 12, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Tabs {
    private ArrayList<MenuItems> tabArray;  // the list of things on the tab
    private static int tabId = 0;  // Auto increments when default constructor called.
    
    public Tabs(){
        Tabs.tabId ++;
    }
    
    /**
     * Copy Constructor for a menu
     * @param oldTab - old menu to copy.
     * 
     *  The tabId will not be incremented when this is called.
     */
    public Tabs(Tabs oldTab){
        settabs(oldTab.getAlltabs());
    }
    
    /**
     * Constructor for making a tab out of orders.
     * @param orders - Orders that will make up the  tab.
     */
    public Tabs(Orders orders){
        settabs(orders.getAllOrders());
    }
    
       /**
     * Add an item to the ArrayList or tabArray items.
     * @param item - Item to add.
     */
    public void addItem(MenuItems item){
        tabArray.add(item);
    }
    
    /**
     * Add an item to the ArrayList or tabArray items but builds the MenuItem in place.
     * 
     * @param name - Name of item.
     * @param descrip - Description of Item.
     * @param price - Price of item
     * @param ingredients - Ingredients for MenuItem
     */
    public void addItem(String name, String descrip, double price, ArrayList ingredients){
        tabArray.add(new MenuItems(name, descrip, price, ingredients));
    }
    
        /**
     * Removes a given item from the tabArray items
     * @param item  - Item to remove.
     */
    public void removeItem(MenuItems item){
        tabArray.remove(item);
    }
    
    public int getTabId(){
        return this.tabId;
    }
    /**
     * Get the total price of the items in the tab.
     * @return - Total price of items in tabArray.
     */
    public double getTotal(){
        double sum = 0.0;
        for (MenuItems i:tabArray){
            sum += i.getPrice();
        }
        
        return sum;
    }
    
    // Should only be called by copy constructor
    private ArrayList getAlltabs(){
        return tabArray;
    }
    
    // Should only be called by copy constructor
    private void settabs(ArrayList tab){
        for (MenuItems i:tabArray){
            try{
                addItem(i);
            } catch(Exception e){
                System.out.println("Somehow encountered a non-menu item in Tabs...");
                e.printStackTrace();
            }
        }
    }
}
