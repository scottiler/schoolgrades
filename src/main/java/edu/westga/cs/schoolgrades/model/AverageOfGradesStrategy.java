package edu.westga.cs.schoolgrades.model;

import javafx.collections.ObservableList;

public class AverageOfGradesStrategy implements GradingStrategy {

	@Override
	public double getCompositeValue(ObservableList<Grade> gradeValues) {
		double value = 0;
		for(Grade current : gradeValues) {
			value += current.getValue();
		}
		return value / gradeValues.size();
	}
}
