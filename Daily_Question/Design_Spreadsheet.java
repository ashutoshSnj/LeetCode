package Daily_Question;
import java.util.*;
public class Design_Spreadsheet {
    private Map<String, Integer> cells;

    public Design_Spreadsheet(int rows) {
    
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.put(cell, 0);
    }
    
    public int getValue(String formula) {
     
        formula = formula.substring(1); 
        String[] parts = formula.split("\\+");
        
        int val1 = evaluate(parts[0]);
        int val2 = evaluate(parts[1]);
        
        return val1 + val2;
    }
    
    private int evaluate(String part) {
      
        if (Character.isDigit(part.charAt(0))) {
            return Integer.parseInt(part);
        }
        return cells.getOrDefault(part, 0);
    }
}
