package com.designpattern.factory;

import java.io.File;

public class XMLBatchProcessor extends BatchProcessor {

	@Override
	public Parser createParser(File fileName) {
		
		return new XMLParser(fileName);
	}

}
