package com.b2w.challenge.model;

import java.util.List;

public class ResultApiSW {
	
	private int count;
	
	private String next;
		
	private List<SwapApiResponse> results;
	
	public ResultApiSW() {}

	public ResultApiSW(int count, String next, List<SwapApiResponse> results) {
		super();
		this.count = count;
		this.next = next;
		this.results = results;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<SwapApiResponse> getResults() {
		return results;
	}

	public void setResults(List<SwapApiResponse> results) {
		this.results = results;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	
}
