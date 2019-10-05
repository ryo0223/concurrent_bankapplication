package com.company;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

import static java.lang.Math.abs;


public class Main  {
    public static void main(String args[]){

        Thread Department1=new Thread(new BankThread(50));
        Thread Department2=new Thread(new BankThread(50));
        Thread Department3=new Thread(new BankThread(50));
        Thread Department4=new Thread(new BankThread(50));

        Thread Department5=new Thread(new BankThread(50));
        Thread Department6=new Thread(new BankThread(50));
        Thread Department7=new Thread(new BankThread(50));
        Thread Department8=new Thread(new BankThread(50));
        Thread Department9=new Thread(new BankThread(50));
        Thread Department10=new Thread(new BankThread(50));

        Department1.start();
        Department2.start();
        Department3.start();
        Department4.start();
        Department5.start();
        Department6.start();
        Department7.start();
        Department8.start();
       Department9.start();
       Department10.start();
    }

}




