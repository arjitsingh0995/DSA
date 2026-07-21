import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // Step 1: Count total original '1's in s
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // Step 2: Form augmented string t = '1' + s + '1'
        String t = "1" + s + "1";

        // Step 3: Segment string t into lengths of alternating blocks
        List<Integer> lengths = new ArrayList<>();
        List<Character> types = new ArrayList<>();

        int n = t.length();
        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == ch) {
                j++;
            }
            lengths.add(j - i);
            types.add(ch);
            i = j;
        }

        // Step 4: Find maximum gain (sum of lengths of surrounding zero-blocks)
        int maxDelta = 0;
        for (int k = 1; k < types.size() - 1; k++) {
            // Check if current block is a '1'-block surrounded by '0'-blocks
            if (types.get(k) == '1' && types.get(k - 1) == '0' && types.get(k + 1) == '0') {
                int leftZeros = lengths.get(k - 1);
                int rightZeros = lengths.get(k + 1);
                maxDelta = Math.max(maxDelta, leftZeros + rightZeros);
            }
        }

        return totalOnes + maxDelta;
    }
}