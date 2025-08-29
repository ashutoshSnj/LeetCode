package Daily_Question;

public class Alice_and_Bob_Playing_Flower_Game {


    public long flowerGame(int n, int m) {
        long oddX = (n+1)/2;   
        long evenX = n/2;        
        long oddY = (m+1)/2;   
        long evenY = m/2;        
        
        return oddX*evenY+ evenX * oddY;
    }
}
