package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockChildStrategy;
	
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	private List<Grade> lowestGradeRemoved;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(SimpleGrade.class);
		mockGrade1 = mock(SimpleGrade.class);
		mockGrade2 = mock(SimpleGrade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		when(mockGrade1.getValue()).thenReturn(20.00);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		grades = new ArrayList<Grade>();
		lowestGradeRemoved = new ArrayList<Grade>();
		mockChildStrategy = mock(SumOfGradesStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(mockChildStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		dropLowestStrategy.calculate(grades);
		verify(mockChildStrategy).calculate(grades);
	}
	
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		verify(mockChildStrategy).calculate(grades);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		dropLowestStrategy.calculate(grades);
		lowestGradeRemoved.add(mockGrade1);
		lowestGradeRemoved.add(mockGrade2);
		verify(mockChildStrategy).calculate(lowestGradeRemoved);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		lowestGradeRemoved.add(mockGrade1);
		lowestGradeRemoved.add(mockGrade2);
		verify(mockChildStrategy).calculate(lowestGradeRemoved);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		dropLowestStrategy.calculate(grades);
		lowestGradeRemoved.add(mockGrade1);
		lowestGradeRemoved.add(mockGrade2);
		verify(mockChildStrategy).calculate(lowestGradeRemoved);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		lowestGradeRemoved.add(mockGrade1);
		lowestGradeRemoved.add(mockGrade2);
		lowestGradeRemoved.add(mockGrade0);
		verify(mockChildStrategy).calculate(lowestGradeRemoved);
	}
}
