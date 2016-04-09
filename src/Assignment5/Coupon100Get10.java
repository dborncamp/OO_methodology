package Assignment5;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 9, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class Coupon100Get10 implements AddOn, Applies, Coupon{

    @Override
    public String getLines(PurchasedItems items) {
        if(applies(items)){
            return "Come back to Besy Buy and get 10% off with this coupon!\n Coupon Number 100g10\n\n";
        }
        return "";
    }

    @Override
    public boolean applies(PurchasedItems items) {
        return items.getTotal() > 100;
    }

}
