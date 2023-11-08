import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char arr[];
    static boolean used[];
    
    public int solution(String numbers) {        
        arr = numbers.toCharArray();
        used = new boolean[numbers.length()];
        
        dfs(0, "");
        
        return set.size();
    }
    
    public void dfs(int depth, String str){
        if(!str.equals("")){
            int num = Integer.parseInt(str);
            if(isPrime(num)){
                set.add(num);
            } 
        }
        
        if(depth == arr.length) return;
        
        for(int i = 0; i < arr.length; i++){
            if(used[i]) continue; // 방문한 노드면 넘어감
            
            used[i] = true; // 방문
            
            dfs(depth + 1, str + arr[i]); // 방문 했을 시 재귀
            
            used[i] = false; // 백트래킹
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
                
        return true;
    }
}