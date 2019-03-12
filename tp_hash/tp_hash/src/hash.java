import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.StrictMath.pow;


public class hash extends word {


    public LinkedList[] hash = new LinkedList[primeNumber];
    public static int primeNumber=49999;//41;//49999;

    public hash(int length){
        super();
        for(int i=0;i<length;i++){
            this.hash[i]=new LinkedList();
        }
    }

    public static void main() throws FileNotFoundException {
        ouverture("C:\\Users\\Utilisateur\\Documents\\travail\\L2\\Algo\\TP\\tp_hash\\src\\dico.txt");
    }


    public static void ouverture(String nom_fichier) throws FileNotFoundException {
        File text = new File(nom_fichier);
        Scanner scnr = new Scanner(text);
        hash tab=new hash(primeNumber);
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            hashing(tab,line);
        }

        System.out.println("hashing complited");
        research(tab,"mangersortir");

        System.out.println("fini!!");

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

    public static void hashing(hash tab ,String line){


        char[] sortedLine=alphabeticSorted(line);
        int convertLine = baseConvert(sortedLine,256);
        if(!tab.hash[convertLine].contains(new String(sortedLine))){
            tab.hash[convertLine].add(new String(sortedLine));
        }
    }

    public static void research(hash tab, String word){
        word =new String(alphabeticSorted(word));
        for(int i=0 ; i< primeNumber; i++ ){
            for(int j=0; j<tab.hash[i].size(); j++){
                String dico_word= tab.hash[i].get(j).toString();
                if(isStrictelyInclude(dico_word,word)){
                    word=soustraction(word,dico_word);
                    if(word.length()==0){
                        System.out.println("\n\t\tlongueur = 0 le mot "+word+"est bien composé de plusieurs mots appartenant au dico\n");
                        break;
                    }
                    System.out.println(word);
                }
            }
        }
    }


}