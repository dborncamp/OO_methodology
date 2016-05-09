package FinalAssignment;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date May 8, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class CMDMakeOrder implements Command{
    MenuAggrigator menuAgg;
    MenuItems item;

    public CMDMakeOrder(MenuAggrigator menuAgg, MenuItems item) {
        this.menuAgg = menuAgg;
        this.item = item;
    }
    
    @Override
    public Object execute() {
        try{
            menuAgg.addOrder(item);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
