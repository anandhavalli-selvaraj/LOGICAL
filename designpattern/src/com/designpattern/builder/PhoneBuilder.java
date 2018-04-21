package com.designpattern.builder;

public class PhoneBuilder {
	private String os;
	private int rom;
	private double screenSize;
	private String processor;
	private int battery;
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;

	}
	public PhoneBuilder setRom(int rom) {
		this.rom = rom;
		return this;
	}
	public PhoneBuilder setScreenSize(double screenSize) {
		this.screenSize = screenSize;
		return this;

	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;

	}
	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;

	}
	public Phone makePhone()
	{
		return new Phone(os, rom, screenSize, processor, battery);
	}
}
