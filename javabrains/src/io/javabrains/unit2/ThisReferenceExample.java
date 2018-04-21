package io.javabrains.unit2;

public class ThisReferenceExample {

	public void execute()
	{
		doProcess(10, (i)->{
			System.out.println("Value  of i "+i);
			System.out.println(this);
		});
		
	}
	public static void main(String[] args) {
		
ThisReferenceExample thisReferenceExample=new ThisReferenceExample();
//System.out.println(this);
//thisReferenceExample.doProcess(10, (i)->{
//	System.out.println("Value  of i "+i);
//	
//});

thisReferenceExample.execute();

//thisReferenceExample.doProcess(10, new Process() {
//	//$1@2a139a55
//@1c20c684
//	@Override
//	public void process(int i) {
//		System.out.println("Value  of i "+i);
//		System.out.println(this);
//		
//	}
//	public String toString()
//	{
//		return "This is anonymous inner class";
//	}
//});
	}
//	public String toString()
//	{
//		return "This is anonymous inner class";
//	}
	public  void doProcess(int i,Process p)
	{
		p.process(i);
	}

}
