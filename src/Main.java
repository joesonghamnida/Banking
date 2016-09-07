import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ATM atm = new ATM();

    public static void main(String[] args) throws Exception {

        boolean infiniteLoop = true;
        while (infiniteLoop) {
            System.out.println("Welcome to your local ATM.");
            atm.nameChoice();
            atm.nameCheck();
            //selection loop
            boolean cancel = true;
            while (cancel) {
                atm.printOptions();

                String selection = Main.scanner.nextLine();
                String[] acceptableInput = {"1", "2", "3", "4"};

                switch (selection) {
                    case "1":
                        atm.checkBalance();
                        break;

                    case "2":
                        atm.withdrawMoney();
                        break;

                    case "3":
                        atm.removeAccount();
                        cancel = false;
                        break;

                    case "4":
                        cancel = false;
                        break;
                    default:
                        System.out.println("Please enter a valid input:");
                        break;

                }
            }

            System.out.println("Thank you and please come again");
            System.out.println("---------");
        }
    }
}


