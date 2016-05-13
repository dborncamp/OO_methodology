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
public class Menu {
    
    private ArrayList<MenuItems> menuArray;
    
    /**
     * Default constructor creates an empty menu.
     */
    public Menu(){
        this.menuArray = new ArrayList<MenuItems>();
    }
    
    /**
     * Copy Constructor for a menu
     * @param oldMenu - old menu to copy.
     */
    public Menu(Menu oldMenu){
        this.menuArray = new ArrayList<MenuItems>();
        setItems(oldMenu.getAllItems());
    }
    
    /**
     * Add an item to the ArrayList or menuArray items.
     * @param item - Item to add.
     */
    public void addItem(MenuItems item){
        this.menuArray.add(item);
    }
    
    /**
     * Add an item to the ArrayList or menuArray items but builds the MenuItem in place.
     * 
     * @param name - Name of item.
     * @param descrip - Description of Item.
     * @param price - Price of item
     */
    public void addItem(String name, String descrip, double price,ArrayList ingredients){
        menuArray.add(new MenuItems(name, descrip, price,ingredients));
    }
    
    public void initItem(String name, String descrip, double price,ArrayList ingredients){
//        System.out.println(name + " " +descrip+" "+price+" "+ingredients.toString());
        MenuItems item = new MenuItems(name, descrip, price, ingredients);
//        System.out.println("Item: " + item+"\n\n");
//        System.out.println(item.getDescrip());
        //addItem(item);
        this.menuArray.add(item);
    }

    
    /**
     * Removes a given item from the menuArray items
     * @param item  - Item to remove.
     */
    public void removeItem(MenuItems item){
        menuArray.remove(item);
    }
    
    /**
     * Get the menuArray that holds all of the menu items
     * @return - menuArray
     */
    public  ArrayList<MenuItems> getAllItems(){
        return menuArray;
    }
    
    // Should only be called by copy constructor
    private void setItems(ArrayList<MenuItems> items){
        for (MenuItems i:items){
            try{
                addItem(i);
            } catch(Exception e){
                System.out.println("Somehow encountered a non-menu item in Menu...");
                e.printStackTrace();
            }
        }
    }

}
