package Assignment5;

import java.util.Date;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 8, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
class CATaxComputation extends TaxComputation {

    public CATaxComputation() {
    }

    @Override
    public double computeTax(PurchasedItems items, Date date) {
        double totalTax = items.getTotal() * 0.075;
        return totalTax;
    }

    @Override
    protected boolean taxHoliday(Date date) {
        return false;  //Nothing we sell applies for tax holidays.
    }

}
