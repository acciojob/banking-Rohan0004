package com.driver;

public class SavingsAccount extends BankAccount{
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if((getBalance()) < amount) throw new Exception("Insufficient Balance");
        if(amount>this.maxWithdrawalLimit) throw new Exception("Maximum Withdraw Limit Exceed");
        super.withdraw(amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return 1.0*getBalance()*(1+(this.rate*years)/100);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        if (times==0) throw new ArithmeticException();
        return getBalance()*Math.pow((1+this.rate/times),(years*times));
    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }
}
