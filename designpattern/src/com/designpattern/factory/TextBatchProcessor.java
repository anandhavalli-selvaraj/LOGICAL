package com.designpattern.factory;

import java.io.File;

public class TextBatchProcessor  extends BatchProcessor{

	@Override
	public Parser createParser(File fileName) {
		
		return new TextParser(fileName);
	}

}
