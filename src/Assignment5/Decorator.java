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
public abstract class Decorator implements Receipt {
    private Receipt trailer;
    
    public Decorator(Receipt r) {
        trailer = r;
    }
    protected void callTrailer() {
        trailer.prtReceipt();
    }
    public abstract void prtReceipt();
}
