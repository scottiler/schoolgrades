package edu.westga.cs.schoolgrades.model;

public class WeightedGrade implements Grade{

	private double gradeValue;
	private double weight;
	
	public WeightedGrade(double gradeValue, double weight) {
		this.gradeValue = gradeValue;
		this.weight = weight;
	}
	
	@Override
	public double getValue() {
		return this.gradeValue * this.weight;
	}

}
