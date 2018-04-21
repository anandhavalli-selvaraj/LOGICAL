package com.java.util.hashmap.categories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
public static void main(String ags[])
{
	Map<String,Integer>map=new HashMap<>();
	map.put("Anandh", 1);
	map.put("BoB", 2);
	map.put("Cat", 3);
	Iterator<String>itr=map.keySet().iterator();
	while(itr.hasNext())
	{
		itr.next();
		map.put("exception", map.get("Cat"));
		
		
	}
	System.out.println(map);
}
}
