package com.driver;

public class Main {
    public static void main(String[] args) throws Exception{
        CurrentAccount currentAccount=new CurrentAccount("abc",5000,"AABAAAAaAAAAAACDERRRHHYLL");
        System.out.println(currentAccount.isValidLicenseId());
//        currentAccount.validateLicenseId();
        currentAccount.deposit(500);
        currentAccount.withdraw(200);
        System.out.println(currentAccount.getBalance());


        BankAccount bankAccount=new BankAccount("e2",6000,3000);
        System.out.println(bankAccount.generateAccountNumber(5,27));


        SavingsAccount savingsAccount=new SavingsAccount("e3",40000,10000,8.5);
        savingsAccount.withdraw(20000);
        savingsAccount.withdraw(1000);
        System.out.println(savingsAccount.getSimpleInterest(5));
        System.out.println(savingsAccount.getCompoundInterest(2,2));

        System.out.println(currentAccount.getTradeLicenseId());
        currentAccount.validateLicenseId();
        System.out.println(currentAccount.getTradeLicenseId());
    }
}