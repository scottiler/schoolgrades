package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWeighhtedGradeGetValue {

	@Test
	void ShouldReturnGradeValue75() {
		WeightedGrade grade = new WeightedGrade(100, .75);
		double result = grade.getGrade();
		assertEquals(75.0, result);
	}

	@Test
	void ShouldReturnGradeValue60() {
		WeightedGrade grade = new WeightedGrade(80, .75);
		double result = grade.getGrade();
		assertEquals(60.0, result);
	}
	
	@Test
	void ShouldReturnGradeValue45() {
		WeightedGrade grade = new WeightedGrade(90, .50);
		double result = grade.getGrade();
		assertEquals(45.0, result);
	}
	
	@Test
	void ShouldReturnGradeValue80() {
		WeightedGrade grade = new WeightedGrade(80, 1.0);
		double result = grade.getGrade();
		assertEquals(80.0, result);
	}
}
