package edu.westga.cs.schoolgrades.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class HomeworkSubtotal {
private final DoubleProperty homeworkTotal = new SimpleDoubleProperty();
	
	/**
	 * Return double value of homeworkTotal
	 * 
	 * @return double value of homeworkTotal
	 */
	public double getTotalScore() {
		return this.homeworkTotal.get();
	}

	/**
	 * Returns doubleProperty homeworkTotal
	 * 
	 * @return doubleProperty homeworkTotal
	 */
	public DoubleProperty homeworkTotalProperty() {
		return this.homeworkTotal;
	}

	/**
	 * Set the value homeworkTotal
	 * 
	 * @param total Value out a score
	 */
	public void sethomeworkTotal(double total) {
		this.homeworkTotal.set(total);
	}
	
	/**
	 * Return value of homeworkTotal as a string
	 * 
	 * @return Value of homeworkTotal as a string
	 */
	public String gethomeworkTotalString () {
		return this.homeworkTotal.toString();
	}
}
