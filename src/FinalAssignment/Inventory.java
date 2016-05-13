package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date May 10, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Inventory {
    private ArrayList<IngredientItems> ingArray;

    public Inventory(){
        this.ingArray = new  ArrayList<IngredientItems>();
    }
    
    public Inventory(Inventory oldInventory){
        this.ingArray = oldInventory.ingArray;
    }
    
    public void addInventory(IngredientItems ingredient){
        try{
            int idx = ingArray.indexOf(ingredient);
            if (idx != -1){
                System.out.print(idx);
                IngredientItems tmping = ingArray.get(idx);
                 tmping.addStock(false);
                ingArray.set(idx,tmping);
            } else{
                ingArray.add(ingredient);
            }
        }catch(NullPointerException e){
            ingArray.add(ingredient);
        }
    }
    
    public void addInventory(ArrayList<IngredientItems> ingredient){
        System.out.println("AddInventory list");
        for (IngredientItems ing: ingredient){
            try{
                int idx = ingArray.indexOf(ing);
                IngredientItems tmping = ingArray.get(idx);
                 tmping.addStock(false);
                ingArray.set(idx,tmping);
            }catch(NullPointerException e){
                ingArray.add(ing);
            }
        }
    }
    
    public ArrayList<IngredientItems> getInventory(){
        return ingArray;
    }
    
    public IngredientItems getItem(String name){
        IngredientItems ingredient = null;
        for (IngredientItems item:ingArray){
            if ( name.equals(item.getName())){
                ingredient =  item;
            }
        }
        return ingredient;
        //return ingArray.get(ingArray.indexOf(item));
    }
}
