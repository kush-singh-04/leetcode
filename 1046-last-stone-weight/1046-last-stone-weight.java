class Solution {
    public int lastStoneWeight(int[] stones) {
         
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

         
        for (int s : stones) {
            pq.add(s);
        }

         
        while (pq.size() > 1) {
            int first = pq.poll(); 
            int second = pq.poll();   

            if (first != second) {
                pq.add(first - second);
            }
        }

         
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
