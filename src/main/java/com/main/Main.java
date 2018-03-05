package com.main;

import java.text.DecimalFormat;

public class Main {
    /**
     * This is to run the implementation
     */
    public static void main(String[] args) {

        /**
       instance of the vending machine class
         */
        VendingMachine vend  = new VendingMachine(new MoneyService(), new UserInputHandler(), new DecimalFormat());
        /**
         * calling the method
         */
        vend.startProgramme();
    }
}
