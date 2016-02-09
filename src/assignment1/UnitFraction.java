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
 * @date 02/07/16
 * 
 * A unit fraction is defined as a fraction where the numerator is one and the denominator is a positive integer.
 * Make sure to check that the arguments are good
 * 
 *  In order to make this class immutable this class would need to remove all setters and make the class final so 
 * that methods cannot be overridden. Then all of the variables should also be made private and final so that they
 * cannot be accessed directly. 
 */
public class UnitFraction extends Fraction{

    /**
     * Normal Constructor
     * 
     * @param numerator - Numerator for the Fraction.
     * @param denominator-  Denominator for the Fraction.
     */
    
    private void check(int num, int den){
        if (num != 1 || den < 0){
            throw new IllegalArgumentException();
        }
    }
    
    public UnitFraction(int numerator, int denominator) {
        super(numerator, denominator);
        check(numerator, denominator);
    }

    /**
     * Copy Constructor
     * @param f - Fraction or UnitFraction to copy
     */
    public UnitFraction(Fraction f) {
        super(f);
        check(f.getNumerator(), f.getDenominator());
    }
    
    
    @Override
    public String toString(){
        return "UnitFraction "+Integer.toString(+this.getNumerator()) + "/" + Integer.toString(this.getDenominator());
    }

}
