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
public class PreDecorator extends Decorator {
    private AddOn a;
    
    public PreDecorator(AddOn a, Receipt r) {
        super(r);
        this.a = a;
    }
    @Override
    public void prtReceipt() {
        System.out.println(a.getLines());
        callTrailer();
    }
}
