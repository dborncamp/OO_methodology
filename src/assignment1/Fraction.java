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
package assignment1;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * 
 * See https://github.com/dborncamp/OO_methodology/tree/master/src/assignment1 for code.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Basic constructor.
     * 
     * @param numerator - Numerator for the Fraction.
     * @param denominator - Denominator for the Fraction.
     */
    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
        this.checkSign();
    }

    /**
     * Copy constructor for Fraction.
     * 
     * @param f - The Fraction to copy.
     */
    public Fraction(Fraction f) {
 //       this.numerator = f.numerator;
 //       this.denominator = f.denominator;
        setNumerator(f.getNumerator());
        setDenominator(f.getDenominator());
        this.checkSign();
    }
    
    /**
     * Constructor to initialize a zero fraction.
     */
    public Fraction (){
        this.denominator=0;
        this.numerator=0;
    }

    /**
     *
     * @return - Returns the numerator. 
     * 
     *  If this is called after the {@link #reduce() } method is
     *  called before this then it will return the reduced version of the fraction.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     *
     * @param numerator - integer numerator value.
     * 
     * This will check the sign of the input using  {@link #checkSign() } to ensure that the sign of the fraction is correct
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        checkSign();
    }

    /**
     *
     * @return - Returns the denominator. 
     * 
     *  If this is called after the {@link #reduce() } method is
     *  called before this then it will return the reduced version of the fraction.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     *
     * @param denominator - integer denominator value.
     * 
     * This will check the sign of the input using  {@link #checkSign() } to ensure that the sign of the fraction is correct
     */
    public void setDenominator(int denominator) {
        if (denominator !=0){
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("0 Denominator not allowed");
        }
        checkSign();
    }
    
    /**
     * Check the sign of the numerator and denominator numbers. This ensures that the fraction will always print
     * nicely and will reduce well.
     * I want the numerator to always be the negative number if the number is negative. This makes things nicer
     * for reducing.
     */
    protected void checkSign(){
        // denominator negative, numerator positive, flip both signs
        if (this.denominator < 0 && this.numerator  > 0){
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
            // denomitor negative and numerator negative, also switch signs of both
        } else if (this.denominator<0 && this.numerator<0){
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
    
    /**
     * Test equality between this fraction and another.
     * 
     * @param f - Fraction
     * @return boolean 
     * 
     *  Note: This will call {@link #reduce() } on both {@link #Fraction(int, int) }s so it may potentially change the value of the
     *  numerator and denominator for each fraction. But the fraction will still evaluate to the same value.
     */
    public boolean equals(Fraction f){
        // Make sure both Fractions are in lowest common form before checking for equality
        f.reduce();
        this.reduce();
        
        return f.getNumerator() == this.getNumerator() && f.getDenominator() == this.getDenominator(); // else not really necessary...
        
    }
    
    /**
     * Finds and returns the greatest Common Factor between the numerator and denominator of this fraction
     * 
     * @return greatest Common Factor
     */
    private int commonFactor(){
        int larger = numerator;
         if ( denominator > numerator) {
            larger = denominator;
        }       
        int greatestCommonFactor = 0;
        for (int i = larger; i >= 2; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                greatestCommonFactor = i;
                // once its found break out and return 
                break;
            }
        }
        return greatestCommonFactor;
    }
      
      
    /**
     *  Reduces the fraction to its lowest form
     */
    public void reduce() {
        // If it is 0 set everything to zero and move on.
        if (getNumerator() == 0 || getDenominator()==0){
            setDenominator(0);
            setNumerator(0);
        } else{
            int greatestCommonFactor = commonFactor();

            // divide both values by the common denominator 
            if (greatestCommonFactor != 0) {
                numerator /= greatestCommonFactor;
                denominator /= greatestCommonFactor;
            }
        }
    }
    
    /**
     * Add 2 fractions together.
     * 
     * @param f - Fraction to add to this one
     * @return - Added Fraction.
     * 
     * This will return a reduced fraction as per the instructions.
     */
    public Fraction add(Fraction f){
        // set up some initial values/
        int den;
        int num1;
        int num2;
        
        // do the math
        den = this.getDenominator() * f.getDenominator();
        
        num1 = this.getNumerator() * f.getDenominator();
        num2 = this.getDenominator() * f.getNumerator();
        
        // make a new fraction
        Fraction added = new Fraction(num1 + num2, den);
        
        // reduce the fraction
        added.reduce();
        
        return added;
    }
    
    /**
     * Subtract a fraction from this one
     * 
     * @param f - A Fraction to subtract.
     * @return - the difference in fractions
     */
    public Fraction subtract(Fraction f){
        int den;
        int num1;
        int num2;
        
        den = this.getDenominator() * f.getDenominator();
        
        num1 = this.getNumerator() * f.getDenominator();
        num2 = this.getDenominator() * f.getNumerator();
        
        // make a new fraction
        Fraction subtracted = new Fraction(num1 - num2, den);
        
        // reduce the fraction
        subtracted.reduce();
        
        return subtracted;       
    }
    
    /**
     * Multiply Fractions
     * 
     * @param f - The Fraction to multiply by
     * @return - The multiplied Fraction.
     */
    public Fraction multiply(Fraction f){
        int den;
        int num;
        
        den = this.getDenominator() * f.getDenominator();
        num = this.getNumerator() * f.getNumerator();
        
        Fraction multiplied = new Fraction (num,den);
        
        multiplied.reduce();
        
        return multiplied;
    }
    
    /**
     * Divide fractions
     * 
     * @param f - Fraction to divide by
     * @return - Divided Fraction.
     */
    public Fraction divide(Fraction f){
        int num1;
        int num2;
        
        num1 = this.getNumerator() * f.getDenominator();
        num2 = f.getNumerator() * this.getDenominator();
        
        Fraction divided = new Fraction(num1, num2);
        
        divided.reduce();
        
        return divided;
    }
} 
