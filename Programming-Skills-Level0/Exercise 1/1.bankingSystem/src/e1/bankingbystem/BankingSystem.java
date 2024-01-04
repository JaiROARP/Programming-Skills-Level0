package e1.bankingbystem;

import e1.bankingsystem.entity.BankAccount;
import e1.bankingsystem.entity.User;
import java.util.Scanner;
import e1.bankingsystem.services.BankAccountService;
import e1.bankingsystem.services.MenuService;
import e1.bankingsystem.services.UserService;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        UserService us = new UserService();
        BankAccountService bas = new BankAccountService();
        MenuService ms = new MenuService();

        // It starts creating the user
        User user = us.user();

        System.out.println("One moment, please. Your bank account is being created...");

        // Then, it creates the bank account
        BankAccount ba = bas.bankAccount(user);

        //It valids the user
        if (ms.logIn(user)) {
            // if the user is validated, the Menu starts and then you can start the transactions.
            ms.menu(ba);
        } else {
            //if the user is not validated, the account is blocked and the program closes.
            System.out.println("Exiting the program...");
        }

    }

}
