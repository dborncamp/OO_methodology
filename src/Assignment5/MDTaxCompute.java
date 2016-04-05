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
public class MDTaxCompute extends TaxComputation{

    @Override
    public double computeTax(PurchasedItems items, Date date) {
        // MD has 6% tax in this assignment.
        double totalTax = items.getTotal() * 0.06;
        return totalTax;
    }

    @Override
    protected boolean taxHoliday() {
        return false;  //Nothing we sell applies for tax holidays.
    }

}
