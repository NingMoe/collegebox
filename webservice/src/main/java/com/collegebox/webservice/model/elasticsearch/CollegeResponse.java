package com.collegebox.webservice.model.elasticsearch;

import java.util.List;

public class CollegeResponse {
	
	private long total;
	
	private float max_score;
	
	private List<College> hits;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public float getMax_score() {
		return max_score;
	}

	public void setMax_score(float max_score) {
		this.max_score = max_score;
	}

	public List<College> getHits() {
		return hits;
	}

	public void setHits(List<College> hits) {
		this.hits = hits;
	}

}
