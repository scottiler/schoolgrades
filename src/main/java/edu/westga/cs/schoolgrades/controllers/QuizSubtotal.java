package edu.westga.cs.schoolgrades.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class QuizSubtotal {
	private final DoubleProperty quizTotal = new SimpleDoubleProperty();
	
	/**
	 * Return double value of quizTotal
	 * 
	 * @return double value of quizTotal
	 */
	public double getTotalScore() {
		return this.quizTotal.get();
	}

	/**
	 * Returns doubleegerProperty quizTotal
	 * 
	 * @return doubleegerProperty quizTotal
	 */
	public DoubleProperty quizTotalProperty() {
		return this.quizTotal;
	}

	/**
	 * Set the value quizTotal
	 * 
	 * @param total Value out a score
	 */
	public void setquizTotal(double total) {
		this.quizTotal.set(total);
	}
	
	/**
	 * Return value of quizTotal as a string
	 * 
	 * @return Value of quizTotal as a string
	 */
	public String getquizTotalString () {
		return this.quizTotal.toString();
	}
}
