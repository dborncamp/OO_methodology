package Assignment5;

import java.util.Date;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 4, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class HolidayGreeting  implements AddOn, Greeting {
    @Override
    public String getLines(PurchasedItems items) {
        if (applies(items)){
            return "* Happy Holidays from Best Buy *";
        }
        return "";
    }

    @Override
    public boolean applies(PurchasedItems items) {
         return items.getDate().after(new Date(2016, 12, 0)) && items.getDate().before(new Date(2016,12,30));
    }

}
