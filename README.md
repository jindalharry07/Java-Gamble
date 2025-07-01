# 🎲 Double the Money - Java Gambling Console Game

A console-based Java application where users register, deposit money, and gamble by answering Java/DSA multiple-choice questions. If answered correctly, their bet is doubled; if wrong, they lose the bet. Includes account management and persistent file storage.

---

## 🚀 Features

- 👤 Register new users with name, age, and gender
- 💰 Deposit and withdraw money
- ❓ Answer MCQs to gamble and double your money
- 📁 User data saved persistently in `users.txt`
- 📊 Sort users by Name, Balance, or Age
- 🔐 Save progress and exit

---

## 🧩 Menu Options
----MENU----
1. Register New User
2. Play Game
3. Deposit Money
4. Withdraw Money
5. View Users
6. Sort by Name
7. Sort by Balance
8. Sort by Age
9. Save and Exit


** Project Structure**
DoubleTheMoney/
├── DoubleTheMoney.java    # Main class with menu & flow
├── Game.java              # Game logic (betting and MCQ)
├── Question.java          # Question model and data
├── User.java              # User model (name, age, balance, etc.)
├── UserManager.java       # User operations and file handling
└── users.txt              # Persistent storage for user data
