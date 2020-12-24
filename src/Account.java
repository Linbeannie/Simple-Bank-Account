/*
    Title: Account.java
    Author: Madeleine Macaulay
    Email: mmacaulay@csumb.edu
    Abstract: Base class that implements interfaces.
    Date: 10/21/2020
 */
public class Account implements Depositable, Withdrawable, Balanceable{
    private double balance = 0;

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double amount){
        this.balance = amount;
    }
}
