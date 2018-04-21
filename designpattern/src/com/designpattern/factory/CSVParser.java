package com.designpattern.factory;

import java.io.File;
import java.util.List;

public class CSVParser implements Parser {
	public CSVParser (File file)
	{
		
		System.out.println("Created csv parser");
	}
	@Override
	public List<Record> parse() {
		System.out.println("Parsing the csv values");
		return null;
	}

}
