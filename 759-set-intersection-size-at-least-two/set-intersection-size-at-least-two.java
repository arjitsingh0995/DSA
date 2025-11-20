// import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Step 1: Sort by end ascending, and if tie, by start descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        // p1 = second last chosen, p2 = last chosen
        int p1 = -1, p2 = -1;
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0];
            int end = in[1];

            boolean hasP1 = (p1 >= start && p1 <= end);
            boolean hasP2 = (p2 >= start && p2 <= end);

            if (hasP1 && hasP2) {
                continue; // already have 2 numbers inside this interval
            } 
            else if (hasP2) {
                // We have only one, add one more number: end
                p1 = p2;
                p2 = end;
                count++;
            } 
            else {
                // We have zero inside → need 2 new numbers
                p1 = end - 1;
                p2 = end;
                count += 2;
            }
        }

        return count;
    }
}
