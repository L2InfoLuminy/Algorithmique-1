package com.company;

import java.util.LinkedList;

public class Fusion extends Main {

    LinkedList <Object> linkedlist= new LinkedList<>();

    public Fusion (Sequence firstlist) {
         linkedlist.addAll(firstlist.list);
    }

        public void  fusion(LinkedList list){

        int length= list.size();

        for (int n = 0; n!=length; ++n){  //parcour la liste

                LinkedList<Object> rightlist=new LinkedList<>();
                LinkedList<Object> leftlist=new LinkedList<>();

                int i=length/2;

                rightlist.add(list.get(n));
                leftlist.add(list.get(i+n));

                fusion(rightlist);
                fusion(leftlist);

                
        }

    }
}
