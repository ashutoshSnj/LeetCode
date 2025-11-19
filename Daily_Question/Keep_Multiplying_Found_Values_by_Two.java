package Daily_Question;

public class Keep_Multiplying_Found_Values_by_Two {
    public int findFinalValue(int[] nums, int original) {
        int len=nums.length;
  int i=0;
        while(len!=i){ 
     for(i=0;i<nums.length;i++){
        if(nums[i]== original ){
            original=original*2;
            break;

        }
     }
        }
        return original;
        }
    }
