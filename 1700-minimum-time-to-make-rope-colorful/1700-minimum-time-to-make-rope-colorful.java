class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();

        for (int i = 1; i < n; i++) {
            // If two adjacent balloons have the same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Remove the one with smaller removal time
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Keep the larger time value for the next comparison
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    }
}
