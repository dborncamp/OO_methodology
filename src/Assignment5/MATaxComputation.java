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
class MATaxComputation extends TaxComputation {

    @Override
    public double computeTax(PurchasedItems items, Date date) {
        if (!taxHoliday(date)){
            double totalTax = items.getTotal() * 0.0625;
            return totalTax;
        } 
        return 0.0;
    }

    @Override
    protected boolean taxHoliday(Date date) {
        Date holidayDate1 = new Date(2016, 8, 16);
        Date holidayDate2 = new Date(2016, 8, 17);
        
        return date.after(holidayDate1) && date.before(holidayDate2);  
    }

}
