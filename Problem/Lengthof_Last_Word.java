package Problem;

public class Lengthof_Last_Word {
    public int lengthOfLastWord(String s) {
     int len=s.length()-1;
     int count=0;
     while(len>=0 && s.charAt(len)==' ' ){
        len--;
     }
    while(len>=0 && s.charAt(len)!=' '){
        count++;
        len--;
    }
    return count;
}
}