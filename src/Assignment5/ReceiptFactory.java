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
 public class ReceiptFactory {
    private PurchasedItems items;
    private Date date;
    private AddOn[] addOns; // greeting, rebate and coupon add-ons
    
    public ReceiptFactory(PurchasedItems items, Date date) throws UnknownAddOnTypeException {
        this.items = items;
        this.date = date;

        Receipt receipt = new BasicReceipt(items, date);
        // links appropriate tax computation object
        //(to be completed)
        getAddOns(addOns); // call to private method
        
        for (AddOn a: addOns){
            if (a instanceof Greeting)  receipt = new PreDecorator(a, receipt);
            else  if (a instanceof Applies && a.applies(items))
                if (a instanceof Rebate || a instanceof Coupon)
                    receipt = new PostDecorator(a, receipt);
                else
                    throw new UnknownAddOnTypeException();
        }
    } // End constructor
    
    /**
     * Get the available addons.
     * @param addOns 
     */
    private void getAddOns(AddOn[] addOns){
        addOns = new AddOn[2];
        addOns[0] = new HolidayGreeting();
        addOns[1] = new Rebate1406();
//            addOns[2] = new Rebate3610();
//            addOns[3] = new Coupon100Get10Percent();
//            addOns[4] = new Coupon200Get25Percent();
    }

    /**
     * Custom exception for trying to add addons that don't exist.
     */
    private static class UnknownAddOnTypeException extends Exception {
        public UnknownAddOnTypeException() {
            super("Unknown AddOn. Try again.");
        }
    }
} //End class