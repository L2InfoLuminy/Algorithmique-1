package com.company;

import java.util.ArrayList;

public class bubble extends Main{


    int n;

    public static void bubble(int n, Sequence list) {
        for(int i = n; i>1 ; i-- ){
            for(int j = 0 ; j<i-1 ; j++)

                if( list.getInt(j) > list.getInt(j+1)){
                    list.SwitchInt( j , j+1);
                }

        }
    }
}
