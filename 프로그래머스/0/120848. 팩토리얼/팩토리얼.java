class Solution {
    public int solution(int n) {
        int fac = 1;
        int count = 1;
        
        while(fac <= n)
            fac *= ++count;
        
        return count - 1;
    }
}