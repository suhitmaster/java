package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String []cp) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		
	 	ints.stream().filter(e -> e%2 ==0).map(e -> e*e).collect(Collectors.toList()).forEach(e -> System.out.println(e));
		
		
	}
}
