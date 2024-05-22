class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int start = Math.min(lines[0][0], Math.min(lines[1][0], lines[2][0]));
        int end = Math.max(lines[0][1], Math.max(lines[1][1], lines[2][1]));
        
        System.out.println(start + " "  +end);
        
        boolean first = false;
        boolean second = false;
        boolean third = false;
        
        for(int i = -100; i <= 100; i++){
            if(i >= lines[0][0] && i < lines[0][1])
                first = true;
            else
                first = false;
            
            if(i >= lines[1][0] && i < lines[1][1])
                second = true;
            else
                second = false;
            
            if(i >= lines[2][0] && i < lines[2][1])
                third = true;
            else
                third = false;
            
            if( (first && second) || (second && third) || (third && first) )
                answer++;
            
        }
        
        return answer;
    }
}