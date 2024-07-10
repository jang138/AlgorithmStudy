class Solution {
    public String solution(String my_string, String letter) {
        char cletter = letter.charAt(0);
        StringBuilder sb = new StringBuilder();
        char[] charArray = my_string.toCharArray();
        
        for(char c : charArray){
            if(c == cletter)
                continue;
            sb.append(c);
        }
        
        return sb.toString();
    }
}