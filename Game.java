package Project;

import java.util.*;

public class Game {
    private User user;
    private Scanner sc;
    private List<Question> questions;

    public Game(User user) {
        this.user = user;
        this.sc = new Scanner(System.in);
        this.questions = generateQuestions();
    }

    private List<Question> generateQuestions() {
        List<Question> list = new ArrayList<>();
    
        // Java Basics
        list.add(new Question("What is the default value of an int in Java?", new String[]{"0", "null", "undefined", "1"}, 1));
        list.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"implement", "inherits", "extends", "interface"}, 3));
        list.add(new Question("Which method is automatically called when an object is created?", new String[]{"constructor", "destructor", "finalize", "init"}, 1));
        list.add(new Question("Which keyword is used to prevent inheritance?", new String[]{"private", "protected", "final", "static"}, 3));
        list.add(new Question("Which of the following is not a Java keyword?", new String[]{"static", "Integer", "final", "void"}, 2));
    
        // OOP
        list.add(new Question("Which concept allows using the same method name with different parameters?", new String[]{"Inheritance", "Abstraction", "Overloading", "Overriding"}, 3));
        list.add(new Question("Which of the following is not a pillar of OOP?", new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Compilation"}, 4));
        list.add(new Question("Which access modifier is most restrictive?", new String[]{"public", "private", "protected", "default"}, 2));
        list.add(new Question("What does 'this' keyword refer to?", new String[]{"Superclass", "Current object", "Static method", "None of the above"}, 2));
        list.add(new Question("Which concept binds data and code together?", new String[]{"Polymorphism", "Inheritance", "Encapsulation", "Abstraction"}, 3));
    
        // Arrays
        list.add(new Question("What is the index of the first element in a Java array?", new String[]{"0", "1", "-1", "Depends"}, 1));
        list.add(new Question("Which is the correct way to declare an array?", new String[]{"int arr[] = new int[5];", "int arr = new int[5];", "int[] arr = int[5];", "array int arr = new int(5);"}, 1));
        list.add(new Question("What is the time complexity to access an array element?", new String[]{"O(1)", "O(n)", "O(log n)", "O(n log n)"}, 1));
        list.add(new Question("Which method gives the size of an array?", new String[]{"size()", "length()", "length", "getSize()"}, 3));
    
        // Linked List
        list.add(new Question("Which data structure is best for dynamic memory allocation?", new String[]{"Array", "Stack", "Queue", "Linked List"}, 4));
        list.add(new Question("Each node in a singly linked list contains:", new String[]{"Data only", "Data and next pointer", "Next and previous pointers", "Only previous pointer"}, 2));
        list.add(new Question("Inserting an element in the middle of a linked list is:", new String[]{"O(1)", "O(log n)", "O(n)", "O(n log n)"}, 3));
        list.add(new Question("Which pointer does the last node in a singly linked list hold?", new String[]{"null", "0", "head", "self"}, 1));
    
        // Stack
        list.add(new Question("Which data structure uses LIFO?", new String[]{"Queue", "Stack", "LinkedList", "Array"}, 2));
        list.add(new Question("Which method is used to remove the top element in a stack?", new String[]{"push()", "pop()", "peek()", "remove()"}, 2));
        list.add(new Question("Which internal structure is used in recursion?", new String[]{"Heap", "Queue", "Stack", "Array"}, 3));
    
        // Queue
        list.add(new Question("Which data structure uses FIFO?", new String[]{"Stack", "Queue", "Linked List", "Tree"}, 2));
        list.add(new Question("Which method adds an element to a queue?", new String[]{"pop()", "enqueue()", "insert()", "addBack()"}, 2));
        list.add(new Question("Which queue removes both ends?", new String[]{"Priority Queue", "Simple Queue", "Deque", "Circular Queue"}, 3));
    
        // Trees
        list.add(new Question("Binary tree can have max how many children per node?", new String[]{"1", "2", "3", "Unlimited"}, 2));
        list.add(new Question("Which traversal visits root before children?", new String[]{"Inorder", "Postorder", "Preorder", "Levelorder"}, 3));
        list.add(new Question("Which traversal uses a queue?", new String[]{"Inorder", "Preorder", "Levelorder", "Postorder"}, 3));
        list.add(new Question("Which is not a type of binary tree?", new String[]{"Full tree", "Balanced tree", "Complete tree", "Circular tree"}, 4));
        list.add(new Question("Height of a single node tree is:", new String[]{"0", "1", "2", "Depends"}, 2));
    
        return list;
    }
    
    public void play() {
        System.out.println("\nWelcome to the Double the Money Game, " + user.getName() + "!");
        System.out.println("Your current balance: Rs" + user.getBalance());

        double bet;
        do {
            System.out.print("Enter the amount you want to bet (Min Rs10): ");
            bet = sc.nextDouble();
        } while (bet < 10 || bet > user.getBalance());

        user.deductAmount(bet);
        boolean won = true;

        while (won) {
            Question q = questions.get(new Random().nextInt(questions.size()));
            if (q.askQuestion(sc)) {
                bet *= 2;
                System.out.println("Correct! Your winnings are now Rs" + bet);
                System.out.print("Do you want to play again and double it? (yes/no): ");
                String choice = sc.next().toLowerCase();
                if (!choice.equals("yes")) {
                    user.addWinnings(bet);
                    System.out.println("You won Rs" + bet + "! Added to your account.");
                    break;
                }
            } else {
                System.out.println("Wrong answer! You lost your bet.");
                break;
            }
        }
        System.out.println("Your final balance: Rs" + user.getBalance());
    }
}
