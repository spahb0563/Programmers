import java.io.*;
import java.util.Arrays;

public class Main {
    static void pushButton(int[] arr, int idx) {
        arr[idx] = arr[idx] ^ 1;

        if(idx != 0) {
            arr[idx-1] = arr[idx-1] ^ 1;
        }
        
        if(idx != arr.length - 1) {
            arr[idx+1] = arr[idx+1] ^ 1;
        }
    }
    public static void main(String[] args) throws Exception {

        InputStream in = System.in;
        
        int b;
        int N = 0;

        int x = 0;
        while (true) { 
            x++;
            b = in.read();

            if(b == '\r') continue;

            if(b == '\n') {
                break;
            }
            N = (N * 10) + (b - '0');
        }

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for(int i = 0 ; i < N ; i ++) {
            arr1[i] = in.read() - '0';
            arr2[i] = arr1[i];
        }

        if(in.read() == '\r') in.read();

        int[] target = new int[N];

        for(int i = 0 ; i < N ; i ++) {
            target[i] = in.read() - '0';            
        }
        
        if(in.read() == '\r') in.read();

        pushButton(arr1, 0);

        int result = -1;
        
        int cnt1 = 1;
        int cnt2 = 0;

        for(int i = 1 ; i < arr1.length ; i ++) {
            if(arr1[i-1] != target[i-1]) {
                pushButton(arr1, i);
                cnt1++;
            }            

            if(arr2[i-1] != target[i-1]) {
                pushButton(arr2, i);
                cnt2++;
            }
        }

        if(Arrays.equals(arr1, target)) {
            result = cnt1;
        }

        if(Arrays.equals(arr2, target)) {
            result = result == -1 ? cnt2 :Math.min(result, cnt2);
        }
        
        System.out.print(result);

    }
}