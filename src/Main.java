import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 1, 1, 50, 2, 6, 3, 4, 8, 4, 5, 5, 6, 7));
        List<String> words = new ArrayList<>(List.of("Mebel", "Dom", "Rabota", "Kotyata", "Mashina", "Mebel", "Mebel", "Rabota", "Rabota"));
        printOnlyOdd(nums);
        System.out.println();
        printOnlyEven(nums);
        System.out.println();
        printUniqueWords(words);
        System.out.println(countDubles(words));
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

    public static int countDubles(List<String> words) {
        String tmpWord;
        int dubles = 0;
        for (int i = 0; i < words.size(); i++) {
            tmpWord = words.get(i);
            words.remove(i);
            if(words.contains(tmpWord)) {
               dubles++;
            }
            words.add(i, tmpWord);
        }
        return dubles;
    }
}