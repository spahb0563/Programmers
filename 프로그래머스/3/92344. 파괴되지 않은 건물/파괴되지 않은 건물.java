class Solution {
    
    public static final int ATTACK = 1;
    
    public static final int HEAL = 2;
        
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] damageMap = new int[board.length + 1][board[0].length + 1];
        
        for(int i = 0 ; i < skill.length ; i ++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = type == ATTACK ? -skill[i][5] : skill[i][5];
            
            damageMap[r1][c1] += degree;
            damageMap[r1][c2 + 1] -= degree;
            damageMap[r2 + 1][c1] -= degree;
            damageMap[r2 + 1][c2 + 1] += degree;
        }
        
        for(int i = 0 ; i < damageMap.length - 1; i ++) {
            for(int j = 1 ; j < damageMap[i].length; j ++) {
                damageMap[i][j] += damageMap[i][j-1];
            }
        }
        
        for(int i = 0 ; i < damageMap[0].length - 1; i ++) {
            for(int j = 1 ; j < damageMap.length ; j ++) {
                damageMap[j][i] += damageMap[j-1][i];
                
                if(board[j-1][i] + damageMap[j-1][i] > 0) answer++;
            }
        }
 
        return answer;
    }
}