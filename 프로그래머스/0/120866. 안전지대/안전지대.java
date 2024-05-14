class Solution {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        boolean[][] map = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 1){
                    map[i][j] = true;
                    
                    for(int d = 0; d < 8; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;
                        
                        if(map[nx][ny])
                            continue;
                        
                        map[nx][ny] = true;
                    }
                }
            }
            
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!map[i][j])
                    answer++;
            }
        }
        return answer;
    }
}