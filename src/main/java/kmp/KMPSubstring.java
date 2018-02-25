package kmp;

import java.util.Arrays;

/**
 * Created by atom on 2018/2/25.
 */
public class KMPSubstring {


    public int subString(String source, String target) {
        int[] next = calculateNext(target);

        boolean init = true;
        int j = 0;
        int i = 0;
        while (i < source.length()) {
            if(source.charAt(i) == target.charAt(j)) {
                j++;
            } else {
                while(next[j+1] > 0 && source.charAt(i) != target.charAt(j)) {
                    j = next[j+1] - 1;
                }
            }
            i++;

            if(j == target.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public int[] calculateNext(String  pattern) {
        int[] next = new int[pattern.length()+1];

        next[0] = -1;
        next[1] = 0;

        int j = 0; //next[1] = 0
        for(int i = 2; i < pattern.length(); i++) {
            j = next[i-1];
            while(pattern.charAt(i-1) != pattern.charAt(j) && j > 0) {
                j = next[j];
            }

            if(pattern.charAt(i-1) == pattern.charAt(j)) {
                next[i] = j + 1;
            }
        }

        System.out.println(Arrays.toString(next));
        return next;
    }

    int[] getNext(String pattern) {
        int[] next = new int[pattern.length()+1];

        next[0] = -1;
        next[1] = 0;


        int i = 0;
        int j = -1;

        while(i < next.length-1) {
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            }else {
                j = next[j];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        KMPSubstring kmpSubstring = new KMPSubstring();
        /*
        int[] next = kmpSubstring.calculateNext("abababca");
        System.out.println(Arrays.toString(next));

        int[] next2 = kmpSubstring.getNext("abababca");
        System.out.println(Arrays.toString(next2));

        int idx = kmpSubstring.subString("abababca", "aba");
        System.out.println(idx);

        int idx2 = kmpSubstring.subString("abababca", "ba");
        System.out.println(idx2);

*/
        int idx3 = kmpSubstring.subString("abababca", "bad");
        System.out.println(idx3);

        int idx4 = kmpSubstring.subString("abababca", "babc");
        System.out.println(idx4);
    }

}
