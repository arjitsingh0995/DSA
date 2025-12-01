class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // total energy
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }

        // sort to handle largest batteries
        Arrays.sort(batteries);

        int i = batteries.length - 1;
        // while the largest battery is greater than current average time
        while (i >= 0 && batteries[i] > sum / n) {
            sum -= batteries[i]; // remove this battery's energy
            i--;                 // move to next largest
            n--;                 // one computer is effectively handled by this big battery
        }

        // remaining batteries can be evenly used
        return sum / n;
    }
}
