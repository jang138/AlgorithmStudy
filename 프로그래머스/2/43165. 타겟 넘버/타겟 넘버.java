import java.util.*;

class Solution {
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return count;
    }
    
    public void dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        dfs(depth + 1, sum += numbers[depth], numbers, target);
        sum -= numbers[depth];
        
        dfs(depth + 1, sum -= numbers[depth], numbers, target);
        sum += numbers[depth];
    }
}