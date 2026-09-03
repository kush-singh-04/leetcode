class Solution {
    public String frequencySort(String s) {
        int n= s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key,freq+1);
            }
            else map.put(key,1);
        }
        Character[] ch = map.keySet().toArray(new Character[0]);
        for(int i=0;i<ch.length;i++){
            for(int j=i+1;j<ch.length;j++){
                if(map.get(ch[j]) > map.get(ch[i])){

                    char temp=ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                }
            }
        }
        String result ="";
        for(char key: ch){
            int freq = map.get(key);
            for(int k=0;k<freq;k++){
                result +=key;
            }
        }
        return result;
    }
}