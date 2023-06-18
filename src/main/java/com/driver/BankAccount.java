package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

//        String[] accNo=new String[1];
//        if(sum <= (digits*9) && getAccNo(digits,sum,"",accNo)) return accNo[0];

        if(sum > (digits*9)) throw new Exception("Account Number can not be generated");
        String ans="";
        for (int i = digits; i > 0; i--) {
            if(sum>9){
                ans=ans+"9";
                sum-=9;
            }else{
                ans=ans+sum;
                sum=0;
            }
        }
        return ans;
    }

//    public boolean getAccNo(int n,int s,String asf,String []ans){
//        if (n==0 && s==0) {
//            ans[0]=asf;
//            return true;
//        }
//        if(n<=0 || s<0) return false;
//        for (int i = 0; i < 10; i++) {
//            if(getAccNo(n-1,s-i,asf+i,ans)) return true;
//        }
//        return false;
//    }

    public void deposit(double amount) {
        //add amount to balance
        if (amount>0)  this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((this.balance-amount) < this.minBalance) throw new Exception("Insufficient Balance");
        this.balance-=amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

}