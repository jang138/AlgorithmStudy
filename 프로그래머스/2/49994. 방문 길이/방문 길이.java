import java.util.*;
class Solution {
    public int solution(String dirs) {
		int x = 5;
		int y = 5;
		
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			char command = dirs.charAt(i);

			int nx = x;
			int ny = y;

			switch (command) {
			case 'U':
				ny += 1;
				break;

			case 'D':
				ny -= 1;
				break;

			case 'R':
				nx += 1;
				break;

			case 'L':
				nx -= 1;
				break;
			}

			if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11)
				continue;
				
			set.add(String.format("(%d, %d) -> (%d, %d)", x, y, nx, ny));
			set.add(String.format("(%d, %d) -> (%d, %d)", nx, ny, x, y));
			
//			System.out.println(String.format("(%d, %d) -> (%d, %d)", x, y, nx, ny));
//			System.out.println(String.format("(%d, %d) -> (%d, %d)", nx, ny, x, y));

			x = nx;
			y = ny;
		}
		
		return set.size() / 2;
	}
}