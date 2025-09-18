package Daily_Question;
import java.util.*;
public class Design_Task_Manager {


    private Map<Integer, int[]> taskMap;
    private PriorityQueue<int[]> pq;

    public Design_Task_Manager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{priority, taskId, userId});
    }

    public void edit(int taskId, int newPriority) {
        if (taskMap.containsKey(taskId)) {
            int userId = taskMap.get(taskId)[0];
            taskMap.put(taskId, new int[]{userId, newPriority});
            pq.offer(new int[]{newPriority, taskId, userId});
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1], userId = top[2];
            if (taskMap.containsKey(taskId)) {
                int[] cur = taskMap.get(taskId);
                if (cur[0] == userId && cur[1] == priority) {
                    taskMap.remove(taskId);
                    return userId;
                }
            }
        }
        return -1;
    }
}
