package io.javabrains.unit3;

import io.javabrains.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		List<Person>people=Arrays.asList(new Person("Charles","Darjeling",62),new Person("Arul","Mani",26),new Person("Anandh","Babu",28),new Person("Priya","dharshini",22));
		people.stream().forEach((p)->System.out.println(p.getFirstName()));
		System.out.println("Filtering");
		people.stream().filter((p)->p.getFirstName().startsWith("A")).forEach((p)->System.out.println(p));
		Stream<Person>stream=people.stream();
		System.out.println(people.parallelStream().filter((p)->p.getFirstName().startsWith("A")).count());
		
	}

}
