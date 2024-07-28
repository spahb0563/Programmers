import java.util.*;

class Solution {
    
    static class Job {
        int startTime;
        
        int taskTime;
        
        Job(int startTime, int taskTime) {
            this.startTime = startTime;
            this.taskTime = taskTime;
        }
    }
    
    
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2)->{
            
            return o1.taskTime - o2.taskTime;
        });
        
        Arrays.sort(jobs, (o1, o2)->{
            
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];                
            }else {
                return o1[0] - o2[0];
            }
        });
        
        int time = 0;
        
        int idx = 0;
        
        int sum = 0;
        
        while(true) {
            while(idx < jobs.length) {
                if(jobs[idx][0] <= time) {
                    pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                    idx++;
                }else {
                    break;
                }
            }
            
            if(idx < jobs.length && pq.isEmpty()) {
                time = jobs[idx][0];
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            Job job = pq.poll();
            
            sum += job.taskTime + time - job.startTime;
            
            time += job.taskTime;
            
            if(idx == jobs.length && pq.isEmpty()) break;
        }
        
        return sum / jobs.length;
    }
}