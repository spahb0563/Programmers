import java.util.*;

class Solution {   
    
    class Time {
        
        int year;
        
        int month;
        
        int day;
        
        Time(String input) {
            String[] arr = input.split("\\.");
            
            year = Integer.parseInt(arr[0]);
            
            month = Integer.parseInt(arr[1]);
            
            day = Integer.parseInt(arr[2]);
        }
        
        public void addMonths(int month) {
            this.month += month;
            
            while(this.month > 12) {
                this.year++;
                this.month -= 12;
            }
        }
        
        public boolean isBefore(Time time) {
            if(this.year == time.year) {
                
                if(this.month == time.month) {
                    
                    if(this.day < time.day) {
                        return true;
                    }else {
                        return false;
                    }
                    
                }else if(this.month > time.month) {
                    return false;
                }else {
                    return true;
                }
                
            }else if(this.year > time.year){
                return false;
            }else{
                return true;
            }
        }
        
        public boolean equals(Object o) {
            Time t = (Time) o;
            
            return (this.year == t.year && this.month == t.month && this.day == t.day);
        }
        
        public String toString() {
            return String.format("%d.%02d.%02d", year, month, day);
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        Time now = new Time(today);
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < terms.length ; i ++) {
            String[] arr = terms[i].split(" ");
            
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for(int i = 0 ; i < privacies.length ; i ++) {
            String[] arr = privacies[i].split(" ");
            
            String date = arr[0];
            String term = arr[1];
            
            Time t = new Time(date);
            
            t.addMonths(map.get(term));
            
            if(!now.isBefore(t) || now.equals(t)) {
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i ++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}