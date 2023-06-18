package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000) throw new Exception("Insufficient Balance");
        this.tradeLicenseId=tradeLicenseId.toUpperCase();
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
        char maxFreqChar='A';
        for (int i = 0; i < tradeLicenseId.length(); i++) {
            char ch=tradeLicenseId.charAt(i);
            freq[ch-'A']++;
            if(maxFreq<freq[ch-'A']){
                maxFreq=freq[ch-'A'];
                maxFreqChar=ch;
            }
        }
        if( maxFreq > (tradeLicenseId.length()+1)/2) return false;
        char arr[]=new char[tradeLicenseId.length()];
        int i=0;
        while(maxFreq-->0){
            arr[i]=maxFreqChar;
            i+=2;
        }
        freq[maxFreqChar-'A']=0;
        for(int j=0;j<26;j++){

            while(freq[j]-->0){
                if(i>=arr.length){
                    i=1;
                }
                arr[i]=(char)('A'+j);
                i+=2;
            }
        }
        tradeLicenseId=String.valueOf(arr);
        return true;

    }
    public boolean isValidLicenseId(){
        for (int i = 0; i < tradeLicenseId.length()-1; i++) {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)) return false;
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
