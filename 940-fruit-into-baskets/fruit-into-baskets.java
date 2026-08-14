class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right =0 ; right < fruits.length ; right++){
            freq.put(fruits[right], freq.getOrDefault(fruits[right],0)+1);
            while (freq.size() > 2) {
                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                
                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans ;
    }
}