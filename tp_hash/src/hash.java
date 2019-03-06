import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.StrictMath.pow;


public class hash extends word {


    public LinkedList[] hash = new LinkedList[primeNumber];
    public static int primeNumber=49999;

    public hash(int length){
        super();
        for(int i=0;i<length;i++){
            this.hash[i]=new LinkedList();
        }
    }



    public static void ouverture(String nom_fichier) throws FileNotFoundException {
        File text = new File(nom_fichier);
        Scanner scnr = new Scanner(text);

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            hashing(line);
        }

    }

    public static int baseConvert(char[] sortedString, int base){

        int wordInBase=0;
        int baseVal=0;
        for(int i=sortedString.length; i>0; i--){
            baseVal=(int)sortedString[i-1];
            wordInBase+=pow((baseVal*base),i)%primeNumber;
        }
        return wordInBase%primeNumber;
    }

    public static void hashing(String line){

        hash tab=new hash(primeNumber);
        char[] sortedLine=alphabeticSorted(line);
        int convertLine = baseConvert(sortedLine,256);
        tab.hash[convertLine].add(line);
        System.out.println(convertLine);
        System.out.println(tab.hash[convertLine]);
    }




}