package Assignment3;

import java.util.LinkedList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 27, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *  menu iterator that iterates over all of the menu items would have the following function signature
 */
public class AllItemIterator implements MenuIterator{
    private int current;
    private LinkedList itterList;

    public AllItemIterator(LinkedList list) {
        this.current = 0;
        this.itterList = list;
    }

    @Override
    public void next() {
        current +=1;
    }

    @Override
    public boolean hasNext() {
        // This works but is certainly not the correct way to do things...
        try{
            return (itterList.get(current) !=null);
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public Object getItem() {
        return itterList.get(current);
    }

}
