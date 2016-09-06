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
                boolean test = false;
                while (test) {
                    for (int i = 0; i < acceptableInput.length; i++) {
                        System.out.println(i);
                        if (selection == acceptableInput[i]) {
                            test = true;
                            break;
                        }
                        else {
                            System.out.println("Please enter a valid input:");
                        }
                    }
                }

                if(selection.equalsIgnoreCase("1")){
                    atm.checkBalance();
                }
                else if(selection.equalsIgnoreCase("2")){
                    atm.withdrawMoney();
                }
                else if(selection.equalsIgnoreCase("3")){
                    atm.removeAccount();
                    cancel=false;
                }
                else if(selection.equalsIgnoreCase("4")){
                    cancel = false;
                }
            }

                /*switch (selection) {
                    case "1": {
                        atm.checkBalance();
                        break;
                    }
                    case "2": {
                        atm.withdrawMoney();
                        System.out.println("break 1");
                        break;
                    }
                    case "3": {
                        atm.removeAccount();
                        cancel=false;
                        System.out.println("break 2");
                        break;
                    }
                    case "4": {
                        cancel = false;
                        System.out.println("break 3");
                        break;
                    }
                }
            }*/

            System.out.println("Thank you and please come again");
            System.out.println("---------");
        }
    }
}


