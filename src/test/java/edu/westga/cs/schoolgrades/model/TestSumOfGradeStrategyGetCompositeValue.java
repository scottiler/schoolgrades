package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class TestSumOfGradeStrategyGetCompositeValue {

	private SumOfGradesStrategy strategy = new SumOfGradesStrategy();
	private ObservableList<Grade> list = FXCollections.observableArrayList();
	
	@Test
	void SimpleGradeShouldReturn270() {
		this.list.addAll(new SimpleGrade(90.0), new SimpleGrade(100), new SimpleGrade(80));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(270.0, result);
	}

	@Test
	void SimpleGradeShouldReturn220() {
		this.list.addAll(new SimpleGrade(60.0), new SimpleGrade(80), new SimpleGrade(80));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(220.0, result);
	}
	
	@Test
	void WeightedGradeShouldReturn140() {
		this.list.addAll(new WeightedGrade(90.0, .50), new WeightedGrade(100.0, .50), new WeightedGrade(90.0, .50));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(140.0, result);
	}
	
	@Test
	void WeightedGradeShouldReturn67875() {
		this.list.addAll(new WeightedGrade(30.0, .2), new WeightedGrade(70.0, .30), new WeightedGrade(81.75, .50));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(67.875, result);
	}
}
