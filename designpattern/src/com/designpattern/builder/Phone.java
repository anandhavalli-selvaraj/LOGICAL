package com.designpattern.builder;

public class Phone {

private String os;
private int rom;
private double screenSize;
private String processor;
private int battery;

public Phone(String os, int rom, double screenSize, String processor,
			int battery) {
		super();
		this.os = os;
		this.rom = rom;
		this.screenSize = screenSize;
		this.processor = processor;
		this.battery = battery;
	}

@Override
public String toString() {
	return "Phone [os=" + os + ", rom=" + rom + ", screenSize=" + screenSize
			+ ", processor=" + processor + ", battery=" + battery + "]";
}

}
