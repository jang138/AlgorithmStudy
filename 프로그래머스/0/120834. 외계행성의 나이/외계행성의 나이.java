class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String strAge = String.valueOf(age);
        for(int i = 0; i < strAge.length(); i++){
            int toInt = (int)strAge.charAt(i) + 49;
            sb.append((char)toInt);
        }
        
        return sb.toString();
    }
}