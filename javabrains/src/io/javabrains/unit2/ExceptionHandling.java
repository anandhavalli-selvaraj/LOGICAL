package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int someNumbers[]={1,2,3,4,5,6};
		int key=0;
		processNumbers(someNumbers,key,wrapperLambda((i,k)->System.out.println(i/k)));
		

	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer,Integer> biConsumer) {
		return (v,k)->
		{
			try
			{biConsumer.accept(v, k);
			}
			catch(ArithmeticException e)
			{
				System.out.println("The Exception occured in wrapper lambda");
		}
		};
		
	}

	private static void processNumbers(int[] someNumbers, int key,BiConsumer<Integer, Integer>biConsumer) {
		for(int i: someNumbers)
		{
			biConsumer.accept(i, key);	
			}
	}

}
