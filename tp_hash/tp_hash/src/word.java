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


    public ArrayList fusionWord ( String word1, String word2){
        ArrayList<String> fusionword= new ArrayList<String>();
        fusionword.add(word1.concat(word2));
        return fusionword;
    }

    public static String soustraction(String word1, String word2){
        String result = new String();
        for(int i=0 ; i<word2.length(); i++){
            for(int j=i; j< word1.length(); j++){
                if(word2.charAt(i)==word1.charAt(j))
                {
                   word2= word2.substring(1);
                }
                else{
                    result+= word1.charAt(j);
                }
            }
        }

        return result;
    }


    public static boolean isStrictelyInclude(Object word1, String word2){
        String save=(String)word1;
        if(save.length()>word2.length()){
            //System.out.println("trop grand");
            return false;
        }

        int compt=0;
        for(int i=0; i < save.length(); i++){
            for(int j=i; j < word2.length(); j++){
                if(save.charAt(i)==word2.charAt(j)){
                    compt++;
                    break;
                }
            }
        }
        return (compt==save.length());

    }


}
