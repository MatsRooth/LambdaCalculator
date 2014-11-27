/*
 * Copyright (C) 2007-2014 Dylan Bumford, Lucas Champollion, Maribel Romero
 * and Joshua Tauberer
 * 
 * This file is part of The Lambda Calculator.
 * 
 * The Lambda Calculator is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * The Lambda Calculator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with The Lambda Calculator.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

/*
 * And.java
 *
 * Created on May 29, 2006, 3:22 PM
 */

package lambdacalc.logic;

import java.awt.event.KeyEvent;

/**
 * Represents the conjunction binary connective.
 */
public class And extends LogicalBinary {
    
    /**
     * The wedge character
     */
    public static final char SYMBOL = '\u2227';
    
    public static final char INPUT_SYMBOL = '&';

    public static final String LATEX_REPR = "\\land";
    
    public static final char ALTERNATE_INPUT_SYMBOL = '^';
    
    public static final int KEY_EVENT = KeyEvent.VK_AMPERSAND;

    /**
     * Constructs the connective.
     * @param left the expression on the left side of the connective
     * @param right the expression on the right side of the connective
     */
    public And(Expr left, Expr right) {
       super(left,right);
    }
    
    public String getSymbol() {
        return String.valueOf(SYMBOL);
    }

    public String getLatexRepr() {
        return LATEX_REPR;
    }

    public Type getOperandType() {
        return Type.T;
    }
    
    protected Binary create(Expr left, Expr right) {
        return new And(left, right);
    }

    
    And(java.io.DataInputStream input) throws java.io.IOException {
        super(input);
    }
    
}
