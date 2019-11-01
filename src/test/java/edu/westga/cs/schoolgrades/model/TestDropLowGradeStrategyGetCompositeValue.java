package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class TestDropLowGradeStrategyGetCompositeValue {
	private SumOfGradesStrategy dropStrategy = new SumOfGradesStrategy();
	private DropLowGradeStrategy strategy = new DropLowGradeStrategy(dropStrategy);
	private ObservableList<Grade> list = FXCollections.observableArrayList();
	
	@Test
	void SimpleGradeShouldReturn190() {
		this.list.addAll(new SimpleGrade(90.0), new SimpleGrade(100), new SimpleGrade(80));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(190.0, result);
	}
	
	@Test
	void SimpleGradeShouldReturn160() {
		this.list.addAll(new SimpleGrade(60.0), new SimpleGrade(80), new SimpleGrade(80));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(160.0, result);
	}
	
	@Test
	void WeightedGradeShouldReturn95() {
		this.list.addAll(new WeightedGrade(90.0, .50), new WeightedGrade(100.0, .50), new WeightedGrade(90.0, .50));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(95.0, result);
	}
	
}
