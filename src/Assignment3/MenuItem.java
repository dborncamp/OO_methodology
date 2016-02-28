package Assignment3;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 27, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public class MenuItem {
    private String itemName;
    private int catagory;
    private boolean heartHealthy;
    private double price;
    
    public MenuItem(String itemName, int catagory, boolean heartHealthy, double price) {
        this.itemName = itemName;
        this.catagory = catagory;
        this.heartHealthy = heartHealthy;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getCatagory() {
        return catagory;
    }

    public boolean isHeartHealthy() {
        return heartHealthy;
    }

    public double getPrice() {
        return price;
    }

}
