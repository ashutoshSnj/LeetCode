package Daily_Question;

public class Maximum_Number_of_Words_You_Can_Type {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        boolean[] broken = new boolean[26]; 
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) { 
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }
        
        return count;
    }
}
