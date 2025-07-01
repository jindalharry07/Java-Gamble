package Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }



    // Sort by name (case insensitive)
    public void sortByName() {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                String name1 = users.get(j).getName().toLowerCase();
                String name2 = users.get(j + 1).getName().toLowerCase();
                if (name1.compareTo(name2) > 0) {
                    // Swap
                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }
    }

    // Sort by age (ascending)
    public void sortByAge() {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                if (users.get(j).getAge() > users.get(j + 1).getAge()) {
                    // Swap
                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }
    }

    // Sort by balance (ascending)
    public void sortByBalance() {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                if (users.get(j).getBalance() > users.get(j + 1).getBalance()) {
                    // Swap
                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }
    }

    // public void displayUsers() {
    //     for (User user : users) {
    //         System.out.println(user);
    //     }
    // }
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        System.out.printf("%-15s %-5s %-10s %-10s%n", "Name", "Age", "Gender", "Balance (Rs)");
        System.out.println("--------------------------------------------------");
        for (User u : users) {
            System.out.printf("%-15s %-5d %-10s %-10.2f%n", u.getName(), u.getAge(), u.getGender(), u.getBalance());
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Project/" + filename))) {
            for (User user : users) {
                writer.write(user.getName() + "," + user.getAge() + "," + user.getGender() + "," + user.getBalance());
                writer.newLine();
            }
            System.out.println("Users saved to Project/" + filename);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("Project/" + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    double balance = Double.parseDouble(parts[3]);
                    users.add(new User(name, age, gender, balance));
                }
            }
            System.out.println("Users loaded from Project/" + filename);
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}
