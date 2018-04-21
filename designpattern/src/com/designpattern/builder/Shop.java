package com.designpattern.builder;

public class Shop {
public static void main(String args[]) {
	Phone phone=new PhoneBuilder().setBattery(4800).setRom(4).setScreenSize(5.5).makePhone();
	System.out.println(phone);
}
}
