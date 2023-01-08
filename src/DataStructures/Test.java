package DataStructures;

import java.io.*;
import java.util.*;

class GFG{

    static int minSwaps(int[] arr, int n)
    {
        int sum = Arrays.stream(arr).sum();//3
        int curSum = 0,maxW = 0;
        int l = -1;
        for(int r= 0;r<arr.length;r++){
            curSum += arr[r];//1

            if(r - l > sum)
                curSum -= arr[++l];

            maxW = Math.max(maxW,curSum);//2
        }

        return sum-maxW;
    }
    public static void main(String args[])
    {
        int[] a = {1,1,0,0,0,1,1};
        int n = a.length;
        System.out.println(minSwaps(a, n));
    }
}

