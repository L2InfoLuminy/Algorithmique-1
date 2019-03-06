import java.io.*;
import java.util.ArrayList;

public class word  {

    public String word;

    public word(String word) {
        this.word = word;
    }

    public word() {

    }


    public static char[] alphabeticSorted(String word){
        char[] sortedString = new char[word.length()];
        for(int i=0; i<word.length(); i++){
            sortedString[i]=word.charAt(i);
        }
        for(int i=0; i<word.length();i++){
            for(int j=i+1; j<word.length(); j++){
                if(sortedString[j]<sortedString[i]){
                    char temp=sortedString[i];
                    sortedString[i]=sortedString[j];
                    sortedString[j]=temp;
                }
            }
        }
        return sortedString;
    }

    boolean isEqual(String word1, String word2){
        return word1.equals(word2);
    }


}
