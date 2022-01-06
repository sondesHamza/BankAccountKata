package web;

import model.AccountStatement;
import model.BankAccount;

import java.util.Scanner;

public class BankAccountKata {
    static Scanner scan = new Scanner(System.in);
    static String codePin;
    static double amount;
    static int n = 0;

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Hamza", 001, "First Account", 300, "2022");

        char anotherTransact, option;
        do {
            System.out.println("\nWelcome to SG BANK \n");
            System.out.println("B - Check Your Balance");
            System.out.println("D - Makpe Deosit");
            System.out.println("W - Make Withdraw");
            System.out.println("P - Print Statement");
            System.out.println("Q - Quit");

            System.out.print("\nSelect an option : ");
            option = scan.next().charAt(0);
            option = Character.toUpperCase(option);
            switch (option) {
                case 'B':
                    System.out.println("\nYour current balance is " + bankAccount.getBalance());
                    break;
                case 'D':
                    depositMoney(bankAccount);
                    break;
                case 'W':
                    withdrawMoney(bankAccount);
                    break;
                case 'P':
                    bankAccount.printStatement();
                    break;
            }


            System.out.print("\nWant to Transact another (Y/N?) ");
            anotherTransact = scan.next().charAt(0);
        }

        while ((anotherTransact == 'Y') || (anotherTransact == 'y'));
    }

    static void depositMoney(BankAccount bankAccount) {
        verifyAndAction(AccountStatement.OPERATION_DEPOSIT, bankAccount);
    }

    static void withdrawMoney(BankAccount bankAccount) {
        verifyAndAction(AccountStatement.OPERATION_WITHDRAW, bankAccount);
    }

    static void verifyAndAction(String operation, BankAccount bankAccount) {
        boolean valid = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("\nEnter Your Code PIN : ");
            codePin = scan.next();
            //we have to check code pin
            if (codePin.equals(bankAccount.getCodePin())) {
                System.out.print("\nEnter amount to " + operation + " :");
                amount = scan.nextDouble();
                if (operation.equals(AccountStatement.OPERATION_WITHDRAW)) {
                    bankAccount.withdraw(amount);
                } else {
                    bankAccount.deposit(amount);
                }
                valid = true;
                break;
            } else {
                System.out.print("\nYour Code is invalid please retry again !!! ");
            }

        }
        if (!valid) {
            System.out.print("\n Account blocked, please contact your bank !!!!");
        }
    }
}
