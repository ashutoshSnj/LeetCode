package Problem;

public class Longest_Substring_Without_Repeating_Characters {
public static void main(String[] args) {
	  int count=0;
      int result=0;
      String s="ashutosh";
      for(int i=0;i<s.length();i++){
          for(int j=i+1;j<s.length();j++){
              if(s.charAt(i)==s.charAt(j)){
                  if(count>result){
                      result=count;  
                  } 
                  count=0;
                  break;     
              }
              count++;
          }
      }
      System.out.println(count);
}
}
