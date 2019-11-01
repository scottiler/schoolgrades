package edu.westga.cs.schoolgrades.model;

import javafx.collections.ObservableList;

public interface GradingStrategy {
	
	double getCompositeValue(ObservableList<Grade> gradeValues);
}
