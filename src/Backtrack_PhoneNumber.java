import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Backtrack_PhoneNumber {
    Map<Character, String> digitToChar = Map.of('2', "abc", '3', "def", '4'
            , "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans  = new ArrayList<>();
        String cur = "";
        backtrack(digits, ans, cur, 0);
        return ans;
    }

    public void backtrack (String digits, List<String> ans, String currString, int index) {
        if (currString.length() == digits.length()) {
            ans.add(currString);
            return;
        } else if (index == digits.length()) {
            return;
        } else {
            String buttonLetters = digitToChar.get(digits.charAt(index));
            for (char c : buttonLetters.toCharArray()) {
                backtrack(digits, ans, currString + c, index + 1);
            }
        }
    }


    public List<String> getPermutations(String digits) {
        char digit = digits.charAt(0);
        if (digits.length() == 1) {
            String digitLetters = digitToChar.get(digit);
            List<String> buttonLetters = new ArrayList<>();
            for (int i = 0; i < digitLetters.length(); i ++) {
                buttonLetters.add(String.valueOf(digitLetters.charAt(i)));
            }
            return buttonLetters;
        }
        List<String> result  = new ArrayList<>();
        for (int i = 0; i < digitToChar.get(digit).length(); i ++) {
            String prependChar = String.valueOf(digitToChar.get(digit).charAt(i));
            List<String> permutations = getPermutations(digits.substring(1, digits.length()));
            for (String perm : permutations) {
                result.add(prependChar + perm);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Backtrack_PhoneNumber a1 = new Backtrack_PhoneNumber();
//        for (String combo : a1.letterCombinations("23")) {
//            System.out.println(combo);
//        }
        for (String combo : a1.getPermutations("23")) {
            System.out.println(combo);
        }
    }
}
