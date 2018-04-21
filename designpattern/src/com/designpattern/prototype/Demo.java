package com.designpattern.prototype;

public class Demo {
public static void main(String args[]) throws CloneNotSupportedException
{
	BookShop bs=new BookShop();
	bs.setBookShopName("Neyam");
	bs.loadData();
	
	BookShop bs1=bs.clone();
	bs1.setBookShopName("Malar");
	bs.getBooks().remove(2);
	System.out.println(bs);
	
	System.out.println(bs1);
	
}
}
