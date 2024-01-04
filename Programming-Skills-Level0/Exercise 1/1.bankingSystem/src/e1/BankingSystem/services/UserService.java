package e1.bankingsystem.services;

import e1.bankingsystem.entity.User;
import java.util.Scanner;

public class UserService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    // Method to create the User
    public User user() {

        User user = new User();

        System.out.print("Please enter your full name: ");
        user.setName(sc.next());

        System.out.print("Please introduce your desired username: ");
        user.setUsername(sc.next());

        System.out.println("Please enter your password. It must have at least 8 characters: ");
        String password = sc.next();

        if (password.length() >= 8) {

            user.setPassword(password);

        } else {

            while (password.length() < 8) {

                System.out.println("The password MUST have at least 8 characters. Please enter the password again taking that into account: ");
                password = sc.next();

            }
            
            user.setPassword(password);
        }
        
        System.out.println("The user was successfully created: \n" + user.toString());
        
        return user;

    }
    

}
