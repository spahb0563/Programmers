class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int length = sticker.length;
        
        int[] dp = new int[length];
    
        if(length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }else if(length == 1) {
            return sticker[0];
        }
        
        int max = 0;
            
        for(int i = 0 ; i < length ; i ++) {
            dp[i] = sticker[i];
        }
        
        for(int i = 1 ; i < length - 1; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i] + max);
            max = Math.max(max, dp[i-1]);
            answer = Math.max(dp[i], answer);
        }
    
        for(int i = 1 ; i < length ; i ++) {
            dp[i-1] = sticker[i];
        }
        
        dp[length - 1] = sticker[0];
        
        max = 0;
        
        for(int i = 1 ; i < length - 1; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i] + max);
            max = Math.max(max, dp[i-1]);
            answer = Math.max(dp[i], answer);
        }
        
        return answer;
    }
}