package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGradeGetValue {
	
	
	@Test
	void ShouldReturnGradeValue95() {
		SimpleGrade grade = new SimpleGrade(95);
		double result = grade.getGrade();
		assertEquals(95.0, result);
	}
	
	@Test
	void ShouldReturnGradeValue90() {
		SimpleGrade grade = new SimpleGrade(90);
		double result = grade.getGrade();
		assertEquals(90.0, result);
	}

	@Test
	void ShouldReturnGradeValue85() {
		SimpleGrade grade = new SimpleGrade(85);
		double result = grade.getGrade();
		assertEquals(85.0, result);
	}
}
