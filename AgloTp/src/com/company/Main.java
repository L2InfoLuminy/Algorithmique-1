package com.company;


public class Main{

    public static void main(String[] args){


        Sequence list = new Sequence(8, 10);

        System.out.print("[ ");
        for(int i=0; i!=8; i++)  {
          System.out.print(list.getInt(i));
          System.out.print(" "); }
        System.out.println(" ]\n");

       // bubble.bubble(8, list);

      // list.SwitchInt(0,7);

        System.out.print("[ ");
        for(int i=0; i!=8; i++)  {
            System.out.print(list.getInt(i));
            System.out.print(" "); }
        System.out.println(" ]\n");


    }

}

