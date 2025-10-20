package Daily_Question;

public class Final_Value_of_Variable_After_Performing_Operations {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String op : operations) {
            if (op.contains("++")) {
                X++;
            } else {
                X--;
            }
        }
        return X;
    }
}
