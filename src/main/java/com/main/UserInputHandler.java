package com.main;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner = new Scanner(System.in);


    public double acceptMoney() {
        System.out.print("Please input your money £");
        return scanner.nextDouble();

    }

    public int chooseItem() {
        System.out.println("Choose an item ");
        return scanner.nextInt();
    }
}
