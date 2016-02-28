package Assignment3;

import java.util.LinkedList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 27, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 * Iterates over a specified item type (appetizer, main dish, or dessert)
 */
public class ItemIterator  implements MenuIterator{
    private int current;
    private LinkedList itterList;
    private int itemType;

    public ItemIterator(LinkedList list, int itemType) {
        this.current = 0;
        this.itterList = list;
        this.itemType = itemType;
        //System.out.println(itemType);
    }

    @Override
    public void next() {
        while (hasNext()){
            MenuItem temp = (MenuItem) itterList.get(current);
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
                MenuItem temp = (MenuItem) itterList.get(current);
                //System.out.println("hasnext: "+temp.getCatagory()+ " "+current);
                if (temp.getCatagory() == itemType){
                    //System.out.println(current);
                    return (itterList.get(current) !=null);
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
        return itterList.get(current);
    }
}

