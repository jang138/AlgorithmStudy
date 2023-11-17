class Solution {
    static int[] board;
    static int count = 0;
    
    public int solution(int n) {
        board = new int[n];
        
        backTracking(0, n);
        
        return count;
    }
    
    public void backTracking(int depth, int n){
        if(depth == n){
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            board[depth] = i;
            
            if(queen(depth)){
                backTracking(depth + 1, n);
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