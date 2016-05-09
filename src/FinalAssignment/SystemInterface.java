package FinalAssignment;

import FinalAssignment.IngredientItems.ZeroStockException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    
    private Invoker invoker;
    
    public SystemInterface(){
        invoker = new Invoker();
    }
    
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
    
    private int getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public void makeOrder(){
        Menu menu = invoker.getMenu();

        try{
            System.out.println("Please enter the number you would like to order: ");
            int num = getInput();
            MenuItems item = menu.getAllItems().get(num);
            System.out.println(item);
            invoker.makeOrder(item);
        } catch (InputMismatchException notNum){
            System.out.println("Try Again.");
            makeOrder();
        } catch (ZeroStockException ex) {
            System.out.println("Out of an Ingredient");
            makeOrder();
        }catch (Exception e){
                e.printStackTrace();
        }

    }

    public String getStock(){
         ArrayList<IngredientItems> items = invoker.getStock();
         StringBuilder sb=new StringBuilder();
         sb.append("Stock of Ingredient Items\n");
         
         for(IngredientItems item: items){
             String str = item.toString()+ "  "+ item.getStock()+"\n";
             try{
                //System.out.println(str);
                int tmp = sb.indexOf(str);
                //System.out.println("   tmp = " + tmp);
                sb.append(str);
                 
             } catch(NullPointerException e){
                sb.append(str);
             }
         }
         
         return sb.toString();
    }
    
    public String getTab(){
        Orders order = invoker.getTab();
        OrderVisitor ov = new OrderVisitor();
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nYour Tab is: \n");
        
        sb.append(ov.visit(order));
        
        return sb.toString();
    }
    
}
