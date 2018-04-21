package com.designpattern.factory;

import java.io.File;
import java.util.List;

public class XMLParser implements Parser {
	public XMLParser(File file) {
		System.out.println("Creating XML Parser");
	}
	
	@Override
	public List<Record> parse() {
		// TODO Auto-generated method stub
		return null;
	}

}
