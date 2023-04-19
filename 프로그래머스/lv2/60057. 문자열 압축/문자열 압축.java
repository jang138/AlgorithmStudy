class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 1 ~ 길이의 절반 만큼 자른다
        for(int i = 1; i <= s.length() / 2; i++){
            String prev = s.substring(0, i);
            int count = 1;
            
            String enc = "";
            String last = "";
            
            for (int j = i; j < s.length(); j += i) {                
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                
                // 다음 문자와 같다면 증가
                if (prev.equals(s.substring(j, j + i))) {
                    count++;
                }
                // 다른 경우 그냥 추가
                else {
                    enc += prev;
                    
                    // 압축이 된 경우 숫자와 함께 추가
                    if (count != 1) {
                        enc = count + enc;
                    }
                    prev = s.substring(j, j + i);
                    count = 1;
                }
            }
            
            enc += prev + last;
            if (count != 1) {
                enc = count + enc;
            } 
            
            answer = Math.min(answer, enc.length());
        }
        
        return answer;
    }
}