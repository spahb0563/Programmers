import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N,K;

    static Set<Character> haveToKnowSet = new HashSet<Character>();
    static List<Character> haveToKnowList;
    static String[] words;

    static int maxCount;

    static void combination(char[] arr, boolean[] visit, int n, int r, int start, int depth) {

        if(depth == r) {
            int count = 0;

            boolean[] alp = new boolean[26];

            for (char c : arr) {
                alp[c - 'a'] = true;
            }

            for(String word : words) {
                boolean check = true;
                for (char c : word.toCharArray()) {
                    if(!alp[c - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check) count++;
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

        Pattern pattern = Pattern.compile("[antic]");

        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < N ; i ++) {
            words[i] = pattern.matcher(br.readLine()).replaceAll("");
            for(char c : words[i].toCharArray()) {
                set.add(c);
                haveToKnowSet.add(c);
            }
            StringBuffer sb = new StringBuffer();
            for(char c : set) {
                sb.append(c);
            }
            words[i] = sb.toString();

            set.clear();
        }

        haveToKnowList = new ArrayList<Character>(haveToKnowSet);

        if(K >= haveToKnowList.size()) {
            maxCount = N;
        }else if(K >= 0) {
            combination(new char[K], new boolean[haveToKnowList.size()], haveToKnowList.size(), K, 0, 0);
        }else {
            maxCount = 0;
        }

        bw.write(Integer.toString(maxCount));
        bw.flush();
        bw.close();
        br.close();
    }
}