import java.util.*;
class Solution {
    public class pair implements Comparable<pair>{
        int ele;
        int freq;

        pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;

        }
        @Override
        public int compareTo(pair p){
            return this.freq - p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            pq.add(new pair(ele,freq));
            if(pq.size()>k) pq.remove();
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            pair p = pq.remove();
            ans[i] = p.ele;
        }
        return ans;
         
    }
}