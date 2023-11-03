import java.util.*;

class Solution {
    int n;
    int m;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    // int[][] draw;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        // draw = new int[n][m];
        
        int answer = bfs(maps, visited);
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.printf("%-3d", draw[i][j]);
        //     }
        //     System.out.println();
        // }
    
        return answer;
    }
    
    public int bfs(int[][] maps, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            // draw[now[0]][now[1]] = now[2];
            
            if(now[0] == (n-1) && now[1] == (m-1)){
                return now[2];
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                
                if(maps[nx][ny] == 0 || visited[nx][ny]){
                    continue;
                }
                
                queue.offer(new int[] {nx, ny, now[2] + 1});
                visited[nx][ny] = true;
                
            }
        }
        
        return -1;
    }
}