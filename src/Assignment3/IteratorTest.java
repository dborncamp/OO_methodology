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
public class IteratorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu eatAtJoesMenu = new Menu();
        eatAtJoesMenu.add("Apetizer1", 1, false, 2.99 );
        eatAtJoesMenu.add("Apetizer2", 1, false, 4.99 );
        eatAtJoesMenu.add("Lobster Dinner", 2, false, 24.99 ); // 1 for “main dish” category
        eatAtJoesMenu.add("Main2", 2, true, 44.99 );
        eatAtJoesMenu.add("Main3", 2, true, 12.99 );
        eatAtJoesMenu.add("Desert1", 3, false, 14.99 );
        eatAtJoesMenu.add("Desert2", 3, false, 2.99 );
       
        MenuIterator allDish = eatAtJoesMenu.getAllItemsIterator();
        
        System.out.println("ALL MENU ITEMS");
        while (allDish.hasNext()){
            MenuItem item = (MenuItem) allDish.getItem();
            System.out.println(item.getItemName() + " $" + item.getPrice());
            allDish.next();
        }
        System.out.println();
        
        // Test the itemiterator
        MenuIterator mainDish = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
        //System.out.println(eatAtJoesMenu.menuList.get(0).getItemName());
        System.out.println("MAIN DISHES");
        while (mainDish.hasNext()){
            MenuItem item = (MenuItem) mainDish.getItem();
            System.out.println(item.getItemName() + " $" + item.getPrice());
            mainDish.next();
        }

        MenuIterator heart = eatAtJoesMenu.getHeartHealthy();
        System.out.println("\nHeart Healthy");
        while (heart.hasNext()){
            MenuItem item = (MenuItem) heart.getItem();
            System.out.println(item.getItemName() + " $" + item.getPrice());
            heart.next();
        }
        
        
        double itemPrice = 25.00;
        MenuIterator price = eatAtJoesMenu.getPriceIterator(itemPrice);
        System.out.println("\nPrice of main dish");
        while (price.hasNext()){
            MenuItem item = (MenuItem) price.getItem();
            System.out.println(item.getItemName() + " $" + item.getPrice());
            price.next();
        }        
    }

}
