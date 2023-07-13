public class Dynamic2D_RecursiveEditStringDistance {
    public int minDistance(String word1, String word2) {
        char[] word1a = word1.toCharArray();
        char[] word2a = word2.toCharArray();

        return minDistanceRecur( word1a, word2a, word1.length(), word2.length());
    }

    public int minDistanceRecur (char[] word1, char[] word2, int word1Index, int word2Index) {
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        if (word1[word1Index - 1] == word2[word2Index - 1]) {
            return minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
        } else {
            int insertOperation = minDistanceRecur(word1, word2, word1Index, word2Index - 1);
            int deleteOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index);
            int replaceOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
            return Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1;
        }

    }

    public static void main(String[] args) {
        Dynamic2D_RecursiveEditStringDistance a1 = new Dynamic2D_RecursiveEditStringDistance();
        System.out.println(a1.minDistance("Nauris", "NaDina"));
    }
}
