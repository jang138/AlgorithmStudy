class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int lcm = denom1 * denom2 / gcd(denom1, denom2);
        System.out.println(lcm);
        
        int numerator = numer1 * (lcm / denom1) + numer2 * (lcm / denom2);
        int denominator = lcm;
        
        int abb = gcd(numerator, denominator);
        answer[0] = numerator / abb;
        answer[1] = denominator / abb;
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}