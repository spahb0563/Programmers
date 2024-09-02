class Solution {
    
    static int maxCount = 0;
    static int maxSales = 0;
        
    static int[] emoticons;
    static int[][] users;
    
    public void permutation(int[] arr, int depth, int r) {
        int[] temp = new int[users.length];
        
        int count = 0;
        int sales = 0;
        
        if(r == depth) {
            for(int i = 0 ; i < arr.length ; i ++) {
                int rate = arr[i];
                int price = emoticons[i] * (100 - rate) / 100;
                
                for(int j = 0 ; j < users.length ; j ++) {
                    if(users[j][0] <= rate) temp[j] += price;
                }
            }
            
            for(int i = 0 ; i < users.length ; i ++) {
                if(temp[i] >= users[i][1]) {
                    count++;
                }else {
                    sales+=temp[i];
                }
            }
            
            if(maxCount < count) {
                maxCount = count;
                maxSales = sales;
            }else if(maxCount == count) {
                maxSales = Math.max(maxSales, sales);
            }
            
            return;
        }
        
        for(int i = 0 ; i < 4 ; i ++) {
            arr[depth] = (i + 1) * 10;
            permutation(arr, depth + 1, r);
        }
        
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        this.emoticons = emoticons;
        this.users = users;
        
        int length = emoticons.length;
        
        permutation(new int[length], 0, length);
        
        int[] answer = {maxCount, maxSales};
        
        return answer;
    }
}