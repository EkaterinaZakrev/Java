package by.home.lesson15112017;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList <Integer> rand = new ArrayList<Integer>();

        for(int i=0;i<10;i++){
            int a = (int) (Math.random()*100);
            rand.add(a);
        }
        System.out.println(rand);

        Integer []arr = {};
        arr=rand.toArray(new Integer [rand.size()]);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.print("\n");

        Arrays.sort(arr);
        System.out.println("Min= "+arr[0]);
        System.out.println("Max= "+arr[arr.length-1]);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }


    }
}
