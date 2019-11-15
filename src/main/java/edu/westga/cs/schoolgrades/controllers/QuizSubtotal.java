package edu.westga.cs.schoolgrades.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Creates an DoubleProperty object
 * 
 * @author Perry Iler
 * @version Fall 2019
 */
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
	 * Returns doubleProperty quizTotal
	 * 
	 * @return doubleProperty quizTotal
	 */
	public DoubleProperty quizTotalProperty() {
		return this.quizTotal;
	}

	/**
	 * Set the value quizTotal
	 * 
	 * @param total Value out a score
	 */
	public void setQuizTotal(double total) {
		this.quizTotal.set(total);
	}
	
	/**
	 * Return value of quizTotal as a string
	 * 
	 * @return Value of quizTotal as a string
	 */
	public String getQuizTotalString () {
		return this.quizTotal.toString();
	}
}
