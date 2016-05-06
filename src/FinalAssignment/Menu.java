package FinalAssignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    private final String menuFile = "C:\\Users\\Dave\\Documents\\Class\\COSC716OOmethodology\\Assignment1\\src\\FinalAssignment\\basicMenu.txt";
    
    /**
     * Default constructor creates an empty menu.
     */
    public Menu(){
        this.menuArray = new ArrayList<MenuItems>();
        String line = null;
        try{
            FileReader fileReader = new FileReader(menuFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] comp = line.split(",");
                
                // Build the ingredients
                ArrayList<String> ingNames = new ArrayList<>(Arrays.asList(comp[3].split("/")));
                ArrayList<IngredientItems> ingList = new ArrayList<>();
                        
                for (String name: ingNames){
                    IngredientItems ing = new IngredientItems(name);
                    //System.out.println(ing);
                    ingList.add(ing);
                }

                double price = Double.parseDouble(comp[2]);
                // Make the menu itmes
                initItem(comp[0], comp[1], price, ingList);
                
                // Initialize stock 12 for each thing in the menu.
                initStock();
            }

            // Always close files.
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                menuFile + "'");
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + menuFile + "'"); 
        }
        
//        System.out.println("Menu successfully made!!!");
//        System.out.println(menuArray.isEmpty());
//        System.out.println(menuArray.get(1));
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
    
    private void initItem(String name, String descrip, double price,ArrayList ingredients){
//        System.out.println(name + " " +descrip+" "+price+" "+ingredients.toString());
        MenuItems item = new MenuItems(name, descrip, price,ingredients);
//        System.out.println("Item: " + item+"\n\n");
//        System.out.println(item.getDescrip());
        //addItem(item);
        this.menuArray.add(item);
    }
    
    /**
     * Add 12 stock for every inventory item.
     */
    private void initStock(){
        for (MenuItems i:menuArray){
            for(IngredientItems ing:i.getIngItem()){
                for(int j=0; j==11; j++){
                    ing.addStock();
                }
            }
        }
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
