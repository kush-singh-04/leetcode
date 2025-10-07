 import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        Map<Integer, Integer> lakeLastRain = new HashMap<>();
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                // It's raining on this lake
                if (lakeLastRain.containsKey(lake)) {
                    int lastRainDay = lakeLastRain.get(lake);
                    // find a sunny day after lastRainDay to dry this lake
                    Integer dryDay = sunnyDays.higher(lastRainDay);
                    if (dryDay == null) {
                        // no available sunny day to dry — flood unavoidable
                        return new int[0];
                    }
                    ans[dryDay] = lake;
                    sunnyDays.remove(dryDay);
                }
                lakeLastRain.put(lake, i);
                ans[i] = -1;
            } else {
                // Sunny day — can dry some lake
                sunnyDays.add(i);
                // temporary placeholder, may get overwritten
                ans[i] = 1;
            }
        }
        
        // For leftover sunny days not used, set them to 1 (or any lake)
        for (int day : sunnyDays) {
            ans[day] = 1;
        }
        
        return ans;
    }
}
