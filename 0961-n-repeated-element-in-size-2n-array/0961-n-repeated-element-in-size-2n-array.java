class Solution {
    public int repeatedNTimes(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr){
                if(map.containsKey(ele)){
                    int freq = map.get(ele);
                    map.put(ele,freq+1);
                }
                else map.put(ele,1);
            }
            int max = 0;
            int ans = -1;
            for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > max) {
                max = freq;
                ans = key;
            }
        }
        return ans;
             
    }
}