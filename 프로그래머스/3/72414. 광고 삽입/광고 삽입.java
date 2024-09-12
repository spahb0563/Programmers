class Solution {
    
    static int toInt(String time) {
        String[] timeArr = time.split(":");
        
        int hour = Integer.parseInt(timeArr[0]);
        
        int min = Integer.parseInt(timeArr[1]);
        
        int sec = Integer.parseInt(timeArr[2]);
        
        return (60 * 60 * hour) + (60 * min) + sec;
    }
    
    static String toStr(int time) {
        
        int hour = time / 60 / 60;
        
        time -= (60 * 60 * hour);
        
        int min = time / 60;
        
        time -= 60 * min;
        
        int sec = time;
        
        return String.format("%02d:%02d:%02d", hour, min, sec);
        
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = toInt(play_time);
        long[] arr = new long[playTime + 1];
        
        for(int i = 0 ; i < logs.length; i ++) {
            String start = logs[i].substring(0, 8);            
            
            int startTime = toInt(start);
            
            String end = logs[i].substring(9);            
            
            int endTime = toInt(end);
            
            arr[startTime]++;
            arr[endTime]--;
        }
        
        for(int i = 1 ; i < arr.length ; i ++) {
            arr[i] = arr[i-1] + arr[i];
        }
        
        long max = 0L;
        
        long sum = 0L;
        
        int advTime = toInt(adv_time);
        
        for(int i = 0 ; i <= advTime; i ++) {
            sum += arr[i];
        }
        
        int left = 0;
        int right = advTime;
        
        int maxStartTime = 0;
        
        while(left < arr.length - 1) {
            if(max < sum) {
                max = sum;
                maxStartTime = left;
            }
            
            sum-=arr[left];
            left++;
            
            if(right < arr.length - 1) {
                sum+=arr[right];
                right++;
            }
        }
        
        
        return toStr(maxStartTime);
    }
}