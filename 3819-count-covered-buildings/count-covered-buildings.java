class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // row[x] -> all y in this row
        Map<Integer, List<Integer>> row = new HashMap<>();
        // col[y] -> all x in this column
        Map<Integer, List<Integer>> col = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            row.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            col.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        // sort all coordinate lists
        for (List<Integer> ys : row.values()) {
            Collections.sort(ys);
        }
        for (List<Integer> xs : col.values()) {
            Collections.sort(xs);
        }

        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> ys = row.get(x);
            List<Integer> xs = col.get(y);

            // need at least 3 buildings in this row and column
            if (ys.size() < 3 || xs.size() < 3) continue;

            int minY = ys.get(0), maxY = ys.get(ys.size() - 1);
            int minX = xs.get(0), maxX = xs.get(xs.size() - 1);

            if (minY < y && y < maxY && minX < x && x < maxX) {
                covered++;
            }
        }

        return covered;
    }
}
