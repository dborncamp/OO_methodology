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
public class SystemInterface {
    
    private Invoker invoker = new Invoker();
    
    public String getMenu(){
        // should be implemented here  not in the tostring of menu...
        Menu menu = invoker.getMenu();
        
        StringBuilder sb=new StringBuilder();  
        ArrayList<MenuItems> menuArray = menu.getAllItems();
        
        // Add a greeting at the top
        sb.append("Dave's Restraunt\n");
        sb.append("Menu\n");
        
        // Put the items on the string menu
        for (MenuItems i:menuArray){
            sb.append(i.toString()+"\n");
        }
        
        return sb.toString();
    }
    
    public void makeOrder(){
        
    }

    public String getStock(){
         ArrayList<IngredientItems> items = invoker.getStock();
         StringBuilder sb=new StringBuilder();
         
         for(IngredientItems item: items){
             sb.append(item.toString()+"\n");
         }
         
         return sb.toString();
    }
}
