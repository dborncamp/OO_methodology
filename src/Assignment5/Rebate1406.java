package Assignment5;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 4, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Rebate1406 implements AddOn, Applies, Rebate {
    @Override
    public String getLines() {
        return "Mail-in Rebate for Item #1406\n" + "Name:\n” + “Address:\n\n" +
         "Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
    }
    @Override
    public boolean applies(PurchasedItems items) {
        // implemented to check if any of the items in purchased items
        // is item # 1406

    }
}
