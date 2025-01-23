class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    static void find(int storey, int cnt, int level) {
        if(storey == 0) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(storey < 0 || storey > 100000000 || level > (int) Math.log10(storey) + 1) return;
        
        String storeyStr = Integer.toString(storey);
        
        char n = storeyStr.charAt(storeyStr.length() - level);
        
        
        int number = n - '0';
        if(number < 5) {
            find(storey - (int)(number * Math.pow(10, level - 1)), cnt + number, level + 1);
        }else if(number > 5) {
            find(storey + (int) ((10 - number) * Math.pow(10, level - 1)), cnt + 10 - number, level + 1);
        }else {
            find(storey - (int) (number * Math.pow(10, level - 1)), cnt + number, level + 1);
            find(storey + (int) ((10 - number) * Math.pow(10, level - 1)), cnt + 10 - number, level + 1);
        }
    }
    
    public int solution(int storey) {
        find(storey, 0, 1);
        
        return answer;
    }
}