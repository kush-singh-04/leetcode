class Solution {
    public class pair implements Comparable<pair>{
        int ele;
        int freq;
        pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }
        @Override
        public int compareTo(pair p){
            if(this.freq == p.freq){
                return p.ele - this.ele; 
            }
            return this.freq - p.freq;
        }
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
           if(map.containsKey(ele)){
              int freq = map.get(ele);
              map.put(ele,freq+1);
           }
           else map.put(ele,1);
        }
         

        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int ele: map.keySet()){
            int freq = map.get(ele);
            pq.add(new pair(ele,freq));
        }

        int[] ans = new int[nums.length];
        int idx = 0;

        while (!pq.isEmpty()) {
            pair p = pq.remove();
            for (int i = 0; i < p.freq; i++) {
                ans[idx++] = p.ele;
            }
        }
        return ans;
    }
}
