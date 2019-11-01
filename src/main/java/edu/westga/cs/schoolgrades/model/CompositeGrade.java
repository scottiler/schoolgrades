package edu.westga.cs.schoolgrades.model;

import javafx.collections.ObservableList;

public class CompositeGrade implements Grade{
	private ObservableList<Grade> gradeValues;
	private GradingStrategy strategy;
	
	public CompositeGrade(ObservableList<Grade> gradeValues, GradingStrategy strategy) {
		this.gradeValues = gradeValues;
		this.strategy = strategy;
	}

	@Override
	public double getValue() {
		return this.strategy.getCompositeValue(gradeValues);
	}
}
