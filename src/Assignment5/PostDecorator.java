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
class PostDecorator extends Decorator {
    private AddOn a;
    private PurchasedItems items;
    
    public PostDecorator(AddOn a, Receipt r, PurchasedItems items) {
        super(r);
        
        this.a = a;
        this.items = items;
    }

    @Override
    public void prtReceipt() {
        // Do the printing
        System.out.println(a.getLines(items));
        // Call the trailer to finish the receipt
        super.callTrailer();
    }

}
