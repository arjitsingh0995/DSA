class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int apples : apple) {
            totalApples += apples;
        }
        
        // Sort capacities in descending order (largest first)
        Integer[] cap = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            cap[i] = capacity[i];
        }
        Arrays.sort(cap, Collections.reverseOrder());
        
        int boxesUsed = 0;
        for (int boxCap : cap) {
            totalApples -= boxCap;
            boxesUsed++;
            if (totalApples <= 0) {
                return boxesUsed;
            }
        }
        
        // Guaranteed to be possible per constraints
        return boxesUsed;
    }
}
