package e1.bankingsystem.services;

import e1.bankingsystem.entity.BankAccount;
import e1.bankingsystem.entity.User;
import java.util.Scanner;

public class BankAccountService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    // Method to create the Bank Account
    public  BankAccount bankAccount(User user) {

        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccountNumber("41956698");
        bankAccount.setAmount(2000.0);
        bankAccount.setUser(user);

        System.out.println("Your account was successfully created. \nHere's the information: " + bankAccount.toString());

        return bankAccount;
    }

    // Method to deposit $ into the Bank Account
    public void deposit(BankAccount bankAccount) {

        System.out.println("How much money would you like to deposit into account #" + bankAccount.getAccountNumber() + "?");

        Double money = sc.nextDouble();

        bankAccount.setAmount(bankAccount.getAmount() + money);

        System.out.println("$" + money + " are being deposit to the account. Please wait..."
                + "Thank you for waiting. Your new balance is: $" + bankAccount.getAmount());

    }

    //Method to withdraw money from the account
    public void withdraw(BankAccount bankAccount) {

        System.out.println("How much money would you like to withdraw from account #" + bankAccount.getAccountNumber() + "?");

        Double money = sc.nextDouble();

        if (bankAccount.getAmount() >= money) {

            bankAccount.setAmount(bankAccount.getAmount() - money);
            System.out.println("One moment, please\n You can withdraw the money.\nYour new balance is: $" + bankAccount.getAmount());

        } else {
            System.out.println("INSUFFICIENT FUNDS :C");
        }

    }

    //Method to transfer money to another account
    public void transfer(BankAccount bankAccount) {

        System.out.println("How much money would you like to transfer from account #" + bankAccount.getAccountNumber() + "?");

        Double money = sc.nextDouble();

        System.out.println("Please enter the account number where you'd like to transfer the money");
        String account = sc.next();
        
        if (bankAccount.getAmount() >= money) {
            
        bankAccount.setAmount(bankAccount.getAmount() - money);
        
        System.out.println("Please wait...\n...\n...\n...\nThank you for waiting, $" + money + " were successfully transferred to account #" + account 
        + ". Your new balance is: $" + bankAccount.getAmount());
        
        } else {
            System.out.println("INSUFFICIENT FUNDS :C");
        }
                
    }
    
    
    // Method to check the balance in the account
    public void checkBalance(BankAccount bankAccount) {
        
        System.out.println("Current balance: $" + bankAccount.getAmount());
        
    }
    
    

}
