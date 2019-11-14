package edu.westga.cs.schoolgrades.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ExamSubtotal {
	private final DoubleProperty examTotal = new SimpleDoubleProperty();
	
	/**
	 * Return double value of examTotal
	 * 
	 * @return double value of examTotal
	 */
	public double getTotalScore() {
		return this.examTotal.get();
	}

	/**
	 * Returns doubleProperty examTotal
	 * 
	 * @return doubleProperty examTotal
	 */
	public DoubleProperty examTotalProperty() {
		return this.examTotal;
	}

	/**
	 * Set the value examTotal
	 * 
	 * @param total Value out a score
	 */
	public void setExamTotal(double total) {
		this.examTotal.set(total);
	}
	
	/**
	 * Return value of examTotal as a string
	 * 
	 * @return Value of examTotal as a string
	 */
	public String getExamTotalString () {
		return this.examTotal.toString();
	}
}
