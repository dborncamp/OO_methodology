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
public class MenuItems {
    private final String name;
    private final String descrip;
    private final double price;
    private final ArrayList<IngredientItems>  ingItem;

    /**
     * Create a menu item.
     *
     * @param name - Name of item.
     * @param descrip - Description of Item.
     * @param price - Price of item
     * @param ingredients - ingredients that make up the menu item
     */
    public MenuItems(String name, String descrip, double price, ArrayList ingredients) {
        this.name = name;
        this.descrip = descrip;
        this.price = price;
        this.ingItem = ingredients;
    }

    /**
     * Get the name of the item
     * @return - Name of Item
     */
    public String getName() {
        return name;
    }

    /**
     *Get the description of the item.
     * @return - Description ofItem
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     *Get the price of the item.
     * @return - Price ofItem
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get a list of the ingredients
     * @return - arrayList of the ingredients that make up the Menu Item
     */
    public ArrayList<IngredientItems> getIngItem() {
        return ingItem;
    }
    
    
}
