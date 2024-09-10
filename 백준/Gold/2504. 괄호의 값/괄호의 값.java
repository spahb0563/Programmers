import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws Exception{
    	String str = br.readLine();
    	
    	Stack<Character> stack = new Stack<>();
    		
    	int answer = 0;
    	
    	int temp = 1;
    	
    	for(int i = 0 ; i < str.length() ; i ++) {
    		char c = str.charAt(i);
    		
    		if(c == '(') { 
    			temp*=2;
    			stack.push(c);
    		}else if(c == ')') {
    			if(stack.isEmpty() || stack.peek() != '(') {
    				answer = 0;
    				break;
    			}else {
    				if(str.charAt(i - 1) == '(') {
    					answer+=temp;
    				}
    				stack.pop();
    				temp/=2;
    			}
    		}else if(c == '[') {
    			temp*=3;
    			stack.push(c);
    		}else if(c == ']') {
    			if(stack.isEmpty() || stack.peek() != '[') {
    				answer = 0;
    				break;
    			}else {
    				if(str.charAt(i - 1) == '[') {
    					answer+=temp;
    				}
    				stack.pop();
    				temp/=3;
    			}
    		}
    	}
    	
    	if(!stack.isEmpty()) answer = 0;
    	
    	System.out.println(Integer.toString(answer));
    	
    	br.close();
    }
}