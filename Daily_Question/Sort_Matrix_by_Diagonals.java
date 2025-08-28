package Daily_Question;


import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

      
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> diag = entry.getValue();

            if (key >= 0) {
              
                diag.sort((a, b) -> b - a);
            } else {
                
                Collections.sort(diag);
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diag = map.get(key);
                grid[i][j] = diag.remove(0); 
            }
        }

        return grid;
    }
}
