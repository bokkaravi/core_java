package DataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Anagram {
    public static void main(String[] args) {
//        String s = "anagram",t = "nagaram";
//        char[] s1 = s.toCharArray();
//        char[] s2 = t.toCharArray();
//        Arrays.sort(s1);
//        Arrays.sort(s2);
//        s = String.valueOf(s1);
//        t = String.valueOf(s2);
//        System.out.println(s+"   "+t);
//
//        System.out.println(s.equals(t));



        String string = "abcabcbb";

        int left = 0,right = 0,logest = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < string.length()){
            if(!set.contains(string.charAt(right))){
                set.add(string.charAt(right));
                right ++;
            }else{
                set.remove(string.charAt(left));
                left++;
            }
            int max = right - left;
            logest = Math.max(logest,max);
        }
        System.out.println(logest);


    }
}
class vehicle {

}
