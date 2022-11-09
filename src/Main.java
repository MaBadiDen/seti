import java.util.*;

public class Main {



    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 1, 1, 50, 2, 6, 3, 4, 8, 4, 5, 5, 6, 7));
        List<String> words = new ArrayList<>(List.of( "Mebel", "Dom", "Rabota", "Kotyata","Mebel", "Mashina", "Mebel", "Mebel", "Mebel", "Rabota", "Rabota", "doch", "Mebel"));
        printOnlyOdd(nums);
        System.out.println();
        printOnlyEven(nums);
        System.out.println();
        printUniqueWords(words);
        printNewDubles(words);
    }

    public static void printOnlyOdd(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
    }

    public static void printOnlyEven(List<Integer> nums) {
        List<Integer> newNums = new ArrayList<>();
        for (Integer num : nums) {
            if (!newNums.contains(num) && num % 2 == 0) {
                newNums.add(num);
            }
        }
        Collections.sort(newNums);
        for (Integer newNum : newNums) {
            System.out.print(newNum + " ");
        }
    }

    public static void printUniqueWords(List<String> words) {
        String tmpWord;
        List<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            tmpWord = words.get(i);
            words.remove(i);
            if(!words.contains(tmpWord)) {
                newWords.add(tmpWord);
            }
            words.add(i, tmpWord);
        }
        System.out.println(newWords);
    }

    /*public static void printDubles(List<String> words) {
        String tmpWord;
        HashMap<String, Integer> dublesWords = new HashMap();
        Set<String> duble = new HashSet<>();
        for (int i = 0; i < words.size(); i++) {
            tmpWord = words.get(i);
            words.remove(i);
            if(words.contains(tmpWord)) {
                if(!duble.contains(tmpWord)){
                    duble.add(tmpWord);
                    words.add(tmpWord);
                    dublesWords.put(tmpWord, 1);
                } else {
                    words.add(tmpWord);
                    int tmp = dublesWords.get(tmpWord);
                    dublesWords.remove(tmpWord);
                    dublesWords.put(tmpWord, ++tmp);

                }

            }

        }
    }*/

    public static void printNewDubles(List<String> words) {
        Collections.sort(words);
        int dubles = 1;
        HashMap<String, Integer> dublesWords = new HashMap<>();
        for (int i = words.size(); i > 1; i--) {
            while(words.get(i - 1).equals(words.get(i - 2))){
                dubles++;
                i--;
            }
            if(dubles != 1) {
                dublesWords.put(words.get(i - 1), dubles);
            }
            dubles = 1;
        }
        System.out.println(dublesWords);
    }
}