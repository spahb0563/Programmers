class Solution {
    
    static int[] answer;    
    
    public void QueadTree(int[][] arr, int x, int y, int length) {
        
        int n = arr[y][x];
        
        boolean check = true;
        
        loop:
        for(int i = y ; i < y + length ; i ++) {
            for(int j = x ; j < x + length ; j ++) {
                if(n != arr[i][j]) {
                    QueadTree(arr, x, y, length / 2);
                    QueadTree(arr, x + length / 2, y, length / 2);
                    QueadTree(arr, x, y + length / 2, length / 2);
                    QueadTree(arr, x + length / 2, y + length / 2, length / 2);
                    check = false;
                    break loop;
                }
            }
        }
        
        if(check) answer[n] ++;
    }
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        QueadTree(arr, 0, 0, arr.length);
        
        return answer;
    }
}