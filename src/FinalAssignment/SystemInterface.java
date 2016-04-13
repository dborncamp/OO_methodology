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
public class SystemInterface {
    private static Invoker invoker;
    //Should only have static menthods 
    public static String getMenu(){
        String menu;
        // should be implemented here  not in the tostring of menu...
        menu = invoker.getMenu().toString();
        
        return menu;
    }

}
