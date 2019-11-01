package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class TestAverageOfGradeStrategyGetCompositeValue {

	private AverageOfGradesStrategy strategy = new AverageOfGradesStrategy();
	private ObservableList<Grade> list = FXCollections.observableArrayList();
	
	@Test
	void SimpleGradeShouldReturn90() {
		this.list.addAll(new SimpleGrade(90.0), new SimpleGrade(100), new SimpleGrade(80));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(90.0, result);
	}

	@Test
	void SimpleGradeShouldReturn80() {
		this.list.addAll(new SimpleGrade(60.0), new SimpleGrade(85), new SimpleGrade(95));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(80.0, result);
	}

	@Test
	void SimpleGradeShouldReturn70() {
		this.list.addAll(new SimpleGrade(40.0), new SimpleGrade(75), new SimpleGrade(95));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(70.0, result);
	}
	
	@Test
	void SimpleGradeShouldReturn81() {
		this.list.addAll(new SimpleGrade(88.0), new SimpleGrade(74), new SimpleGrade(81));
		double result = this.strategy.getCompositeValue(list);
		assertEquals(81.0, result);
	}
}
