package com.designpattern.factory;

import java.io.File;
import java.util.List;

public  abstract class BatchProcessor {
	public void processBatch(String fileName)
	{
		File file=openFile(fileName);
		
		Parser parser=createParser(file);
		List<Record>record=parser.parse();
		processRecords(record);
		writeSummary();
		closeFile();
		
	}

	public abstract Parser createParser(File fileName);

	private void processRecords(List<Record> record) {
		System.out.println("Processing each  records... db calls, etc. ");
		
	}

	private void writeSummary() {
		System.out.println("Wrote the summary with 0 records failed");
	}

	private void closeFile() {
		
		System.out.println("Closing the file ....");
	}

	private File openFile(String fileName) {
		System.out.println("Opening the file "+fileName);
		return null;
	}

}
