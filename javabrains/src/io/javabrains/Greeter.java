package io.javabrains;

public class Greeter {
	public void greet(Greetings helloGreetings)
	{
		helloGreetings.perform();
		
	}

	public static void main(String[] args) {
	Greeter greeter=new Greeter();
	Greetings helloGreetings=new HelloGreetings();
	//greeter.greet(helloGreetings);
	//MyLambda mylambdaInterface=()->System.out.println("Hello World ");
	Greetings mylambdaInterface=()->System.out.println("Hello World ");
	Greetings innerClassGreeting=new Greetings()
	{
		public void perform()
		{
			System.out.println("Hello world from inner class !");
		}
		
	};
	innerClassGreeting.perform();
	helloGreetings.perform();
	mylambdaInterface.perform();
	Myadd addFunction=(int a,int b)->a+b;
	System.out.println(addFunction.operation(3, 2));
	greeter.greet(mylambdaInterface);
	
	
	}

}
interface MyLambda
{
	 void foo(); 
}