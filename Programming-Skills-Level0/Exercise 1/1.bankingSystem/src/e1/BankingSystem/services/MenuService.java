package e1.bankingsystem.services;

import e1.bankingsystem.entity.BankAccount;
import e1.bankingsystem.entity.User;
import java.util.Scanner;

public class MenuService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    BankAccountService bas = new BankAccountService();

    //Method that valids the user
    public Boolean logIn(User user) {

        int i = 0;

        do {
            System.out.print("USERNAME: ");
            String username = sc.next();

            System.out.print("PASSWORD: ");
            String password = sc.next();

            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {

                System.out.println("You have successfully signed-in");
                
                return true;

            } else {
                i++;
            }

        } while (i < 3);
        if (i == 3) {
            System.out.println("ACCOUNT BLOCKED!!!\nPlease contact your financial institution");            
        }
        return false;
    }
    
    

    // Method that displayed the menu
    public void menu(BankAccount bankAccount) {

        Boolean exit = false;

        do {
            System.out.println("\n|||=======<>=====(M)(E)(N)(U)=====<>=======|||\n");

            System.out.println("1- DEPOSIT\n2- WITHDRAW\n3- TRANSFER\n4- CHECK BALANCE\n "
                    + "Press the option you would like to perform: ");
            String opt = sc.next();

            switch (opt) {
                case "1":
                    bas.deposit(bankAccount);
                    break;
                case "2":
                    bas.withdraw(bankAccount);
                    break;
                case "3":
                    bas.transfer(bankAccount);
                    break;
                case "4":
                    bas.checkBalance(bankAccount);
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }

            exit = askToExit();

        } while (!exit);

        System.out.println("Thank you for using our service =)");

    }

    //Method that helps exiting from the Menu
    public Boolean askToExit() {

        System.out.println("Would you like to exit? (Y/N)");
        String opt = sc.next();
        return opt.equalsIgnoreCase("Y");

    }

}
