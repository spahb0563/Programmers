class Solution {
    static long limit;
    
    static int[] diffs;
    
    static int[] times;
    
    static int binarySearch() {
        
        int left = 1;
        int right = 100000;
        
        while(left < right) {
            
            int center = (left + right) / 2;
            
            if(puzzle(center)) {
                right = center;
            }else {
                left = center + 1;
            }
        }
        
        return right;
   
    }
    
    static boolean puzzle(long skill) {
        
        long sum = 0;
        
        for(int i = 0 ; i < diffs.length ; i ++) {
            int diff = diffs[i];
            
            if(diff > skill) {
                int pre = i == 0 ? 0 : i - 1;
                sum += ((times[pre] + times[i]) * (diff - skill));
            }
            sum += times[i];
        }
        
        return sum <= limit;
    }
    
    public long solution(int[] diffs, int[] times, long limit) {
        this.limit = limit;
        this.diffs = diffs;
        this.times = times;
        
        return binarySearch();
    }
}