package FinalAssignment;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 23, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class OrderItems {
    private final MenuItems orderedItem;
    
    public OrderItems(MenuItems item){
        this.orderedItem = item;
    }

    /**
     * Get the menuItems that were ordered
     * @return
     */
    public MenuItems getOrderedItem() {
        return orderedItem;
    }
    
}
