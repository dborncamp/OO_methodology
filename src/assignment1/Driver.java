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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction F1 = new Fraction(1,2); 
        Fraction F2 = new Fraction(1,4); 
        System.out.println(F1);
        
        F1.reduce();
        System.out.println("F1: " + F1);
        System.out.println("F2: "+F2);
        
        Fraction add = F1.add(F2);
        System.out.println("Addition: "+add);
        
        Fraction sub = F1.subtract(F2);
        System.out.println("Subtraction: "+sub);
        
        Fraction multi = F1.multiply(F2);
        System.out.println("Multiplication: " + multi);
        
        Fraction div = F1.divide(F2);
        System.out.println("Division: "+div);
        
        System.out.println(div.equals(multi));
                
    }
    
}
