import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial);
        int first = 0;
		int constant = 0;
        
		while (st.hasMoreTokens()) {
			String target = st.nextToken();

			if (target.equals("+"))
				continue;

			if (target.charAt(target.length() - 1) == 'x') {
				if (target.length() == 1)
					first += 1;
				else {
					String subNumber = target.substring(0, target.length() - 1);
					first += Integer.parseInt(subNumber);
				}

			} else
				constant += Integer.parseInt(target);
		}
        
        System.out.println(first + " " + constant);
        
        if(first == 0)
            return String.valueOf(constant);
        if(first == 1){
            if(constant == 0)
                return "x";
            else
                return "x + " + constant;
        } else {
            if(constant == 0)
                return first + "x";
            else
                return first + "x + " + constant;            
        }

    }
}