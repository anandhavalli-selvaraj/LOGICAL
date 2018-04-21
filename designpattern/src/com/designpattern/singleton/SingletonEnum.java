package com.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Singleton
{
	INSTANCE;
	public String getConfiguration()
	{
		return "instance config";
	}
}
public class SingletonEnum {
	public static void useSingleton() {
		Singleton singleton=Singleton.INSTANCE;
		print("singleton",singleton);
		
	}
	public static void main(String args[])throws Exception
	{
		/*ExecutorService service=Executors.newFixedThreadPool(10);
		service.submit(SingletonEnum::useSingleton);
		service.submit(SingletonEnum::useSingleton);
		service.submit(SingletonEnum::useSingleton);
		service.submit(SingletonEnum::useSingleton);
		service.shutdown();*/
		Singleton s1=Singleton.INSTANCE;
		Singleton s2=Singleton.INSTANCE;
		print("s1", s1);
		print("s2",s2);
		FileOutputStream fos=new FileOutputStream("/data/s2");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s2);
		oos.close();
		FileInputStream fis=new FileInputStream("/data/s2");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Singleton s3=(Singleton)ois.readObject();
		print("s3",s3);
		
		
		
	}
	public static void print(String name,Singleton s) {
		System.out.println(String.format("Object is %s and Hashcode is %d",name,s.hashCode()));
		
	}
}
