package Daily_Question;

public class Find_Closest_Person {

    public int findClosest(int x, int y, int z) {
        int person1;
        int person2;
        if(x>z){
            person1=x-z;
        }
        else{
            person1=z-x;
        }
         if(y>z){
            person2=y-z;
        }
        else{
            person2=z-y;
        }
        if(person1>person2){
            return 2;
        }
        else if(person1==person2){
            return 0;
        }
        else{
            return 1;
        }
    }
}