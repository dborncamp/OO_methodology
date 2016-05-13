package FinalAssignment;

import FinalAssignment.IngredientItems.ZeroStockException;
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
        this.OrderArray = new  ArrayList<OrderItems>();
        Orders.orderId++;
    }
    
    /**
     * Copy Constructor.
     * @param oldOrders
     */
    public Orders(Orders oldOrders){
        //System.out.println("All orders: "+oldOrders.getAllOrders());
        this.OrderArray = new  ArrayList<OrderItems>();
        setOrders(oldOrders.getAllOrders());
    }
    
    /**
     * Add a menuItem to the orders.
     * @param item - MenuItem ordered.
     * @throws FinalAssignment.IngredientItems.ZeroStockException
     */
    public void addItem(MenuItems item) throws ZeroStockException{
        System.out.println("Orders.AddItem - menuitems");
        OrderItems orderedItem = new OrderItems(item);
        System.out.println("OrderItem made");
        OrderArray.add(orderedItem);
        ArrayList<IngredientItems> ing =  item.getIngItem();
        
        // Remove ingredients when they are ordered
        for(IngredientItems ingredient: ing){
            ingredient.removeIngredient();
        }
    }
    
    /**
     * Add a menuItem to the orders.
     * @param item - OrderItems ordered.
     */
    public void addItem(OrderItems item){
        System.out.println("Orders");
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
        System.out.println("Adding to Order");
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
    private void setOrders(ArrayList<OrderItems> tab){
        for (OrderItems i:tab){
            try{
                addItem(i);
            } catch(Exception e){
                System.out.println("Somehow encountered a non-menu item in Tabs...");
                e.printStackTrace();
            }
        }
    }
}
