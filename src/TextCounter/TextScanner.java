package TextCounter;

import java.util.*;

public class TextScanner {

    public static void main(String[] args) {
        String inputText = "стою на асфальте на в лыжи обутый, то ли лыжи не едут, то ли я перегрелся на";
        System.out.println("Input text:\n"+inputText);
        int numWordInText = getWordCount(makeWordList(inputText));
        System.out.println("Количество уникальных слов в тексте = " + numWordInText);
        System.out.println("Частотное распределение слов в тексте :");
        System.out.println("кол-во \t слово ");
        for (HashMap.Entry<String, Integer> anyWord : makeWordList(inputText).entrySet()) {
            System.out.println("   " + anyWord.getValue() + "\t " + anyWord.getKey());
        }
// TreeMap – использующий String ключи и компаратор (Comparator) CASE_INSENSITIVE_ORDER,
// упорядочивающий строки (String) методом compareToIgnoreCase
        Map<String, Integer> sortedMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(makeWordList(inputText));
        System.out.println("\nПосле сортировки по алфавиту:");
        System.out.println("кол-во \t слово ");
        int maxRepeat = 1;
        for (HashMap.Entry<String, Integer> anyWord : sortedMap.entrySet()) {
            System.out.println("   " + anyWord.getValue() + "\t " + anyWord.getKey());
            if (anyWord.getValue() > maxRepeat) maxRepeat = anyWord.getValue();
        }
        System.out.println("maxRepeat = "+maxRepeat);
        System.out.println("\nВыводим ТОП-10 по частоте повторений:");
        int count10 = 0;
        for (int i=maxRepeat; i>0;i--){
            for (HashMap.Entry<String, Integer> anyWord : sortedMap.entrySet()) {
                if (anyWord.getValue() == i){
                count10++;
                System.out.println("   " + anyWord.getValue() + "\t " + anyWord.getKey());
        } if (count10 == 10 || count10 == numWordInText) break;
        }
    }}

    /*
    public ArrayList<String> makeWordList(){
        Scanner scan = new Scanner(yourTextFileOrOtherTypeOfInput);
        ArrayList<String> listOfWords = new ArrayList<String>();

           String word = scan.next(); //scanner automatically uses " " as a delimeter
    */
    public static HashMap<String, Integer> makeWordList(String inputText) {
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

}