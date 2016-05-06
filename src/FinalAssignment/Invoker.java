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
public class Invoker {
    MenuAggrigator menuAgg;
    
    public Invoker(){
        menuAgg = new MenuAggrigator();
    }

    public Menu getMenu(){
       CMDGetMenu menuCMD = new CMDGetMenu(menuAgg);
       return menuCMD.execute();
    }
    
    public Tabs getTabs(){
        CMDGetTabs tabsCMD = new CMDGetTabs(menuAgg);
        return tabsCMD.execute();
    }
    
    public ArrayList<IngredientItems> getStock(){
        CMDGetStock stockCMD = new CMDGetStock(menuAgg);
        return stockCMD.execute();
    }
}
