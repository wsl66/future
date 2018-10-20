package mytest01;

import java.util.ArrayList;
import java.util.Collection;

public class GenericType1 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("abc");
		Class class1 = list1.getClass();
		Class class2 = list2.getClass();
		System.out.println(class1==class2);
		Collection<String> c1 = new ArrayList();
		Collection c2 = new ArrayList<String>();	
	}
}
