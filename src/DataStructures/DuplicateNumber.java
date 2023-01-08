package DataStructures;

import java.util.*;

public class DuplicateNumber {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                return true;
            }
        }
        return false;
    }
        public static void main(String[] args){
            int[] a = {1,2,3,4,5,4};
            System.out.println(containsDuplicate(a));
        }
}
