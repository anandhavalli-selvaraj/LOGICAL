package com.designpattern.factory;

public class App {
	
	public static void main(String args[]) {
		BatchProcessor batchProcessor=createBatchProcessor(args[1]);
		batchProcessor.processBatch(args[0]);
		System.out.println("Done ..");
	}
// this is not factory pattern design pattern static factory..(GO4)having superclass let the subclass have to decide.
	private static BatchProcessor createBatchProcessor(String format) {
		if(format.equals("text"))
		{
			return new TextBatchProcessor();
		}
		if(format.equals("xml"))
		{
			return new XMLBatchProcessor();
		}
		if(format.equals("csv"))
		{
			return new CSVBatchProcessor();
		}
		return null;
	}
}
