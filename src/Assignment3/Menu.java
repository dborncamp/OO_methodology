package Assignment3;

import java.util.LinkedList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 6, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 * 
 *
 *
 */
public class Menu  {
    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;
    
    LinkedList menuList = new LinkedList();

    public void add(MenuItem m){
        menuList.add(m);
    }
    
    public void add(String itemName, int catagory, boolean heartHealthy, double price){
        menuList.add(new MenuItem(itemName, catagory,heartHealthy,price));
    }
    
    public void delete(MenuIterator itt){
        
    }
    
    public MenuIterator getAllItemsIterator(){
        return new AllItemIterator(menuList);
    }
    public MenuIterator getItemIterator(int catagory){
        return new ItemIterator(menuList, catagory);
    }
}
