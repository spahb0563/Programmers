import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int length = numbers.length;
        int[] answer = new int[length];
        
        answer[length - 1] = -1;
        
        stack.push(numbers[length - 1]);
        
        for(int i = length - 2 ; i >= 0 ; i --) {
            while(!stack.isEmpty()) {
                int peek = stack.peek();
                
                if(peek <= numbers[i]) {
                    stack.pop();
                }else {
                    answer[i] = peek;
                    stack.push(numbers[i]);
                    break;
                }
            }
            
            if(stack.isEmpty()) {
                stack.push(numbers[i]);
                answer[i] = -1;
            }
                
        }
        
        return answer;
    }
}