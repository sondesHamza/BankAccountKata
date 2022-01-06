package model;

import java.util.Date;

public class AccountStatement {
    private String date;
    private double amount;
    private double balance;
    public static String OPERATION_DEPOSIT = "DEPOSIT";
    public static String OPERATION_WITHDRAW = "WITHDRAWAL";
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public AccountStatement() {
    }

    public AccountStatement(String operation, String date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
