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
public abstract class TaxComputation {
    public abstract double computeTax(PurchasedItems items, Date date);
    protected abstract boolean taxHoliday();
}
