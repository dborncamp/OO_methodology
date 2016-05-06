package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 16, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class CMDGetStock  implements Command{
    MenuAggrigator menuAgg;
    ArrayList<IngredientItems> ingredients;

    public CMDGetStock(MenuAggrigator menuAgg) {
        this.menuAgg = menuAgg;
        this.ingredients = new ArrayList<IngredientItems>();
    }
    
    /**
     * Go over the inventory. goes over all of the ingredient items.
     * @return
     */
    @Override
    public ArrayList<IngredientItems> execute() {
       for (MenuItems item:menuAgg.getMenu().getAllItems()){
           ingredients.addAll(item.getIngItem());
        }
       return ingredients;
    }

}
