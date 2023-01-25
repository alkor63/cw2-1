package TextCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextScanner {

    public static void main(String[] args) {
        System.out.println("Количество слов в тексте = " + getWordCount(makeWordList()));
        System.out.println("Частотное распределение слов в тексте :" + getFrequencyForWord("то", makeWordList()));
        for (HashMap.Entry<String, Integer> anyWord : makeWordList().entrySet()) {
            System.out.println("кол-во повторов: " + anyWord.getValue() + "\t слово: " + anyWord.getKey());
        }
    }

    /*
    public ArrayList<String> makeWordList(){
        Scanner scan = new Scanner(yourTextFileOrOtherTypeOfInput);
        ArrayList<String> listOfWords = new ArrayList<String>();

           String word = scan.next(); //scanner automatically uses " " as a delimeter
    */
    public static HashMap<String, Integer> makeWordList() {
        String inputText = "стою на асфальте в лыжи обутый, то ли лыжи не едут, то ли я перегрелся";
        Scanner scan = new Scanner(inputText);
        HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
//        Scanner scan = new Scanner(sc);
        while (scan.hasNext()) {
            String word = scan.next(); //scanner automatically uses " " as a delimeter
            int countWord = 0;
            if (!listOfWords.containsKey(word)) {                             //add word if it isn't added already
                listOfWords.put(word, 1); //first occurance of this word
            } else {
                countWord = listOfWords.get(word) + 1; //get current count and increment
                //now put the new value back in the HashMap
                listOfWords.remove(word); //first remove it (can't have duplicate keys)
                listOfWords.put(word, countWord); //now put it back with new value
            }
        }
        return listOfWords; //return the HashMap you made of distinct words
    }

    public static int getWordCount(HashMap<String, Integer> list) {
        return list.size();
    }

    //get the frequency of the given word
    public static int getFrequencyForWord(String word, HashMap<String, Integer> list) {
        return list.get(word);
    }


}
