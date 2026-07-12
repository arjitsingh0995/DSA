class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newarr = arr.clone();

        Arrays.sort(newarr);
        int currrank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : newarr){
            if(!map.containsKey(n)){
                map.put(n,currrank++);
            }
        }
        for(int i =0 ; i<arr.length; i++){
            arr[i]= map.get(arr[i]);
        }
        return arr;
    }
}