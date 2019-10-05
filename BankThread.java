package com.company;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class BankThread implements Runnable {
    private static ArrayList<Bankaccount> accountlist= new ArrayList<Bankaccount>();
    public BankThread(int num_account){
        ArrayList<Bankaccount> banklist=new ArrayList<Bankaccount>();
        for(int i=0;i< num_account;i++){
            String bank_name="account"+String.valueOf(i);
            Bankaccount account= new Bankaccount(500, bank_name,i);
            banklist.add(account);
        }
        accountlist= banklist;
    }
@Override
    public void run() {
        try {
            int i =0;
            int num_t=Thread.activeCount()-1;
            int num=0;

            while( i<(35000/num_t))
             {
                 Random rand = new Random();


                 num = rand.nextInt(50);
                 int randomnum=rand.nextInt(3);



                if(randomnum==0) {
                    accountlist.get(num).deposit(10);
                }
                else if(randomnum==1) {

                    Thread.sleep(10);
                    accountlist.get(num).withdraw(10);
                }else {


                    accountlist.get(num).transfer(10, accountlist.get(abs(50 - num - 1)));
                }

                i++;

            }
            System.out.print(Thread.currentThread().getName());
            System.out.println(" finished");

        } catch (InterruptedException e) {
            System.out.println("interrupted");

        }
    }
}