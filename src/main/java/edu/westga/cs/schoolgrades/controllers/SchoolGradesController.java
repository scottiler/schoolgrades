package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController implements Initializable{
	private ObservableList<Grade> quizGrades;
	private final QuizSubtotal quizTotal = new QuizSubtotal();
	private double quizSum;
	
	@FXML public ListView<Grade> quizList;
	@FXML public ListView<Grade> homeworkList;
	@FXML public ListView<Grade> examList;
	@FXML public MenuItem addQuiz;
	@FXML public MenuItem addHomework;
	@FXML public MenuItem addExam;
	@FXML public TextField quizSubtotal;

	private void init() {
		this.quizGrades = FXCollections.observableArrayList();
		this.quizList.setItems(this.quizGrades);
		this.quizSubtotal.setEditable(false);
	}
	
	public void addQuiz() {
		TextInputDialog getQuiz = new TextInputDialog();
		getQuiz.setTitle("Quiz Grade");
		getQuiz.setContentText("Enter the quiz grade.");
		Optional<String> result = getQuiz.showAndWait();
		result.ifPresent(e -> this.quizGrades.add(new SimpleGrade(Double.parseDouble(result.get()))));
		this.setQuizSubtotal();
	}
	
	public void setQuizSubtotal() {
		GradeCalculationStrategy subgtotal= new SumOfGradesStrategy();
		this.quizSum = subgtotal.calculate(this.quizGrades);
		this.quizTotal.setquizTotal(this.quizSum);
	}
	
	public void addHomework() {
		TextInputDialog getHw = new TextInputDialog();
		getHw.setTitle("HomeWork Grade");
		getHw.setContentText("Enter the homework grade.");
		Optional<String> result = getHw.showAndWait();
		result.ifPresent(e -> this.homeworkList.getItems().add(new SimpleGrade(Double.parseDouble(result.get()))));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.quizList.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
			@Override
            public ListCell<Grade> call(ListView<Grade> list) {
                return new GradeCell();
            }
		});
		
		this.init();
		
//		this.homeworkList.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
//			@Override
//            public ListCell<Grade> call(ListView<Grade> list) {
//                return new GradeCell();
//            }
//		});
		
		this.quizSubtotal.textProperty().bindBidirectional(this.quizTotal.quizTotalProperty(), new NumberStringConverter());
	}

}
