package Daily_Question;

public class Sort_Vowels_in_a_String {

    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder(s);
        
      
        java.util.List<Character> vowelList = new java.util.ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {  
                vowelList.add(ch);
            }
        }
        java.util.Collections.sort(vowelList);
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                result.setCharAt(i, vowelList.get(index++));
            }
        }
        
        return result.toString();
    }
}
