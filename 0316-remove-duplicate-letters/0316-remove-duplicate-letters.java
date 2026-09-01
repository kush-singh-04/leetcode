class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] visited = new boolean[26];
        int[] lastindex = new int[26];
        for(int i=0;i<n;i++){
            lastindex[s.charAt(i)-'a']=i;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
           int c = s.charAt(i)-'a';
           if(visited[c]) continue;
           visited[c]=true;
           while(!stack.isEmpty()&&stack.peek()>c&&lastindex[stack.peek()]>i){
             
                int x = stack.pop();
                visited[x] = false;
            }
            stack.push(c);

        }
        StringBuilder ans = new StringBuilder();
        for(int l: stack){
            ans.append((char)(l+'a'));
        }
        return ans.toString();

        
    }
}