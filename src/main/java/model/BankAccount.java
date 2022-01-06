package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private int accountId;
    private String name;
    private String codePin;
    private String accountType;
    private double balance;
    private List<AccountStatement> listAccountStatement = new ArrayList<AccountStatement>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    public BankAccount(String name, int accountId, String accountType, long initBalance, String codePin) {
        this.name = name;
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = initBalance;
        this.codePin = codePin;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount");
        } else {
            balance = balance + amount;
            this.listAccountStatement.add(new AccountStatement(AccountStatement.OPERATION_DEPOSIT, formatter.format(new Date()), amount, balance));
        }
        return balance;
    }

    public double withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount");
        }
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
            this.listAccountStatement.add(new AccountStatement(AccountStatement.OPERATION_WITHDRAW, formatter.format(new Date()), amount, balance));
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");
        }

        return balance;
    }

    public int printStatement() {
        this.listAccountStatement.stream().forEach((element) -> {
            System.out.println("Date : " + element.getDate() + "\t Operation : " + element.getOperation() + "\t Amount : " +
                    element.getAmount() + "\t Your Balance is :" + element.getBalance());
        });
        return this.listAccountStatement.size();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodePin() {
        return codePin;
    }

    public void setCodePin(String codePin) {
        this.codePin = codePin;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccountStatement> getListAccountStatement() {
        return listAccountStatement;
    }

    public void setListAccountStatement(List<AccountStatement> listAccountStatement) {
        this.listAccountStatement = listAccountStatement;
    }
}
