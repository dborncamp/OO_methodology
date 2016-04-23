package FinalAssignment;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 16, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class CMDGetTabs implements Command{
    MenuAggrigator menuAgg;

    public CMDGetTabs(MenuAggrigator menuAgg) {
        this.menuAgg = menuAgg;
    }
    

    @Override
    public Tabs execute() {
        return new Tabs(menuAgg.getOrders());
    }

}
