package dev.pranavtech.week4;

import java.util.ArrayList;
import java.util.Arrays;

public class Complexity {

    public static void main(String[] args) {
        int a = 0;
        int n = 4;
        ArrayList<Integer> each = new ArrayList<Integer>();
        int count = 0;
        for (int i=0; i < n; i++){
            for(int j = n; j > i; j--){
                count++;
                each.add(count);
            }
        }
        System.out.println(each);
        System.out.println(count);
    }
}
