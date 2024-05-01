class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int result = n - m;
        
        if(ineq.equals(">") && eq.equals("=")){
            if(result >= 0)
                return 1;
            else
                return 0;
        } else if(ineq.equals("<") && eq.equals("=")){
            if(result <= 0)
                return 1;
            else
                return 0;
        } else if(ineq.equals(">") && eq.equals("!")){
            if(result > 0)
                return 1;
            else
                return 0;
        } else {
            if(result < 0)
                return 1;
            else
                return 0;
        }
            
    }
}