package Daily_Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Find_All_People_With_Secret {

    private int[] id;
    private int[] rank;

    public Find_All_People_With_Secret(int n) {
        id = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void unionByRank(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return;

        if (rank[rootU] < rank[rootV]) {
            id[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            id[rootV] = rootU;
        } else {
            id[rootU] = rootV;
            rank[rootV]++;
        }
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }

    public void reset(int u) {
        id[u] = u;
    }

    private int find(int u) {
        if (id[u] != u) {
            id[u] = find(id[u]);
        }
        return id[u];
    }
}


class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


 class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<Integer> ans = new ArrayList<>();
        Find_All_People_With_Secret uf = new Find_All_People_With_Secret(n);

        // time -> list of (x, y) meetings
        TreeMap<Integer, List<Pair<Integer, Integer>>> timeToPairs = new TreeMap<>();

        // Person 0 shares secret with firstPerson
        uf.unionByRank(0, firstPerson);

        // Group meetings by time
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];

            timeToPairs.putIfAbsent(time, new ArrayList<>());
            timeToPairs.get(time).add(new Pair<>(x, y));
        }

        // Process meetings time-wise
        for (List<Pair<Integer, Integer>> pairs : timeToPairs.values()) {

            Set<Integer> peopleUnioned = new HashSet<>();

            for (Pair<Integer, Integer> pair : pairs) {
                int x = pair.getKey();
                int y = pair.getValue();

                uf.unionByRank(x, y);
                peopleUnioned.add(x);
                peopleUnioned.add(y);
            }

            // Reset those not connected to person 0
            for (int person : peopleUnioned) {
                if (!uf.connected(person, 0)) {
                    uf.reset(person);
                }
            }
        }

        // Collect answer
        for (int i = 0; i < n; i++) {
            if (uf.connected(i, 0)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
