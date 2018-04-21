package com.designpattern.singleton;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class SingletonRename implements Serializable, Cloneable {
//	private static volatile Singleton soleInstance=null;
	private SingletonRename()
	{
		//Availding reflection create singleton object.
//		if(soleInstance!=null)
//		{
//			throw new RuntimeException("Cannot create, Pls use getInstance () method ");
//		}
//		else
//		{
//			soleInstance=this;
//		}
		System.out.println("Creating ...");
	}
	static class Holder
	{
		static final SingletonRename instance=new SingletonRename();
	}
	public static  SingletonRename getInstance()
	{
		return Holder.instance;
		 
		//double checking
		/*if(soleInstance==null)
		{
			synchronized(Singleton.class)
			{
				if(soleInstance==null)
				{
					soleInstance=new Singleton();
				}
			}
		}
		return soleInstance;*/
		
	}
	//Avoid serialization and deserialization
	private Object readResolve()throws ObjectStreamException
	{
		System.out.println("..... Read Resolving .....");
		return Holder.instance;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException  {
	return super.clone();
	}

}
class TestClass
{
	public static void useSingleton()
	{
		SingletonRename singleton=SingletonRename.getInstance();
		print("singleton",singleton);
		
	}
	public static void main (String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, CloneNotSupportedException {
		/*ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(TestClass::useSingleton);
		service.submit(TestClass::useSingleton);
		service.shutdown();*/
		
		SingletonRename s1=SingletonRename.getInstance();
		SingletonRename s2=SingletonRename.getInstance();
		print("s1",s1);
		print("s2",s2);
		//Reflection 
		/*
		Class clazz=Class.forName("com.designpattern.singleton.Singleton");
		Constructor[]crt=clazz.getDeclaredConstructors();
		crt[0].setAccessible(true);
		Singleton s3=(Singleton) crt[0].newInstance(args);
		print("s3",s3);*/
		
		//Serialization
		/*FileOutputStream fs=new FileOutputStream("/data/s2");
		ObjectOutputStream oos=new ObjectOutputStream(fs);
		oos.writeObject(s2);
		oos.close();
		
		FileInputStream fis=new FileInputStream("/data/s2");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Singleton s3=(Singleton)ois.readObject();
		ois.close();
		print("s3",s3);*/
		
	//Cloning	
	SingletonRename s3=(SingletonRename)s2.clone();
 	print("s3",s3);
//		
		
		
	}
	public static void  print(String name,SingletonRename s1)
{
	System.out.println(String.format("Object : %s HashCode : %d",name,s1.hashCode()));
}
}