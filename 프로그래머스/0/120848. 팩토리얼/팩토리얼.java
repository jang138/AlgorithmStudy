class Solution {
    public int solution(int n) {
        int l = 1;
        int count = 0;
        int fact = 1;
        
        while(fact <= n){
            l++;
            fact *= l;
            count++;
        }
        
        return count;
    }
}