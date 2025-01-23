 

class Solution {
    
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = arrayA[0];
        
        for(int i = 1 ; i < arrayA.length ; i ++) {
            a = gcd(a, arrayA[i]);
        }
        
        int b = arrayB[0];
        
        for(int i = 1 ; i < arrayB.length ; i ++) {
            b = gcd(b, arrayB[i]);
        }
        
        for(int n : arrayA) {
            if(n % b == 0) {
                b = 0;
                break;
            } 
        }
        
        for(int n : arrayB) {
            if(n % a == 0) {
                a = 0;
                break;
            } 
        }
        
        
        
        return Math.max(a,b);
    }
}