import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 9/1/16.
 */
public class ATM {
    //leave these in until hash is complete to keep ij happy
    private String name;
    private HashMap<String, Double> userAccount = new HashMap<>();
    private String selection;

    //constructor
    public ATM() {
        userAccount.put("Joe", 500.00);
    }

    //methods

    //user enters in name and system checks legality
    public void nameChoice() {
        name = "";
        while (name == "") {
            System.out.println("Please enter a username:");
            name = Main.scanner.nextLine();
        }
    }

    public void nameCheck() throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Input not valid");
        }
        for (String keyStep : userAccount.keySet()) {
            if (!(name.equals(keyStep))) {
                System.out.println("You don't seem to be in our system.");
                createAccount();
            } else {
                if (name.equals(keyStep)) {
                    System.out.println("Welcome " + name);
                }//end if
            }//end else
        }//end for
    }//nameCheck

    public void printOptions() {
        System.out.println("---------");
        System.out.println("What would you like to do?");
        System.out.println("1: Check balance");
        System.out.println("2: Withdraw money");
        System.out.println("3: Cancel Account");
        System.out.println("4: Log out of ATM");
    }

    //check balance
    public void checkBalance() throws Exception {
        //check for no name
        if (name.length() < 0) {
            throw new Exception("You don't seem to be in our system.");
        } else {
            System.out.println("Your balance is: $" + userAccount.get(name));
        }
    }

    //withdraw
    public void withdrawMoney() throws Exception {
        System.out.println("Please enter the amount you'd like to withdraw:");

        String amount = Main.scanner.nextLine();
        double amountDouble = Double.parseDouble(amount);

        if (amountDouble < 0) {
            throw new Exception(amount + " is not valid");
        } else if (amountDouble > userAccount.get(name)) {
            throw new Exception("The attempted withdraw exceeded your balance");
        } else {
            double j = userAccount.get(name) - amountDouble;
            userAccount.put(name, j);
            System.out.println("Your balance is now: $" + userAccount.get(name));
            System.out.println("Please take your money");
        }
    }

    public void createAccount() throws Exception {

        System.out.println("Please enter a unique username");
        System.out.println("or enter cancel:");
        name = Main.scanner.nextLine();
        if (name.equals("cancel")) {
            System.out.println("Goodbye\n-----");
        } else {
            for (String key : userAccount.keySet())
                if (name.equals(key)) {
                    System.out.println("That account already exists\n Enter a new name:\n-------");
                } else if (name.isEmpty()) {
                    System.out.println("User name must contain at least one character");
                } else {
                    System.out.println("Your reward for joining is $50.00");
                    userAccount.put(name, 50.00);
                    System.out.println("Your current balance " + name + ", is: $" + userAccount.get(name));
                }
        }
    }

    //remove balance
    public void removeAccount() throws Exception {

        System.out.println("Please enter your user name again to confirm:");
        String nameTemp = Main.scanner.nextLine();
        if (!(nameTemp.equals(name))) {
            throw new Exception("Invalid name: name entered does not match username");
        }
        userAccount.remove(name);
        System.out.println("Your account was deleted, " + name);
    }
}







