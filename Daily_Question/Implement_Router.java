package Daily_Question;
import java.util.*;
public class Implement_Router {

    private int memoryLimit;
    private Queue<int[]> queue; 
    private Set<String> seen;   
    private Map<Integer, List<Integer>> destMap; 

    public Implement_Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;

       
        if (seen.contains(key)) {
            return false;
        }
        if (queue.size() == memoryLimit) {
            int[] oldest = queue.poll();
            String oldKey = oldest[0] + "," + oldest[1] + "," + oldest[2];
            seen.remove(oldKey);

            List<Integer> list = destMap.get(oldest[1]);
            if (list != null) {
                int idx = Collections.binarySearch(list, oldest[2]);
                if (idx >= 0) list.remove(idx);
            }
        }

    
        int[] packet = new int[]{source, destination, timestamp};
        queue.offer(packet);
        seen.add(key);

       
        destMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[]{};
        }
        int[] packet = queue.poll();
        String key = packet[0] + "," + packet[1] + "," + packet[2];
        seen.remove(key);
        List<Integer> list = destMap.get(packet[1]);
        if (list != null) {
            int idx = Collections.binarySearch(list, packet[2]);
            if (idx >= 0) list.remove(idx);
        }

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = destMap.get(destination);
        if (list == null || list.isEmpty()) return 0;
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);

        return Math.max(0, right - left);
    }
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
