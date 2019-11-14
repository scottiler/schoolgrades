package edu.westga.cs.schoolgrades.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FinalGrade {
private final DoubleProperty finalGrade = new SimpleDoubleProperty();
	
	/**
	 * Return double value of finalGrade
	 * 
	 * @return double value of finalGrade
	 */
	public double getTotalScore() {
		return this.finalGrade.get();
	}

	/**
	 * Returns doubleProperty finalGrade
	 * 
	 * @return doubleProperty finalGrade
	 */
	public DoubleProperty finalGradeProperty() {
		return this.finalGrade;
	}

	/**
	 * Set the value finalGrade
	 * 
	 * @param total Value out a score
	 */
	public void setfinalGrade(double total) {
		this.finalGrade.set(total);
	}
	
	/**
	 * Return value of finalGrade as a string
	 * 
	 * @return Value of finalGrade as a string
	 */
	public String getfinalGradeString () {
		return this.finalGrade.toString();
	}
}
