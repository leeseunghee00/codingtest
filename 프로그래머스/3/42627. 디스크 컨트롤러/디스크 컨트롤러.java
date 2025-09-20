import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        
        int size = jobs.length;
        
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        PriorityQueue<Job> waitQueue = new PriorityQueue<>((j1, j2) -> j1.time - j2.time);
        
        int idx = 0, now = 0;
        int returnTime = 0;
        
        while (idx < size || !waitQueue.isEmpty()){
            while (idx < size && jobs[idx][0] <= now) {
                waitQueue.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
                        
            if (waitQueue.isEmpty()) {
                now = jobs[idx][0];
            } else {
                Job job = waitQueue.poll();
                now += job.time;
                returnTime += (now - job.request);
            }
        }
        
        int result = returnTime / size;
        
        return result;
    }
    
    class Job {
        int request;
        int time;
        
        Job(int request, int time) {
            this.request = request;
            this.time = time;
        }
    }
}
