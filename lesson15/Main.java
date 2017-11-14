package by.home.lesson15;

import java.util.ArrayList;
import java.util.HashSet;

import by.home.lesson1411.Cat;

public class Main {
	
	public static void main(String[] args) {
	
	ArrayList <String> list = new ArrayList <String> ();
	list.add(0,"Black");
	list.add(1,"Blue");
	list.add(2,"Green");
	list.add(3,"White");
	list.add(4,"Pink");
	list.add(5,"Yellow");
	list.add(6,"Red");
	list.add(7,"Blue");
	ArrayList <String> list1 = new ArrayList <String> ();
	list1.add(0,"A");
	list1.add(1,"B");
	list1.add(2,"C");
	
	list.addAll(2,list1);
	System.out.println(list);
	
	System.out.println(list.get(3));
	System.out.println(list.indexOf("B"));
	System.out.println(list.lastIndexOf("Blue"));
	list.remove(3);
	System.out.println(list);
	list.set(6, "Yoyo");
	System.out.println(list);
	ArrayList <String> list2 = new ArrayList <String> (list.subList(5, 8));
	System.out.println(list2);
	String []arr = {};
	arr=list.toArray(new String [list.size()]);
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}
	
	Cat cat = new Cat("A");
	Cat cat1 = new Cat("B");
	Cat cat2 = new Cat("C");
	Cat cat3 = new Cat("D");
	Cat cat4 = new Cat("B");
	Cat cat5 = new Cat("D");
	HashSet<Cat> cats = new HashSet<Cat>();
	cats.add(cat);
	cats.add(cat1);
	cats.add(cat2);
	cats.add(cat3);
	cats.add(cat4);
	cats.add(cat5);
	System.out.println(cats);
	cats.remove(cat3);
	System.out.println(cats.isEmpty());
	System.out.println(cats.size());
	System.out.println(cats.contains(cat1));
	
	Cat [] arr1 = {};
	arr1=cats.toArray(new Cat [cats.size()]);
	for (int i=0;i<arr1.length;i++){
		System.out.println(arr1[i]);
	}
	
	
	
	
	
	
	
	}

}
