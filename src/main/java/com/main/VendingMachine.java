package com.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    MoneyService moneyService;
    UserInputHandler userInput;
    DecimalFormat decimalFormat;

    List<Item> stock = new ArrayList<Item>();
    double balance = 0;

    public void dispenseItem(int option) {
            System.out.println("Dispensing: " + stock.get(option).getName());
    }

    public VendingMachine(MoneyService moneyService, UserInputHandler userInput, DecimalFormat decimalFormat) {
        stock.add(new Item("Snickers", 1.00));
        stock.add(new Item("Yorkie", 1.00));
        stock.add(new Item("Lion", 1.00));
        stock.add(new Item("Double Decker", 1.00));
        stock.add(new Item("Mars", 1.00));
        this.moneyService = moneyService;
        this.userInput = userInput;
        this.decimalFormat = decimalFormat;
    }

    public void displayItems() {
        for (Item item : stock) {
            System.out.println(stock.indexOf(item) + " " + item.getName() + " £" + decimalFormat.format(item.getPrice()));
        }
    }

    public void startProgramme() {
        balance = userInput.acceptMoney();
        displayItems();
        int chosenOption = userInput.chooseItem();
        Item chosenItem = findItem(chosenOption);
        if (moneyService.hasSufficientFunds(balance, chosenItem.getPrice())) {
            dispenseItem(chosenOption);
            moneyService.dispenseChange(balance, chosenItem.getPrice());
        } else {
            insufficientFundsError(chosenItem.getName());
            moneyService.dispenseChange(balance, 0);
        }
    }
    public List<Item> getStock() {
        return stock;
    }

    public Item findItem(int itemNumber) {
        return stock.get(itemNumber);
    }

    public void insufficientFundsError(String nameOfItem) {
        System.out.println("Error, Not enough money for " + nameOfItem);
    }
}