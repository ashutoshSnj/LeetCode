package Daily_Question;
import java.util.*;
public class Design_Movie_Rental_System {
    
    private Map<Integer, TreeSet<int[]>> available;

    private TreeSet<int[]> rented;
 
    private Map<String, Integer> priceMap;

    public  Design_Movie_Rental_System(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; 
            if (a[0] != b[0]) return a[0] - b[0]; 
            return a[1] - b[1]; 
        });
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "-" + movie, price);
            available.putIfAbsent(movie, new TreeSet<>((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                return a[0] - b[0]; 
            }));
            available.get(movie).add(new int[]{shop, price});
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        TreeSet<int[]> set = available.get(movie);
        int count = 0;
        for (int[] info : set) {
            res.add(info[0]);
            if (++count == 5) break; 
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "-" + movie);
        available.get(movie).remove(new int[]{shop, price});
        rented.add(new int[]{shop, movie, price});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "-" + movie);
        rented.remove(new int[]{shop, movie, price});
        available.get(movie).add(new int[]{shop, price});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] info : rented) {
            res.add(Arrays.asList(info[0], info[1]));
            if (++count == 5) break; 
        }
        return res;
    }
}

