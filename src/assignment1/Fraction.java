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
        this.numerator = numerator;
        this.denominator = denominator;
        checkSign();
    }

    /**
     * Copy constructor for Fraction.
     * 
     * @param f - The Fraction to copy.
     */
    public Fraction(Fraction f) {
        this.numerator = f.numerator;
        this.denominator = f.denominator;
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
    public int getDenomitor() {
        return denominator;
    }

    /**
     *
     * @param denominator - integer denominator value.
     * 
     * This will check the sign of the input using  {@link #checkSign() } to ensure that the sign of the fraction is correct
     */
    public void setDenomitor(int denominator) {
        this.denominator = denominator;
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
        
        if (f.numerator == this.numerator && f.denominator == this.denominator){
            return true;
        } else{  // else not really necessary...
            return false;
        }
        
    }
   
    /**
     *  Reduces 
     */
    public void reduce() {
        int top = numerator;
        int bottom = denominator;
        int larger = 0;

        // allow for negative fractions. Otherwise this will get messed up
        if (numerator < 0) {
            top = -numerator;
        }
        
        // set the larger number to larger
        larger = top;
        if (bottom > top) {
            larger = bottom;
        }

        // find the largest whole number that will divide into the numerator and denominator evenly.
        // This means use mod...
        int commonDenominator = 0;
        for (int i = larger; i >= 2; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                commonDenominator = i;
                // once its found break out
                break;
            }
        }

        // divide both values by the common denominator 
        if (commonDenominator != 0) {
            numerator /= commonDenominator;
            denominator /= commonDenominator;
        }
    }
} 
