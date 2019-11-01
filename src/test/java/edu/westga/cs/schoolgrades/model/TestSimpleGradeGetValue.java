package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGradeGetValue {
	
	
	@Test
	void ShouldReturnGradeValue95() {
		Grade grade = new SimpleGrade(95);
		double result = grade.getValue();
		assertEquals(95.0, result);
	}
	
	@Test
	void ShouldReturnGradeValue90() {
		Grade grade = new SimpleGrade(90);
		double result = grade.getValue();
		assertEquals(90.0, result);
	}

	@Test
	void ShouldReturnGradeValue85() {
		Grade grade = new SimpleGrade(85);
		double result = grade.getValue();
		assertEquals(85.0, result);
	}
}
