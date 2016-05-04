package FinalAssignment;

import java.util.ArrayList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 16, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
class IngredientItems implements IngredientSubject{
    private ArrayList<IngredientObserver> observers;
    private final String name;
    private static int stock = 0;  // keep track of stock of these.

    public IngredientItems(String name) {
        this.name = name;
        observers = new ArrayList<IngredientObserver>();
    }
    
    @Override
    public void register(IngredientObserver newObserver) {
        // Adds a new observer to the ArrayList
        observers.add(newObserver);

    }
    
    @Override
    public void unregister(IngredientObserver deleteObserver){
        observers.remove(deleteObserver);
    }
    
    private void notifyObserverMany() {
        // Cycle through all observers and notifies them of
        // price changes
        observers.stream().forEach((observer) -> {
            observer.updateMany();
        });
    }

  private void notifyObserverFew() {
        // Cycle through all observers and notifies them of
        // price changes
        observers.stream().forEach((observer) -> {
            observer.updateFew();
        });
    }
    public void addStock(){
        stock ++;
        // reduce price by 10% for each 10 we remove
        if (stock %10 == 0){
            notifyObserverMany();
        }
    }

    public void removeIngredient() throws ZeroStockException{
        if (stock > 0){
            stock --;
            // increase price by 10% for each 10 we remove
            if (stock % 10 == 0){
                notifyObserverFew();
            }
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
