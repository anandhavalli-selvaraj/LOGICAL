package io.javabrains.unit3;

import io.javabrains.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person>people=Arrays.asList(new Person("Charles","Darjeling",62),new Person("Arul","Mani",26),new Person("Anandh","Babu",28),new Person("Priya","dharshini",22));
		//Using for Loop(Perform this operation imperatively
//		for(int i=0;i<people.size();i++)
//		{
//			System.out.println(people.get(i));
//		}
//		//Using foreach loop(External Iterators)
//		for(Person p1:people )
//		{
//			System.out.println(p1);
//		}
		people.forEach(p->System.out.println(p));
		people.forEach(System.out::println);
		// In java 8 they are introducing internal iterators(you are not controlling the iterators),by run time it  iterate
	}

}
