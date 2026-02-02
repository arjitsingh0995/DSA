class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (mat[a][b] == 1) {
                st.push(b);  // a knows b: discard a
            } else {
                st.push(a);  // a doesn't know b: discard b
            }
        }
        if (st.isEmpty()) return -1;
        int celeb = st.pop();
        
        // Verify: celeb knows no one else; everyone else knows celeb
        for (int j = 0; j < n; j++) {
            if (j == celeb) continue;
            if (mat[celeb][j] == 1 || mat[j][celeb] == 0) return -1;
        }
        return celeb;
    }
}
