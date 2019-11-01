package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.ObservableList;

public class DropLowGradeStrategy implements GradingStrategy {
	private GradingStrategy dropStrategy;
	
	public DropLowGradeStrategy(GradingStrategy dropStrategy) {
		this.dropStrategy = dropStrategy;
	}
	
	@Override
	public double getCompositeValue(ObservableList<Grade> gradeValues) {
		int index = 0;
		
		for(Grade current : gradeValues) {
			if(gradeValues.get(index).getValue() > current.getValue()) {
				index = gradeValues.indexOf(current);
			}
		}
		
		gradeValues.remove(index);
		
		return this.dropStrategy.getCompositeValue(gradeValues);
	}

}
