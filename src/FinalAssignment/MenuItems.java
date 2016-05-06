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
public class MenuItems implements IngredientObserver {
    private final String name;
    private final String descrip;
    private double price;
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
        //System.out.println(name + " " +descrip+" "+price+" "+ingredients.toString());
        this.name = name;
        this.descrip = descrip;
        this.price = price;
        this.ingItem = ingredients;
        registerIngredients();
        //System.out.println(this.ingItem);
    }
    
    /**
     * Lower the price by 10% because we have many in stock
     */
    @Override
    public void updateMany(){
        this.price = this.price * 0.9;
    }

    /**
     * Raise the price by 10% because we have fewer stock
     */
    @Override
    public void updateFew(){
        this.price = this.price * 1.1;
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

    private void registerIngredients() {
        ingItem.forEach((IngredientItem)->{
            IngredientItem.register(this);
        });
    }
    
    @Override
    public String toString(){
        String outString = name+"        "+Double.toString(price) + "\n"+ descrip+"\n";
        
        return outString;
    }
}
