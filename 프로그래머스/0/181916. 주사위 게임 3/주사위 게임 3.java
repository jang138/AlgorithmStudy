import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        
        // 4 same
        if(a == b && b == c && c == d){
            p = a;
            answer = 1111 * p;
        } 
        // 3 same
        else if (a == b && b == c && c != d){
            p = a;
            q = d;
            answer = (int) Math.pow(10 * p + q, 2);
        } else if (a == b && b == d && d != c){
            p = a;
            q = c;
            answer = (int) Math.pow(10 * p + q, 2);
        } else if (a == c && c == d && c != b){
            p = a;
            q = b;
            answer = (int) Math.pow(10 * p + q, 2);
        } else if (b == c && c == d && b != a){
            p = b;
            q = a;
            answer = (int) Math.pow(10 * p + q, 2);
        }
        // 2-2 same
        else if (a == b && c == d){
            p = a;
            q = c;
            answer = (p + q) * Math.abs(p - q);
        } else if (a == c && b == d){
            p = a;
            q = b;
            answer = (p + q) * Math.abs(p - q);
        } else if (a == d && b == c){
            p = a;
            q = b;
            answer = (p + q) * Math.abs(p - q);
        }
        // 2 same
        else if (a == b && c != d){
            q = c;
            r = d;
            answer = q * r;
        } else if (a == c && b != d){
            q = b;
            r = d;
            answer = q * r;
        } else if (a == d && b != c){
            q = b;
            r = c;
            answer = q * r;
        } else if (b == c && a != d){
            q = a;
            r = d;
            answer = q * r;
        } else if (b == d && a != c){
            q = a;
            r = c;
            answer = q * r;
        } else if (c == d && a != b){
            q = a;
            r = b;
            answer = q * r;
        }
        // all different
        else {
            answer = Math.min( Math.min(a, b), Math.min(c, d) );
        }
            
        return answer;
    }
}