package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 23, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Orders {
    private ArrayList<OrderItems> OrderArray;  // the list of things on the tab
    private static int orderId = 0;  // Auto increments when default constructor called.

    public Orders() {
        Orders.orderId++;
    }
    
    /**
     * Copy Constructor.
     * @param oldOrders
     */
    public Orders(Orders oldOrders){
        setOrders(oldOrders.getAllOrders());
    }
    
    /**
     * Add a menuItem to the orders.
     * @param item - MenuItem ordered.
     */
    public void addItem(MenuItems item){
        OrderArray.add(new OrderItems(item));
    }
    
    /**
     * Add a menuItem to the orders.
     * @param item - MenuItem ordered.
     */
    public void addItem(OrderItems item){
        OrderArray.add(item);
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
        OrderArray.add(new OrderItems(new MenuItems(name, descrip, price, ingredients)));
    }    
    
    /**
     * A way to get all of the order items.
     * 
     * @return - Array list of order Items(OrderArray)
     */
    public ArrayList getAllOrders(){
        return OrderArray;
    }
    
    // Should only be called by copy constructor
    private void setOrders(ArrayList tab){
        for (OrderItems i:OrderArray){
            try{
                addItem(i);
            } catch(Exception e){
                System.out.println("Somehow encountered a non-menu item in Tabs...");
                e.printStackTrace();
            }
        }
    }
}
