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
public class OrderItems implements Visitable {
    private final MenuItems orderedItem;
    
    public OrderItems(MenuItems item){
        System.out.println("OrderItems - menuItems");
        this.orderedItem = item;
    }

    /**
     * Get the menuItems that were ordered
     * @return
     */
    public MenuItems getOrderedItem() {
        return orderedItem;
    }

    @Override
    public String accept(Visitor visit) {
        MenuItems item = getOrderedItem();
        return item.getName() + ": " + Double.toString(item.getPrice());
    }
    
    @Override
    public String toString(){
        return orderedItem.toString();
    }
}
