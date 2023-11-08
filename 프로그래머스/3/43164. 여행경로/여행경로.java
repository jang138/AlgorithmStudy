import java.util.*;

class Solution {
    static boolean visited[];
    static ArrayList<String> arrayList;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        arrayList = new ArrayList<>();
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(arrayList);
        
        String[] answer = arrayList.get(0).split("\\s");
        return answer;
    }
    
     static void dfs(int depth, String now, String path, String[][] tickets){
         if(depth == tickets.length){
             arrayList.add(path);
             return;
         }
                  
         for(int i = 0; i < tickets.length; i++){
             if(!visited[i] && now.equals(tickets[i][0])){
                 visited[i] = true;
                 dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                 visited[i] = false;
            }           
         }
     }
}