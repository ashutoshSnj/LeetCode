package Daily_Question;

public class Four_Divisors {

    public static void main(String[] args) {
    	int [] nums= {21,4,3};
        int result=0;
        int count=0;
        int finalResult=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
              for(int j=1;j<=num;j++){
                if(num%j==0){
                    count++;
                    result=result+nums[i];
                }
              }
              if(count<=4){
            	  System.out.println(result);
               finalResult=result;
              }
              else{
                result=0;
              }
        }
       System.out.println(finalResult);
    }
}