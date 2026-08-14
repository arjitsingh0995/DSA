// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         int n1 = p.length();
//         int n2 = s.length();
//         int freq1[] = new int[26];
//         int freq2[] = new int[26];
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i = 0; i<n1 ; i++){
//             freq1[p.charAt(i)-'a']++;
//             freq2[s.charAt(i)-'a']++;
//         }
//         if(Arrays.equals(freq1,freq2)) list.add(0);
//         for(int start = n1 ; start<n2 ; start++){
//             freq2[s.charAt(start) - 'a']++;
//             freq2[s.charAt(start - n1) - 'a']--;
//             if (Arrays.equals(freq1, freq2)) {
//                 list.add(start-n1+1);
//             }
//         }
//         return list;
//     }
// }
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int n1 = p.length();
        int n2 = s.length();

        List<Integer> list = new ArrayList<>();

        // If pattern is bigger than string
        if (n1 > n2) {
            return list;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of p
        // Frequency of first window of s
        for (int i = 0; i < n1; i++) {
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(freq1, freq2)) {
            list.add(0);
        }

        // Slide the window
        for (int start = n1; start < n2; start++) {

            // Add new character
            freq2[s.charAt(start) - 'a']++;

            // Remove old character
            freq2[s.charAt(start - n1) - 'a']--;

            // Check current window
            if (Arrays.equals(freq1, freq2)) {
                list.add(start - n1 + 1);
            }
        }

        return list;
    }
}