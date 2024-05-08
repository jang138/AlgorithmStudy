class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int lcm = denom1 * denom2 / gcd(denom1, denom2);
        System.out.println(lcm);
        
        answer[0] = numer1 * (lcm / denom1) + numer2 * (lcm / denom2);
        answer[1] = lcm;
        
        int abb = gcd(answer[0], answer[1]);
        answer[0] = answer[0] / abb;
        answer[1] = answer[1] / abb;
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