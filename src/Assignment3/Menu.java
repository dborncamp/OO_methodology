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
        return new ItemIterator( catagory);
    }
    
    public MenuIterator getHeartHealthy(){
        return new HeartHealthyIterator();
    }
    
    public MenuIterator getPriceIterator(double price){
        return new PriceIterator(price);
    }    
    
    /**
     * @author Dave Borncamp <dbornc1@students.towson.edu>
     * @date Feb 27, 2016
     * 
     * Created for COSC 716 Spring 2016 at Towson University.
     *
     *  menu iterator that iterates over all of the menu items would have the following function signature
     */
    public class AllItemIterator implements MenuIterator{
        private int current;

        public AllItemIterator(LinkedList list) {
            this.current = 0;
        }

        @Override
        public void next() {
            current +=1;
        }

        @Override
        public boolean hasNext() {
            // This works but is certainly not the correct way to do things...
            try{
                return (menuList.get(current) !=null);
            } catch (IndexOutOfBoundsException e){
                return false;
            }
        }

        @Override
        public Object getItem() {
            return menuList.get(current);
        }
    }
    
    
    
    /**
     * @author Dave Borncamp <dbornc1@students.towson.edu>
     * @date Feb 27, 2016
     * 
     * Created for COSC 716 Spring 2016 at Towson University.
     *
     * Iterates over a specified item type (appetizer, main dish, or dessert)
     */
    public class ItemIterator  implements MenuIterator{
        private int current;
        private int itemType;

        public ItemIterator( int itemType) {
            this.current = 0;
            this.itemType = itemType;
            //System.out.println(itemType);
        }

        @Override
        public void next() {
            while (hasNext()){
                MenuItem temp = (MenuItem) menuList.get(current);
                if (temp.getCatagory() == itemType){
                    current +=1;
                    break;
                } 
            }
        }

        @Override
        public boolean hasNext() {
            // This works but is certainly not the correct way to do things...
            try{
                while(true){
                    MenuItem temp = (MenuItem) menuList.get(current);
                    //System.out.println("hasnext: "+temp.getCatagory()+ " "+current);
                    if (temp.getCatagory() == itemType){
                        //System.out.println(current);
                        return (menuList.get(current) !=null);
                    } else{
                        current +=1;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }

        @Override
        public Object getItem() {
            return menuList.get(current);
        }
    }
    
    
  
    /**
     * @author Dave Borncamp <dbornc1@students.towson.edu>
     * @date Mar 5, 2016
     * 
     * Created for COSC 716 Spring 2016 at Towson University.
     *
     * Iterates over a Heart Healthy Menu Items
     */
    public class HeartHealthyIterator  implements MenuIterator{
        private int current;

        public HeartHealthyIterator( ) {
            this.current = 0;
            //System.out.println(itemType);
        }

        @Override
        public void next() {
            while (hasNext()){
                MenuItem temp = (MenuItem) menuList.get(current);
                if (temp.isHeartHealthy() == true){
                    current +=1;
                    break;
                } 
            }
        }

        @Override
        public boolean hasNext() {
            // This works but is certainly not the correct way to do things...
            try{
                while(true){
                    MenuItem temp = (MenuItem) menuList.get(current);
                    //System.out.println("hasnext: "+temp.getCatagory()+ " "+current);
                    if (temp.isHeartHealthy() == true){
                        //System.out.println(current);
                        return (menuList.get(current) !=null);
                    } else{
                        current +=1;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }

        @Override
        public Object getItem() {
            return menuList.get(current);
        }
    }
    
    
     /**
     * @author Dave Borncamp <dbornc1@students.towson.edu>
     * @date Mar 5, 2016
     * 
     * Created for COSC 716 Spring 2016 at Towson University.
     *
     * Iterates over the main dishes that cost over a certain amount..
     */
    public class PriceIterator  implements MenuIterator{
        private int current;
        private double price;

        public PriceIterator(double price) {
            this.current = 0;
            this.price = price;
            //System.out.println(itemType);
        }

        @Override
        public void next() {
            while (hasNext()){
                MenuItem temp = (MenuItem) menuList.get(current);
                if (temp.getPrice() > price && temp.getCatagory() == Menu.MAIN_DISH){
                    current +=1;
                    break;
                } 
            }
        }

        @Override
        public boolean hasNext() {
            // This works but is certainly not the correct way to do things...
            try{
                while(true){
                    MenuItem temp = (MenuItem) menuList.get(current);
                    if (temp.getPrice() > price && temp.getCatagory() == Menu.MAIN_DISH){
                        //System.out.println(current);
                        return (menuList.get(current) !=null);
                    } else{
                        current +=1;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }

        @Override
        public Object getItem() {
            return menuList.get(current);
        }
    }
    
    
}
