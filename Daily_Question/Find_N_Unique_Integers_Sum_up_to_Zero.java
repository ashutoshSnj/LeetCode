package Daily_Question;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Find_N_Unique_Integers_Sum_up_to_Zero {
public static void main(String[] args) {
	 sumZero(5);
}

    public  static int[] sumZero(int n) {
        int [] arr=new int[n];
      int ind=0;
    for(int i=1;i<=n/2;i++){
        arr[ind++]=i;
        arr[ind++]=-i;   

    }
      
    Arrays.stream(arr).forEach(ref->System.out.println(ref));
    return arr;
}
}