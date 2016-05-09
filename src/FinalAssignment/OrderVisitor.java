package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date May 8, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class OrderVisitor implements Visitor{

    /**
     * Visits all orders and returns the total of all orders to 
     * @param order
     * @return
     */
    @Override
    public String visit(Orders order) {
        ArrayList<OrderItems> orderList = order.getAllOrders();
        double total = 0;
        String tmp = null;
        StringBuilder sb=new StringBuilder();
        
        for (OrderItems i: orderList){
            total += i.getOrderedItem().getPrice();
            tmp =  i.accept(this) + "\n";
            sb.append(tmp);
        }
        sb.append("\n" + Double.toString(total));
        
        return sb.toString();
    }

}
