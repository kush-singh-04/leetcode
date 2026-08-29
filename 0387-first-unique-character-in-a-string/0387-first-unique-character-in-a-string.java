class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key,freq+1);
            }
            else map.put(key,1);
        }
        for(int i=0;i<s.length();i++){
           char key = s.charAt(i);
           if(map.get(key)==1){
              return i;
           }
        }
        return -1;
    }
}