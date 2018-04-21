package io.javabrains;

public class TypeInference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		//StringLengthLambda sll= s->s.length();
		printLamda(s->s.length());
		//System.out.println(sll.getLength("Hello Lambda"));

	}
	public static void printLamda(StringLengthLambda l)
	{
		System.out.println(l.getLength("Hello world"));
	}

}
interface StringLengthLambda
{
	int getLength(String s);
}
