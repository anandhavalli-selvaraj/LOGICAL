package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person>people=Arrays.asList(new Person("Charles","Darjeling",62),new Person("Arul","Mani",26),new Person("Anandh","Babu",28),new Person("Priya","dharshini",22));
//		people.sort(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getLastName().compareTo(o2.getLastName());
//			}
//		});
//		System.out.println(people);
		//sort the list by lastName
		//java 8
		Collections.sort(people, ( p1, p2)->p1.getLastName().compareTo(p2.getLastName()));
//		Comparator<Person> personComparator=( o1, o2)-> o1.getLastName().compareTo(o2.getLastName());
		//people.sort(personComparator);
		// create a method that prints all elements in the list
		//System.out.println(people);
		// java 7 solution 
//		printConditionally(people ,new Condition()
//		{
//
//			@Override
//			public boolean test(Person p) {
//				if(p.getFirstName().startsWith("A"))
//				{
//					return true;
//				}
//				return false;
//			}
//			
//		});
		performConditionally(people, p->p.getFirstName().startsWith("A"),p->System.out.println(p.getFirstName()));
		performConditionally(people, p->true,p->System.out.println(p));
		//java 8
		//System.out.println(people.stream().filter(p1->p1.getLastName().startsWith("M")).collect(Collectors.toList()));
		
	//create a method that prints all people that have last name beginning with c
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
   
interface Condition
{
	boolean test(Person p);
}