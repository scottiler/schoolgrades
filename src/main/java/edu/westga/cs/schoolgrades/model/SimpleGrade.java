package edu.westga.cs.schoolgrades.model;


import java.util.ArrayList;

import javafx.collections.ObservableList;

public class SimpleGrade implements Grade {
	private ObservableList<Double> grades;

	public SimpleGrade(ObservableList<Double> grades) {
		this.grades = grades;
	}
	
	@Override
	public double getGrade() {
		double total = 0;
		for(Double grade : grades) {
			total += grade;
		}
		return total/grades.size();
	}

}


