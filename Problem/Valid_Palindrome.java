package Problem;

public class Valid_Palindrome {
  public static void main(String[] args) {
	  boolean flag=true;
	  String str="A man, a plan, a canal: Panama";
	  StringBuffer str2=new StringBuffer();
	  for(int i=0;i<str.length();i++) {
		  if(Character.isLetter(str.charAt(i))) {
			char ch=Character.toLowerCase(str.charAt(i));
			str2.append(ch);
		  }
		  
	  }
	  int j=str2.length()-1;
	  for(int i=0;i<str2.length()/2;i++) {
		if(str2.charAt(i)!=str2.charAt(j)) {
			flag=false;
			break;
		}
		j--;
	  }
	  System.out.println(flag);
	  System.out.println(str2);
}
}
