import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    static List<int[]> candidateKeyList = new ArrayList<>();
    
    static void combination(int[] arr, boolean[] visit, int n, int depth, int r) {
       
        if(depth == r) {
            
            int[] temp = new int[arr.length];
            
            System.arraycopy(arr, 0, temp, 0, arr.length);
            
            Arrays.sort(temp);
            
            list.add(temp);
            
            return;
        }
        
        for(int i = 0 ; i < n ; i++) {
            if(visit[i]) continue;
            
            if(depth > 0 && arr[depth - 1] > i) {
                continue; 
            }
            
            visit[i] = true;
            arr[depth] = i;
            combination(arr, visit, n, depth + 1, r);
            visit[i] = false;
        }
        
        
    }
    
    static boolean isCandidateKey(int[] arr, String[][] relation) {
        
        Set<String> set = new HashSet<>();
        StringBuffer sb;
        
        for(int i = 0 ; i < relation.length ; i ++ ) {
            
            sb = new StringBuffer();
            
            int before = set.size();
            
            for(int j = 0 ; j < arr.length ; j ++) {
                sb.append(relation[i][arr[j]]);
                sb.append(" ");
            }
            
            set.add(sb.toString());
            if(set.size() == before) return false;
        }
        
        return isMinimality(arr);
    }
    
    static boolean isMinimality(int[] arr) {
        
        for(int i = 0 ; i < candidateKeyList.size() ; i ++) {
            
            int[] candidateKey = candidateKeyList.get(i);
            
            int cnt = 0;
            
            if(candidateKey.length >= arr.length) continue;
            
            for(int j = 0 ; j < candidateKey.length; j ++) {
                if(Arrays.binarySearch(arr, candidateKey[j]) >= 0) {
                    cnt++;   
                }
            }
            
            if(candidateKey.length == cnt) return false;
        }
        
        return true;
    }
    
    public int solution(String[][] relation) {
        int attributeSize = relation[0].length;
        
        for(int i = 1 ; i <= attributeSize ; i ++) {
            combination(new int[i], new boolean[attributeSize], attributeSize, 0, i);
        }
        
        for(int[] arr : list) {
            if(isCandidateKey(arr, relation)) {
                candidateKeyList.add(arr);
            }
        }
        
        return candidateKeyList.size();
    }
}