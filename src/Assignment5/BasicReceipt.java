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
public class BasicReceipt implements Receipt{
    private String storeInfo; // store number, store address, phone number
    private String stateCode; // MD, DE, CA or MA
    private PurchasedItems items;
    private Date date;
    private TaxComputation tc;
    
    public BasicReceipt(PurchasedItems items, Date date) {
        this.items = items;
        this.date = date;
    }
    public void setTaxComputation(TaxComputation tc) {
        this.tc = tc;
    }
    public void prtReceipt() {
    // to implement
    }
}
