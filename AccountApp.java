/*
    Title: AccountApp.java
    Author: Madeleine Macaulay
    Email: mmacaulay@csumb.edu
    Abstract: Transaction operator, deals with object creation and execution.
    Date: 10/21/2020
 */
import java.util.Scanner;
import java.text.NumberFormat;
public class AccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System. in);
        double initChecking;
        double initSavings;
        double checkingFee;
        double savInterestRate;
        double transactionAmount;
        String transactionChoice = "";
        String accountChoice = "";
        String more = "y";
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        percentageFormat.setMinimumFractionDigits(0);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("\nWelcome to the Account Application\n");

        System.out.print("Enter initial Checking amount: ");
        initChecking = input.nextDouble();
        System.out.print("Enter initial Savings Amount: ");
        initSavings = input.nextDouble();
        System.out.print("Enter Checking Fee: ");
        checkingFee = input.nextDouble();
        System.out.print("Enter Savings Interest rate: ");
        savInterestRate = input.nextDouble();

        CheckingAccount myChecking = new CheckingAccount(checkingFee);
        SavingsAccount mySavings = new SavingsAccount(savInterestRate);
        myChecking.deposit(initChecking);
        mySavings.deposit(initSavings);

        System.out.println("\nOK! This is your information\n");
        System.out.printf("Checking Amount: %s\n", formatter.format(initChecking));
        System.out.printf("Savings Amount: %s\n", formatter.format(initSavings));
        System.out.printf("Checking Fee: %s\n", formatter.format(checkingFee));
        System.out.printf("Interest Rate: %s\n", percentageFormat.format(savInterestRate));


        System.out.println("\nEnter transactions for the month\n");


        while(more.equalsIgnoreCase("y")){
            System.out.print("Withdraw or deposit? (w/d) ");
            transactionChoice = input.next();
            System.out.print("Checking or Savings? (c/s) ");
            accountChoice = input.next();
            System.out.print("Amount? ");
            transactionAmount = input.nextDouble();


            System.out.print("\nContinue? (y/n) ");
            more = input.next();
            System.out.println();

            if(accountChoice.equals("c")){
                if(transactionChoice.equals("w")){
                    myChecking.withdraw(transactionAmount);
                }else if(transactionChoice.equals("d")){
                    myChecking.deposit(transactionAmount);
                }
                myChecking.chargeCheckingFee();
            }

            else if(accountChoice.equals("s")){
                if(transactionChoice.equals("w")){
                    mySavings.withdraw(transactionAmount);
                }else if(transactionChoice.equals("d")){
                    mySavings.deposit(transactionAmount);
                }
            }
        }
        mySavings.calculateInterest();
        System.out.println();

        System.out.println("Monthly Payments and Fees");
        System.out.printf("Checking Fee: %s\n", formatter.format(myChecking.getTotalCheckingFee()));
        System.out.printf("Savings Interest payment: %s\n", formatter.format(mySavings.getMonthlyInterest()));

        System.out.println();

        System.out.println("Final Balances");
        System.out.printf("Checking: %s\n", formatter.format(myChecking.getBalance()));
        System.out.printf("Savings: %s\n", formatter.format(mySavings.getBalance()));
    }
}
