class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n - 1;

        // Skip left-moving cars at the start (no collision)
        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        // Skip right-moving cars at the end (no collision)
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        int collisions = 0;

        // Count all moving cars in the middle segment
        for (int k = i; k <= j; k++) {
            char c = directions.charAt(k);
            if (c != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
