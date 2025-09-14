package Daily_Question;
import java.util.*;


public class Vowel_Spellchecker {

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();


        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devow = devowel(lower);
            vowelMap.putIfAbsent(devow, word);
        }

      
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactWords.contains(q)) {
                result[i] = q;
            } else if (caseMap.containsKey(q.toLowerCase())) {
                result[i] = caseMap.get(q.toLowerCase());
            } else if (vowelMap.containsKey(devowel(q.toLowerCase()))) {
                result[i] = vowelMap.get(devowel(q.toLowerCase()));
            } else {
                result[i] = "";
            }
        }
        return result;
    }
}
