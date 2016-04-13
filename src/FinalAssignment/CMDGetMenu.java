package FinalAssignment;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 12, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class CMDGetMenu implements Command{
    MenuAggrigator menuAgg;

    public CMDGetMenu(MenuAggrigator menuAgg) {
        this.menuAgg = menuAgg;
    }
    
    
    @Override
    public Menu execute() {
        return menuAgg.getMenu();
    }

}
