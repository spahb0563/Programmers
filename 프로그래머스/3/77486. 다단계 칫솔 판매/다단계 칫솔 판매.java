import java.util.*;

class Solution {
    
    static class Node {
        String name;
    
        int profits;
        
        Node parent;
        
        Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }   
        
        public String getName() {
            return this.name;
        }
        
        public Node getParent() {
            return this.parent;
        }
        
        public int getProfits() {
            return this.profits;
        }
        
        public void addProfits(int profits) {
            this.profits += profits;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Node center = new Node("-", null);
        
        Map<String, Node> map = new HashMap<>();
        
        map.put(center.getName(), center);
        
        for(int i = 0 ; i < enroll.length; i ++) {
            Node node = new Node(enroll[i], map.get(referral[i]));
            map.put(node.getName(), node);
        }
        
        
        for(int i = 0 ; i < sellers.length; i ++) {
            Node child = map.get(sellers[i]);
            
            int money = amount[i] * 100;
            
            
            while(child.getParent() != null) {
                int giveToParent = (int)(money * 0.1);

                money -= giveToParent;

                child.addProfits(money);
                
                money = giveToParent;
                child = child.getParent();
            }
        }
        
        for(int i = 0 ; i < enroll.length ; i ++) {
            Node node = map.get(enroll[i]);
            
            answer[i] = node.getProfits();
        }
        
        return answer;
    }
}