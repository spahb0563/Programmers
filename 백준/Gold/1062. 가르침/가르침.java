import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N,K;

    static Set<Character> haveToKnowSet = new HashSet<Character>();
    static List<Character> haveToKnowList;
    static String[] words;

    static int maxCount;

    static void combination(char[] arr, boolean[] visit, int n, int r, int start, int depth) {

        if(depth == r) {
            int count = 0;

            int bitmask = 0;
            for (char c : arr) {
                bitmask |= (1 << (c - 'a'));
            }

            for (String word : words) {
                boolean check = true;
                for (char c : word.toCharArray()) {
                    if ((bitmask & (1 << (c - 'a'))) == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) count++;
            }

            maxCount = Math.max(maxCount, count);

            return;
        }

        for(int i = start ; i < n ; i ++) {
            if(visit[i]) continue;
            arr[depth] = haveToKnowList.get(i);
            visit[i] = true;
            combination(arr, visit, n, r, i + 1,depth+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken()) - 5;

        words = new String[N];

        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < N ; i ++) {
            StringBuffer sb = new StringBuffer();
            words[i] = br.readLine();

            for(char c : words[i].toCharArray()) {
                if(c != 'a' && c != 't' && c != 'i' && c != 'c' && c != 'n') {
                    sb.append(c);
                    haveToKnowSet.add(c);
                }
            }

            words[i] = sb.toString();
        }

        haveToKnowList = new ArrayList<Character>(haveToKnowSet);

        if(K >= haveToKnowList.size()) {
            maxCount = N;
        }else if(K >= 0) {
            combination(new char[K], new boolean[haveToKnowList.size()], haveToKnowList.size(), K, 0, 0);
        }else {
            maxCount = 0;
        }

        System.out.println(Integer.toString(maxCount));
        br.close();
    }
}