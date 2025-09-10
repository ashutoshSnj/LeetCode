package Daily_Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minimum_Number_of_People_to_Teach {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; 
        List<Set<Integer>> userLang = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) {
                set.add(lang);
            }
            userLang.add(set);
        }
        Set<Integer> needTeachingUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; 
            int v = f[1] - 1;
            boolean canTalk = false;
            for (int lang : userLang.get(u)) {
                if (userLang.get(v).contains(lang)) {
                    canTalk = true;
                    break;
                }
            }

            if (!canTalk) {
                needTeachingUsers.add(u);
                needTeachingUsers.add(v);
            }
        }
        if (needTeachingUsers.isEmpty()) return 0;
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : needTeachingUsers) {
                if (!userLang.get(user).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }

        return minTeach;
    }
}
