package com.designpattern.factory;

import java.io.File;

public class CSVBatchProcessor extends BatchProcessor{

	@Override
	public Parser createParser(File fileName) {
		
		return new CSVParser(fileName);
	}

}
