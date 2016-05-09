package FinalAssignment;

import FinalAssignment.IngredientItems.ZeroStockException;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 12, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 * Just for access to the data. Command objects should manipulate the data
 */
public class MenuAggrigator {
    Menu menu;
    Orders order;

    /**
     *Creates an aggrigator with no data in it. empty menus and orders.
     */
    public MenuAggrigator() {
        this.menu = new Menu();
        this.order = new Orders();
    }
    
    /**
     * Create an Aggrigator to serve data.
     * 
     * @param menu - Menu to use
     * @param order - Orders to use
     */
    public MenuAggrigator(Menu menu, Orders order) {
        this.menu = menu;
        this.order = order;
    }
    
    /**
     * Get a copy of the menu from the Aggrigator.
     * @return - copy of the Menu
     */
    public Menu getMenu(){
        return new Menu(menu);
    }
    
    /**
     * Add an item to the aggrigator's copy of the menu
     * @param item - item to add
     */
    public void addMenu(MenuItems item){
        menu.addItem(item);
    }
    
    /**
     * Get a copy of the orders.
     * @return - copy of the orders
     */
    public Orders getOrders(){
        return new Orders(order);
    }
    
    /**
     * Add an order to the order list
     * @param item
     * @throws IngredientItems.ZeroStockException - If there are no ingredients left in stock to make the item.
     */
    public void addOrder(MenuItems item) throws ZeroStockException{
        order.addItem(item);
    }
}
