package Task3_ATM_Interface;

import java.util.*;

//Class representing user's bank account
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true; //Withdraw Successfull
        }

        else{
            return false; //Insufficinet balance
        }
    }
}

//Class representing the ATM Machine
public class ATM_Interface {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        //To create bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        System.out.println("--------JAVA PROGRAMMING INTERNSHIP--------");
        System.out.println("\n---------------TASK - 3---------------");
        System.out.println("\n***** WELCOME TO THE ATM INTERFACE *****");

        //To display the ATM Interface
        displayMenu(userAccount);

        sc.close();
    }

    //Method to display the ATM menu and handle user input
    private static void displayMenu(BankAccount account){
        int option;

        do{
            //To display menu options
            System.out.println("\nATM MENU:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");

            //Prompt user to choose an option
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            //To perform the selected operation
            switch (option) {
                case 1: //Check Balance
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
            
                case 2: //Deposit
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successfull. Current Balance: $" + account.getBalance());
                    break;

                case 3: //Withdraw
                    System.out.print("Enter the amount to Withdraw: $");
                    double withdrawAmount = sc.nextDouble();

                    if(account.withdraw(withdrawAmount)){
                        System.out.println("Withdraw Successful. Current Balance: $" + account.getBalance());
                    }

                    else{
                        System.out.println("Insufficient Balance. Withdrawal failed.");
                    }
                    break;

                case 4: //Exit
                    System.out.println("Thank you for using the ATM. GoodBye!");
                    break;

                default: //Invaild option
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }while(option != 4);
    }
}
