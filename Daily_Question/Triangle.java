package Daily_Question;
import java.util.List;
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                int down = triangle.get(row + 1).get(col);
                int diagonal = triangle.get(row + 1).get(col + 1);
                int current = triangle.get(row).get(col);
                triangle.get(row).set(col, current + Math.min(down, diagonal));
            }
        }
        return triangle.get(0).get(0);
    }
}
