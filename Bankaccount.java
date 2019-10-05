package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankaccount {
    private int balance;
    private int account_id;
    private String ownername;

    private final Lock accountLock=new ReentrantLock();
    public Bankaccount(int initial_amount,String name, int id) {
        balance = initial_amount;
        ownername=name;
        account_id=id;
    }
    public   void deposit(int amount){

        try{
            this.accountLock.lock();
        balance=  (balance+amount);
        System.out.format("%s %d added Total balance %d%n",ownername,amount,balance);}
        finally{
            this.accountLock.unlock();
        }

    }
    public void withdraw(int subtraction){
        if(balance-subtraction<0){

            return;
        }

        try{
            this.accountLock.lock();

        balance=balance-subtraction;
        System.out.format("%s %d subtracted Total balance %d%n",ownername,subtraction,balance);}
        finally {
            this.accountLock.unlock();
        }
    }
    public  void transfer(int amount , Bankaccount Account_to_transfer) {
        if (amount > this.balance) {

            return;
        }
        if (this.account_id > Account_to_transfer.account_id) {
            try {
                this.accountLock.lock();


                try {
                    Account_to_transfer.accountLock.lock();
                    this.balance = this.balance - amount;
                    Account_to_transfer.balance = Account_to_transfer.balance + amount;
                    System.out.format("Transfer %d total balance:%d from %s to %s %n", amount, this.balance,this.ownername,Account_to_transfer.ownername);
                } finally {
                    Account_to_transfer.accountLock.unlock();
                }
            } finally {
                this.accountLock.unlock();


            }
        }
        else if (this.account_id < Account_to_transfer.account_id) {
            try {
                Account_to_transfer.accountLock.lock();


                try {
                    this.accountLock.lock();

                    this.balance = this.balance - amount;
                    Account_to_transfer.balance = Account_to_transfer.balance + amount;
                    System.out.format("Transfer %d total balance:%d from %s to %s %n", amount, this.balance,this.ownername,Account_to_transfer.ownername);
                } finally {
                    this.accountLock.unlock();
                }
            } finally {
                Account_to_transfer.accountLock.unlock();



            }
        }
    }
}
