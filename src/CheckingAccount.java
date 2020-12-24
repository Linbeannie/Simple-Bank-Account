/*
    Title: CheckingAccount.java
    Author: Madeleine Macaulay
    Email: mmacaulay@csumb.edu
    Abstract: Subclass of Account, handles CheckingAccount information.
    Date: 10/21/2020
 */
public class CheckingAccount extends Account{
    private double checkingFee;
    private double totalCheckingFee;
    public CheckingAccount(){
       checkingFee = 0;
       totalCheckingFee = 0;
    }
    public CheckingAccount(double checkingFee){
        this.checkingFee = checkingFee;
    }
    public double getTotalCheckingFee(){
        return totalCheckingFee;
    }

    public void setCheckingFee(double checkingFee) {
        this.checkingFee = checkingFee;
    }
    public void chargeCheckingFee(){
        totalCheckingFee += checkingFee;
        setBalance(getBalance() - checkingFee);
    }

}
