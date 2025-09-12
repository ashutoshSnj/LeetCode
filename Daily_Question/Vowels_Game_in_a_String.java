package Daily_Question;

public class Vowels_Game_in_a_String {

    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;  
            }
        }
        return false; 
    }
}
