package Daily_Question;

import java.util.ArrayList;

public class Palindrome_Number {
	 public boolean isPalindrome(int x) {
	      ArrayList<Integer> arr=new ArrayList<Integer>();
	      if(x<0){
	        return false;
	      }
	    	       for(int i=0;x>0;i++){
	    	           arr.add(x%10);
	    	           x=x/10;
	    	       }
	    	       boolean flag=true;
	    	       int a=arr.size()-1;
	    	       
	    	       for(int j=0;j<arr.size()/2;j++){
	    	        if(arr.get(j)!=arr.get(a)){
	    	            flag=false;
	    	            break;
	    	        }
	    	        a--;
	    	       }
	               return flag;

	    }
}
