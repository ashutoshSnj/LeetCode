package Daily_Question;
import java.util.*;
public class Lexicographically_Smallest_String_After_Applying_Operations {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        visited.add(s);
        String smallest = s;
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                int newDigit = (chars[i] - '0' + a) % 10;
                chars[i] = (char) (newDigit + '0');
            }
            String added = new String(chars);
            if (visited.add(added)) {
                queue.offer(added);
            }
            
           
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }
        return smallest;
    }
}
