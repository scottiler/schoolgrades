package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Provides formatting for the cellFactory of a ListView of grades.
 * 
 * @author Perry Iler
 * @version Fall 2019
 */
public class GradeCell extends ListCell<Grade>{
	@Override
	public void updateItem(Grade item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
            setText(String.valueOf(item.getValue()));
            setFont(Font.font("Verdana", FontWeight.BOLD, 14));
            setAlignment(Pos.CENTER_RIGHT);
            setAccessibleText(String.valueOf(item.getValue()));
        } else {
        	setText("");
        }
	}
}
