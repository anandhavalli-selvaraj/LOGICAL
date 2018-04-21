package io.javabrains.unit3;

import io.javabrains.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
	public static void main(String[] args) {
		List<Person>people=Arrays.asList(new Person("Charles","Darjeling",62),new Person("Arul","Mani",26),new Person("Anandh","Babu",28),new Person("Priya","dharshini",22));
		Collections.sort(people, ( p1, p2)->p1.getLastName().compareTo(p2.getLastName()));
		//performConditionally(people, p->p.getFirstName().startsWith("A"),p->System.out.println(p.getFirstName()));
		System.out.println("Printing all the people ");
		//before
		//performConditionally(people, p->true,p->System.out.println(p));
		//After
		performConditionally(people, p->true,System.out::println);
		
		}

	private static void performConditionally(List<Person> people,
			Predicate<Person> condition,Consumer<Person> c1 ) {
		for(Person eachpeople:people)
		{
			if(condition.test(eachpeople))
			{
				c1.accept(eachpeople);
			}
		}
		
	}


}
