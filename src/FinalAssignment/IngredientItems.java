package FinalAssignment;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 16, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
class IngredientItems {
    
    private final String name;
    private static int stock = 0;  // keep track of stock of these.

    public IngredientItems(String name) {
        this.name = name;
    }
    
    public void addStock(){
        stock ++;
    }

    public void removeIngredient() throws ZeroStockException{
        if (stock > 0){
            stock --;
        } else{
            throw new ZeroStockException(this.name);
        }
    }
    
    
    /**
     * Exception that is thrown when there is no more of a particular item.
     */
    private static class ZeroStockException extends Exception {
        public ZeroStockException(String name) {
            super("No More "+name+" available!");
        }
    }
}
