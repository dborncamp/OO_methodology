package FinalAssignment;

import FinalAssignment.IngredientItems.ZeroStockException;
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
 * Just for access to the data. Command objects should manipulate the data
 */
public class MenuAggrigator {
    Menu menu;
    Orders order;
    Inventory inventory;
    private final String menuFile = "C:\\Users\\Dave\\Documents\\Class\\COSC716OOmethodology\\Assignment1\\src\\FinalAssignment\\basicMenu.txt";
    private final String InventoryFile = "C:\\Users\\Dave\\Documents\\Class\\COSC716OOmethodology\\Assignment1\\src\\FinalAssignment\\basicInventory.txt";

    /**
     *Creates an aggrigator with no data in it. empty menus and orders.
     */
    public MenuAggrigator() {
        this.menu = new Menu();
        this.order = new Orders();
        this.inventory = new Inventory();
        String line = null;
        
        // Initialize stock
        initStock();
        // Initialize the menu
        initMenu();
    }
    
    
    /**
     * Add 10 stock for every inventory item.
     */
    private void initStock(){
        System.out.println("initStock");
        String line = null;
        try{
            FileReader fileReader = new FileReader(InventoryFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] comp = line.split(",");
                
                // Make the menu itmes
                inventory.addInventory(new IngredientItems(comp[0], Integer.parseInt(comp[1])));
            }

            // Always close files.
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to Find file '" + menuFile + "'");
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '"    + menuFile + "'"); 
        }
    }
    
    private void initMenu(){
        try{
            FileReader fileReader = new FileReader(menuFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while((line = bufferedReader.readLine()) != null) {
                String[] comp = line.split(",");
                
                // Build the ingredients
                ArrayList<String> ingNames = new ArrayList<>(Arrays.asList(comp[3].split("/")));
                ArrayList<IngredientItems> ingList = new ArrayList<>();
                        
                for (String name: ingNames){
                    //System.out.println(name);
                    IngredientItems ing = inventory.getItem(name);
                    if(ing == null){
                        System.out.println("Ingredient Not found: "+ing+" "+name);
                    }
                    //System.out.println(ing);
                    ingList.add(ing);
                }

                //System.out.println("IngList");
                //System.out.println(ingList);
                double price = Double.parseDouble(comp[2]);
                // Make the menu itmes
                menu.initItem(comp[0], comp[1], price, ingList);
            }

            // Always close files.
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to Find file '" + menuFile + "'");
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '"    + menuFile + "'"); 
        }
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
        for (MenuItems item: menu.getAllItems()){
            this.inventory.addInventory(item.getIngItem());
        }
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
    
    
    public void addIngredient(IngredientItems ingItem){
        inventory.addInventory(ingItem);
    }
    
        
    public void addIngredient(ArrayList<IngredientItems> ingredients){
        inventory.addInventory(ingredients);
    }
    
    public Inventory getInventory(){
        return new Inventory(inventory);
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
        //System.out.println("MenuAgg - menuitems");
        order.addItem(item);
    }
}
