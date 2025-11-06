package Daily_Question;
import java.util.*;
public class Power_Grid_Maintenance {
    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        for (int[] con : connections)
            dsu.union(con[0], con[1]);

        Map<Integer, TreeSet<Integer>> gridMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            gridMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (online[x]) result.add(x);
                else {
                    TreeSet<Integer> set = gridMap.get(root);
                    result.add(set.isEmpty() ? -1 : set.first());
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                    gridMap.get(root).remove(x);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
