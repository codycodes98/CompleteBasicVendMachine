package com.main;

import java.text.DecimalFormat;

public class MoneyService {
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public boolean hasSufficientFunds(double currentBalance, double itemPrice) {
        double moneyBank = currentBalance - itemPrice;
        if (moneyBank < 0) {
            return false;
        } else {
            return true;
        }

    }

    public void dispenseChange(double currentBalance, double itemPrice) {
        double change = currentBalance - itemPrice;
        if (change > 0) {
            System.out.println("Please take your change £" + decimalFormat.format(change));
        }
    }
}
