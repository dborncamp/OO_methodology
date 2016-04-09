/*
 * Copyright (c) 2016, Dave Borncamp <dbornc1@students.towson.edu>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package Assignment5;

import java.util.Date;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Apr 8, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 * 
 * This file was origionally named Client.java.
 *
 *
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Set up some items
        Item  item1 = new Item("Item1",5,4.5);
        Item  item2 = new Item("Item2",14,40.0);
        Item  item3 = new Item("item3",1406, 12.75);
        Item  item4 = new Item("item4",3610, 120.00);
        Item  item5 = new Item("item5",1, 75.00);
        
        //Set up some dates
        Date taxTest = new Date(2016, 8, 16);
        Date today = new Date(2016,4,9);
        Date holidayTest = new Date(2016,12,16);
        
        //Test the tax holiday and mail-in rebate
        PurchasedItems taxPurchase = new PurchasedItems(taxTest);
        taxPurchase.addItem(item1);
        taxPurchase.addItem(item2);
        taxPurchase.addItem(item3);
        
        //Test the holiday greeting and mail-in rebate
        PurchasedItems holidayPurchase = new PurchasedItems(holidayTest);
        holidayPurchase.addItem(item1);
        holidayPurchase.addItem(item2);
        holidayPurchase.addItem(item3);
        
           //Test the holiday greeting and mail-in rebate
        PurchasedItems couponPurchase = new PurchasedItems(today);
        couponPurchase.addItem(item1);
        couponPurchase.addItem(item2);
        couponPurchase.addItem(item3);
        couponPurchase.addItem(item4);
        couponPurchase.addItem(item5);
        
        try{
            System.out.println("Receipt 1\n");
            ReceiptFactory factory = new ReceiptFactory(taxPurchase);
            Receipt receipt = factory.getReceipt();
            receipt.prtReceipt();
            
            System.out.println("********************************************************************\n");
            System.out.println("Receipt 2 (same as 1 except new date for holiday greeting):\n");
            ReceiptFactory hfactory = new ReceiptFactory(holidayPurchase);
            Receipt hreceipt = hfactory.getReceipt();
            hreceipt.prtReceipt();
            
            System.out.println("********************************************************************\n");
            System.out.println("Receipt 3 (Test Coupons and multiple rebates):\n");
            ReceiptFactory cfactory = new ReceiptFactory(couponPurchase);
            Receipt creceipt = cfactory.getReceipt();
            creceipt.prtReceipt();            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
    }

}
