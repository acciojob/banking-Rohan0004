package com.driver;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000) throw new Exception("Insufficient Balance");
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isValidLicenseId()){
            if(!isPossibleToMakeValid()) throw new Exception("Valid License can not be generated");
        }

    }
    public boolean isPossibleToMakeValid(){
        int freq[]=new int[26];
        int maxFreq=0;
        for (int i = 0; i < tradeLicenseId.length(); i++) {
            char ch=tradeLicenseId.charAt(i);
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq,freq[ch-'A']);
        }
        return maxFreq <= (tradeLicenseId.length()/2);

    }
    public boolean isValidLicenseId(){
        for (int i = 0; i < tradeLicenseId.length()-1; i++) {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)) return false;
        }
        return true;
    }

}
