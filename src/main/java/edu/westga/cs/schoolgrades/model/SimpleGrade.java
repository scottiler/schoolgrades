package edu.westga.cs.schoolgrades.model;

public class SimpleGrade implements Grade {
	private double gradeValue;
	
	public SimpleGrade(double grade) {
		this.gradeValue = grade;
	}
	
	@Override
	public double getGrade() {
		return this.gradeValue;
	}

}


