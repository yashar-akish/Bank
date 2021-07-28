import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ATM {
    
    public static void main(String [] args){
        
   
        Account acc = new Account();
        List<Account> listAcc = new ArrayList<>();
        short choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\tBANK ACCOUNT APPLICATION\n========================================");
        do{
            System.out.println("\n:1: Add a Bank account.\n:2: remove a Bank Account.\n"
                + ":3: Display the information of an account.\n:4: Deposit to an account.\n"
                + ":5: Withdraw from an account.\n:6: Sort the accounts by balance amount."
                + "\n:7: Display the average balance value of the accounts.\n"
                + ":8: Display the total balance value of the accounts.\n:9: Exite.\n"
                + "\n==========================================");
            System.out.print("\n\tEnter your choice : ");
            choice = input.nextShort();
            switch(choice){
                case 1:     //adding a new account
                    System.out.println("\n ⚠ The Account Number Should be between 10000 and 10099 !!");
                    int num = 0;
                    boolean isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter Account Number : # ");
                        if (input.hasNextInt()) {
                            num = input.nextInt();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.");
                        }
                        input.nextLine();
                    }
                    Account.addAccount(num, listAcc);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 2:     //removing an account
                    // input account number
                    int number = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the Account Number you want to Remove : # ");
                        if (input.hasNextInt()) {
                            number = input.nextInt();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.");
                        }
                        input.nextLine();
                    }
                    Account.removeAccount(listAcc, number);
                    System.out.println(".........................................\n\n");
                    break;
                case 3:     //display an account
                    // input account number
                    number = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the Account Number to Display : # ");
                        if (input.hasNextInt()) {
                            number = input.nextInt();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.\n\n");
                        }
                        input.nextLine();
                    }
                    Account.findAccount(listAcc, number);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 4:     //deposit to an account
                    // input account number
                    number = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the Account Number to Deposit : ");
                        if (input.hasNextInt()) {
                            number = input.nextInt();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.\n\n");
                        }
                        input.nextLine();
                    }
                    // input money
                    double money = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the amount you want to Deposit : $ ");
                        if (input.hasNextDouble()) {
                            money = input.nextDouble();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.\n\n");
                        }
                        input.nextLine();
                    }
                    Account.depositAccount(listAcc, number, money);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 5:     //withdraw from an account
                    // input account number
                    number = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the Account Number to Withdraw : ");
                        if (input.hasNextInt()) {
                            number = input.nextInt();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.\n\n");
                        }
                        input.nextLine();
                    }
                    //  input money
                    money = 0;
                    isValid = false;    //validating the input type
                    while (isValid == false) {
                        System.out.print(" Enter the amount you want to Withdraw : $ ");
                        if (input.hasNextDouble()) {
                            money = input.nextDouble();
                            isValid = true;
                        }
                        else {
                            System.out.println("Sorry! Invalid input. Try again.\n\n");
                        }
                        input.nextLine();
                    }
                    Account.withdrawAccount(listAcc, number, money);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 6:     //sortimg the accounts by balance(asc/des) or by account number
                    do{
                        System.out.print(" for Descendant Displaing by balance press 1\n"
                                + " for Ascendant Displaing by balance press 2"
                                + "\n for Descendent Displaying by Account Number press 3"
                                + "\n for Ascendent Displaying by Account Number press 4"
                                + "\n--------------------------------------"
                                + "\n  1 or 2 or 3 or 4 :    ");
                        number = input.nextInt();
                    }while(number != 1 && number !=2 && number !=3 && number != 4);
                     Account.sortingAccounts(listAcc, number);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 7:     //displaying the average value the accounts
                    double avg = Account.avgBalance(listAcc);
                    System.out.printf(" The average balance of the accounts is $ %.2f",avg);
                    System.out.println("\n.........................................\n\n");
                    break;
                case 8:     //displaying the total balance of the accounts
                    double total = Account.totalBalance(listAcc);
                    System.out.printf(" The average balance of the accounts is $ %.2f",total);
                    System.out.println("\n.........................................\n\n");
                    break;
            }
                
        }while(choice != 9);       //exite
        System.out.println("\n\t Thank you for using this application\n\tCreated by YASHAR AKISH  ::  June 2020");
        
    }
}


