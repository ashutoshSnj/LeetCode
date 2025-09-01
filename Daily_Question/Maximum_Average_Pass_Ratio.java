package Daily_Question;
import java.util.*;
public class Maximum_Average_Pass_Ratio {





    public double maxAverageRatio(int[][] classes, int extraStudents) {
       
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        
        for (int[] c : classes) {
            double pass = c[0], total = c[1];
            double gain = ((pass + 1) / (total + 1)) - (pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

    
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double gain = ((pass + 1) / (total + 1)) - (pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

       
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }

        return sum / classes.length;
    }
}
