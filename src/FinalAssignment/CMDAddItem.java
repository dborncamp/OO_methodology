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
public class CMDAddItem  implements Command{
    MenuAggrigator menuAgg;
    MenuItems item;

    public CMDAddItem(MenuAggrigator menuAgg, MenuItems item) {
        this.menuAgg = menuAgg;
        this.item = item;
    }
    

    @Override
    public Object execute() {
        menuAgg.addMenu(item);
        return true;
    }

}
