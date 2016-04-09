package Assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 4, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
 public class ReceiptFactory {
    private PurchasedItems items;
    private Date date;
    private AddOn[] addOns; // greeting, rebate and coupon add-ons
    private String stateCode;
    private String storeInfo;
    private final String cfgFile ="C:\\Users\\Dave\\Documents\\Class\\COSC716OOmethodology\\Assignment1\\src\\Assignment5\\storeCfg.dat";
    Receipt receipt;
    
    public ReceiptFactory(PurchasedItems gitems) throws UnknownAddOnTypeException {
        this.items = gitems;
        this.date = gitems.getDate();

        //Read in the cfg file
        readCfg();
        // Make the receipt
        receipt = new BasicReceipt(items, date, storeInfo);

        // Figure out the taxes.
       switch(stateCode){
            case "MD":
                ((BasicReceipt)receipt).setTaxComputation(new MDTaxCompute());
            case "DE":
                ((BasicReceipt)receipt).setTaxComputation(null);
            case "CA":
                ((BasicReceipt)receipt).setTaxComputation(new CATaxComputation());
            case "MA":
                ((BasicReceipt)receipt).setTaxComputation(new MATaxComputation());
        }
        
        getAddOns(); // call to private method

        for (AddOn a: addOns){
            if (a instanceof Greeting)  receipt = new PreDecorator(a, receipt, items);
            else  if (a instanceof Applies && a.applies(items))
                if (a instanceof Rebate || a instanceof Coupon)
                    receipt = new PostDecorator(a, receipt, items);
                else
                    throw new UnknownAddOnTypeException();
        }
    } // End constructor
    
    public Receipt getReceipt(){
        return receipt;
    }
    
    /**
     *  Read in the cfg.dat file.
     */
    private void readCfg(){
        try{
            Scanner scan = new Scanner(new File(cfgFile));
            String storeID = scan.nextLine();
            String address = scan.nextLine();
            String phoneNumber = scan.nextLine();
            this.stateCode = scan.nextLine();
            this.storeInfo = "Store #"+storeID+"\n"+address+"\n"+phoneNumber;
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Get the available addOns.
     */
    private void getAddOns(){
        addOns = new AddOn[4];
        addOns[0] = new HolidayGreeting();
        addOns[1] = new Rebate1406();
        addOns[2] = new Rebate3610();
        addOns[3] = new Coupon100Get10();
//            addOns[4] = new Coupon200Get25Percent();
    }

    /**
     * Custom exception for trying to add addOns that don't exist.
     */
    private static class UnknownAddOnTypeException extends Exception {
        public UnknownAddOnTypeException() {
            super("Unknown AddOn. Try again.");
        }
    }
} //End class