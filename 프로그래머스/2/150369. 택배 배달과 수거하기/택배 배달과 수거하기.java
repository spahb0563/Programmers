import java.util.*;

class Solution {

    class Delivery {
    
        int amount;
        
        int location;
        
        Delivery(int amount, int location) {
            this.amount = amount;
            this.location = location;
        }
    }
    
    class Pick {
        int amount;
        
        int location;
        
        Pick(int amount, int location) {
            this.amount = amount;
            this.location = location;
        }

    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Delivery> deliveryStack = new Stack<>();
        
        Stack<Pick> pickStack = new Stack<>();
        
        for(int i = 0 ; i < deliveries.length ; i ++) {
            
            if(deliveries[i] != 0) deliveryStack.push(new Delivery(deliveries[i], i+1));
            
            if(pickups[i] != 0) pickStack.push(new Pick(pickups[i], i+1));
            
        }
        
        while(true) {
            int pickAmount = 0;
        
            int deliveryAmount = cap;
            
            Delivery delivery = deliveryStack.isEmpty() ? null : deliveryStack.pop();
            
            Pick pick = pickStack.isEmpty() ? null : pickStack.pop();
            
            if(delivery == null) {
                if(pick == null) break;
                
                answer += pick.location * 2;
                
                while(pickAmount < cap) {
                    if(pick.amount > cap - pickAmount) {
                        pick.amount -= cap - pickAmount;
                        pickAmount = cap;
                        pickStack.push(pick);
                    }else {
                        pickAmount += pick.amount;
                        if(pickStack.isEmpty() || pickAmount == cap) break;
                        pick = pickStack.pop();
                    }
                }
            }else {
                if(pick == null) {
                    answer += delivery.location * 2;
                
                    while(deliveryAmount > 0) {
                        if(delivery.amount > deliveryAmount) {
                            delivery.amount -= deliveryAmount;
                            deliveryAmount = 0;
                            deliveryStack.push(delivery);
                        }else {
                            deliveryAmount -= delivery.amount;
                            if(deliveryStack.isEmpty() || deliveryAmount == 0) break;
                            delivery = deliveryStack.pop();
                        }
                    }
                }else {
                    
                    if(delivery.location > pick.location) {
                        answer += delivery.location * 2;
                    }else {
                        answer += pick.location * 2;
                    }
                    
                    while(deliveryAmount > 0) {
                        if(delivery.amount > deliveryAmount) {
                            delivery.amount -= deliveryAmount;
                            deliveryAmount = 0;
                            deliveryStack.push(delivery);
                        }else {
                            deliveryAmount -= delivery.amount;
                            if(deliveryStack.isEmpty() || deliveryAmount == 0) break;
                            delivery = deliveryStack.pop();
                        }
                    }
                    
                    while(pickAmount < cap) {
                        if(pick.amount > cap - pickAmount) {
                            pick.amount -= cap - pickAmount;
                            pickAmount = cap;
                            pickStack.push(pick);
                        }else {
                            pickAmount += pick.amount;
                            if(pickStack.isEmpty() || pickAmount == cap) break;
                            pick = pickStack.pop();
                        }
                    }
                }
            }
            
        }
        
        
        return answer;
    }
}