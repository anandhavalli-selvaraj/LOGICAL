package org.anandh.javabrains.messengerapp.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @QueryParam("year")int year;
	private @QueryParam("index") int index;
	private @QueryParam("limit")int limit;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
