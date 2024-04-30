class Solution {
    public int solution(int n) {
        int answer = 0;
        String nToString = String.valueOf(n);
        System.out.println(nToString);
        
        int length = nToString.length();
        
        for(int i = 0; i < length; i++){
            answer += nToString.charAt(i) - '0';
        }
        
        return answer;
    }
}