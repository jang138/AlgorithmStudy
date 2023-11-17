import java.util.*;

class Solution {
    static int N;
    static int[] board;
    static int count = 0;
    
    public int solution(int n) {
        board = new int[n];
        N = n;
        
        backTracking(0);
        
        return count;
    }
    
    public void backTracking(int depth){
        if(depth == N){
            count++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            board[depth] = i;
            
            if(queen(depth)){
                backTracking(depth + 1);
            }
        }
        
    }
    
    public boolean queen(int d){
        for(int i = 0; i < d; i++){
            if(board[i] == board[d])
                return false;
            
            if(Math.abs(i - d) == Math.abs(board[i] - board[d]))
                return false;
        }
        
        return true;
    }
}