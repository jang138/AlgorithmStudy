class Solution {
    public String solution(String rsp) {
        String answer = "";
        char[] rspArray = rsp.toCharArray();
        for(char c : rspArray){
            if(c == '2')
                answer += "0";
            else if(c == '0')
                answer += "5";
            else
                answer += "2";
        }
        
        return answer;
    }
}