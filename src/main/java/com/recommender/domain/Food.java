package com.recommender.domain;

public class Food {
	
	int id;
	String name;
	String realId;
	Double prediction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealId() {
		return realId;
	}
	public void setRealId(String realId) {
		this.realId = realId;
	}
	public Double getPrediction() {
		return prediction;
	}
	public void setPrediction(Double prediction) {
		this.prediction = prediction;
	}

	
}
