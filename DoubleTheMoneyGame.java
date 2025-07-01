package Project;

import java.util.*;

public class DoubleTheMoneyGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        manager.loadFromFile("users.txt");

        while (true) {
            System.out.println("\n----MENU----");
            System.out.println("1. Register New User");
            System.out.println("2. Play Game");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Users");
            System.out.println("6. Sort by Name");
            System.out.println("7. Sort by Balance");
            System.out.println("8. Sort by Age");
            System.out.println("9. Save and Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    if (manager.getUserByName(name) != null) {
                        System.out.println("User already exists!");
                        break;
                    }
                    System.out.print("Enter your age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter your initial balance: ");
                    double balance = sc.nextDouble();

                    User newUser = new User(name, age, gender, balance);
                    manager.addUser(newUser);
                    System.out.println("User registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String playName = sc.nextLine();
                    User playUser = manager.getUserByName(playName);
                    if (playUser == null) {
                        System.out.println("User not found. Please register first.");
                    } else {
                        Game game = new Game(playUser);
                        game.play();
                    }
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String depName = sc.nextLine();
                    User depUser = manager.getUserByName(depName);
                    if (depUser != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        depUser.deposit(amount);
                        System.out.println("Deposit successful. Balance: Rs" + depUser.getBalance());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String withName = sc.nextLine();
                    User withUser = manager.getUserByName(withName);
                    if (withUser != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        if (withUser.withdraw(amount)) {
                            System.out.println("Withdraw successful. Balance: Rs" + withUser.getBalance());
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    manager.displayUsers();
                    break;

                case 6:
                    manager.sortByName();
                    manager.displayUsers();
                    break;

                case 7:
                    manager.sortByBalance();
                    manager.displayUsers();
                    break;

                case 8:
                    manager.sortByAge();
                    manager.displayUsers();
                    break;

                case 9:
                    manager.saveToFile("users.txt");
                    System.out.println("Data saved. Thank you for playing!");
                    return;

                default:
                    System.out.println("Invalid option. Choose between 1-9.");
            }
        }
    }
}
