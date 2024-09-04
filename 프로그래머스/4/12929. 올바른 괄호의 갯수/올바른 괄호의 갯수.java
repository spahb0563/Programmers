import java.util.*;

class Solution {
    
    static int n;
    static int answer;
    
    static void dfs(int count, int opend) {
        
        if(count == n * 2) {
            if(opend == 0) answer++;
            
            return;
        }
        
        if(opend == 0) {
            dfs(count + 1, opend + 1);
        }else {
            dfs(count + 1, opend + 1);
            dfs(count + 1, opend - 1);
        }
    }
    
    public int solution(int n) {
        
        this.n = n;
        
        dfs(0, 0);
        
        return answer;
    }
}