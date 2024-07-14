class Solution {
    public int[][] solution(int[] num_list, int n) {
        int N = num_list.length / n;
        int M = n;
        int[][] answer = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                answer[i][j] = num_list[i * M + j];
            }
        }
        return answer;
    }
}