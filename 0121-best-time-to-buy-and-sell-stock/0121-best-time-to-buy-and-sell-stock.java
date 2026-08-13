class Solution {
    public int maxProfit(int[] prices) {
        int left =0;
        int maxprofit = 0;
        for(int right =1;right<prices.length;right++){
            if(prices[right]<prices[left]){
                left=right;
            }
            else{
                maxprofit = Math.max(maxprofit,prices[right]-prices[left]);
            }
        }
        return maxprofit;
    }
}