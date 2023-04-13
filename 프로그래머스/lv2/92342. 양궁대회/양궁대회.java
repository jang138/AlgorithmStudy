import java.util.*;

class Solution {
    int[] appeach,ryan;
    int n,max;
    
     // 가장 낮은점수를 많이 맞춘 경우가 우선
    Queue<int[]> answer = new PriorityQueue<>((o1, o2) -> {    
        for (int i = 10; i >= 0; i--)
            if (o1[i] != o2[i]) return o2[i] - o1[i];
        return 0;
    });

    
    public int[] solution(int n, int[] info) {
        init(n, info);
        
        dfs(0,0);
        
        if(answer.isEmpty())
            return new int[]{-1};
        
        return answer.poll();
    }
    
    private void init(int n, int[] info) {
        this.appeach = info.clone();
        this.ryan = new int[11];
        this.n = n;
        this.max=-1;
    }
    
    public void dfs(int cur,int depth){

        if(depth == n){
            // 정산

            int appeachSum=0,ryanSum=0;
            for(int i=0;i<=10;i++){
                if(appeach[i] < ryan[i]) ryanSum+=10-i;
                else if(appeach[i]!=0) appeachSum+=10-i;
            }

            // 라이언이 못 이기는 경우 or 현재까지 라이언의 점수합보다 낮은 경우
            if(ryanSum<=appeachSum || ryanSum-appeachSum < max)
                return;

            if (ryanSum - appeachSum > max) {
                max = ryanSum - appeachSum;
                answer.clear(); // max가 갱신되면 큐 클리어
            }
            answer.add(ryan.clone());
            return;
        }

        for(int next=cur; next <= 10; next++){
            ryan[next]++;
            dfs(next, depth+1);
            ryan[next]--;
        }
    }
}