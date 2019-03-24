
import java.util.*;
import java.io.*;


public class WordCounter {
    public static void main(String[] args) throws Exception {

        //Making the necessary objects
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<>();
        System.out.print("Enter Your Text Below:\n");
        String essay = reader.readLine();



        //Creating an arrayList of all the words(no spaces)
        String[] essayArray= essay.split(" ");
        for(String x : essayArray){
            String y = x.trim();
            if(!y.equals("")){
                words.add(y);
            }
        }



        // Display

        /* Word Count */
        System.out.println("Word Count: " + wordCount(words) + "\n");
        /* End of Word Count*/

        /* Word Usage*/
        HashMap<String, Integer> wordUsage = wordUsage(words);
        System.out.println("Word Usage:");
        for(String y: wordUsage.keySet()) {
            System.out.println(y + ": " + wordUsage.get(y));
        }
        /*End of Word Usage*/
    }

    public static int wordCount(ArrayList<String> array){
        return array.size();
    }

    public static HashMap<String, Integer> wordUsage(ArrayList<String> words){
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String x: words){
            x = x.toLowerCase();
            x = x.replaceAll("\\.$", "").replaceAll("\\?$","").replaceAll("!$","");
            boolean test = true;
            for(String y: wordMap.keySet()){
                String z = y.toLowerCase();
                z = z.replaceAll("\\.$", "").replaceAll("\\?$","").replaceAll("!$","");;
                if(z.equals(x)) {
                    test = false;
                    wordMap.put(x, wordMap.get(x)+1);
                }

            }
            if(test)wordMap.put(x, 1);
        }
        return wordMap;
    }
}
