package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Sequence {


    public ArrayList<Object> list;

    public Sequence(int lenght, int ValueMax){
        list = new ArrayList<>();

        Random rand= new Random();
        for(int i = 0; i != lenght; i++)
            list.add(Integer.valueOf(rand.nextInt(ValueMax)));

        }

    public int size(){
        return this.size();
    }
    public int getInt(int index){
        return (int) this.list.get(index);
    }

    public char getChar(char index){
        return (char) this.list.get(index);
    }

    public int setAt(int index, Object newVal){
        return (int) this.list.set(index,newVal);
    }

    public void SwitchInt(int index, int index2){
        int save= (int) this.list.get(index);
        this.setAt(index, this.getInt(index2));
        this.setAt(index2, save);
    }

}


