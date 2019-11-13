package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class SchoolGradesController implements Initializable{
	private ObservableList<Grade> quiz;
	private ObservableList<Grade> homework;
	private ObservableList<Grade> exam;
	
	@FXML public ListView<Double> quizList;
	@FXML public ListView<Double> homeworkList;
	@FXML public ListView<Double> examList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.quiz = FXCollections.observableArrayList();
		this.homework = FXCollections.observableArrayList();
		this.exam = FXCollections.observableArrayList();
	}

}
