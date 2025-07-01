package Project;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String gender;
    private double accountBalance;

    public User(String name, int age, String gender, double accountBalance) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.accountBalance = accountBalance;
    }

    public void addWinnings(double amount) {
        accountBalance += amount;
    }

    public void deductAmount(double amount) {
        accountBalance -= amount;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Name: " + name + " | Age: " + age + " | Gender: " + gender + " | Balance: Rs " + accountBalance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
