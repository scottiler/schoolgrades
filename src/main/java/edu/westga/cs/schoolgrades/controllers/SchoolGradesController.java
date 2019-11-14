package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController implements Initializable{
	private ObservableList<Grade> quizGrades;
	private ObservableList<Grade> homeworkGrades;
	private ObservableList<Grade> examGrades;
	private ObservableList<Grade> finalGrades;
	
	private final QuizSubtotal quizTotal = new QuizSubtotal();
	private final HomeworkSubtotal homeworkTotal = new HomeworkSubtotal();
	private final ExamSubtotal examTotal = new ExamSubtotal();
	private final FinalGrade finalGrade = new FinalGrade();
	private Grade quizSum;
	private Grade hwSum;
	private Grade examSum;
	private Grade grade;
	
	@FXML public ListView<Grade> quizList;
	@FXML public ListView<Grade> homeworkList;
	@FXML public ListView<Grade> examList;
	@FXML public MenuItem addQuiz;
	@FXML public MenuItem addHomework;
	@FXML public MenuItem addExam;
	@FXML public Button recalculate;
	@FXML public TextField quizSubtotal;
	@FXML public TextField homeworkSubtotal;
	@FXML public TextField examSubtotal;
	@FXML public TextField finalText;

	private void init() {
		this.quizGrades = FXCollections.observableArrayList();
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();
		this.finalGrades = FXCollections.observableArrayList();
		this.quizList.setItems(this.quizGrades);
		this.homeworkList.setItems(this.homeworkGrades);
		this.examList.setItems(this.examGrades);
		this.quizSubtotal.setEditable(false);
		this.homeworkSubtotal.setEditable(false);
		this.examSubtotal.setEditable(false);
		
	}
	
	public void addQuiz() {
		TextInputDialog getQuiz = new TextInputDialog();
		getQuiz.setTitle("Quiz Grade");
		getQuiz.setContentText("Enter the quiz grade.");
		Optional<String> result = getQuiz.showAndWait();
		result.ifPresent(e -> this.quizGrades.add(new SimpleGrade(Double.parseDouble(result.get()))));
		
	}
	
	public void setQuizSubtotal() {
		GradeCalculationStrategy subtotal = new SumOfGradesStrategy();
		this.quizSum = new SimpleGrade(subtotal.calculate(this.quizGrades));
		this.quizTotal.setQuizTotal(this.quizSum.getValue());
	}
	
	public void addHomework() {
		TextInputDialog getHw = new TextInputDialog();
		getHw.setTitle("HomeWork Grade");
		getHw.setContentText("Enter the homework grade.");
		Optional<String> result = getHw.showAndWait();
		result.ifPresent(e -> this.homeworkGrades.add(new SimpleGrade(Double.parseDouble(result.get()))));
	}
	
	public void setHomeworkSubtotal() {
		GradeCalculationStrategy child = new AverageOfGradesStrategy();
		GradeCalculationStrategy subtotal = new DropLowestStrategy(child);
		this.hwSum = new SimpleGrade(subtotal.calculate(this.homeworkGrades));
		this.homeworkTotal.setHomeworkTotal(this.hwSum.getValue());
	}
	
	
	public void addExam() {
		TextInputDialog getExam = new TextInputDialog();
		getExam.setTitle("Examk Grade");
		getExam.setContentText("Enter the exam grade.");
		Optional<String> result = getExam.showAndWait();
		result.ifPresent(e -> this.examGrades.add(new SimpleGrade(Double.parseDouble(result.get()))));
	}
	
	public void setExamSoubtotal() {
		GradeCalculationStrategy subtotal = new AverageOfGradesStrategy();
		this.examSum = new SimpleGrade(subtotal.calculate(this.examGrades));
		this.examTotal.setExamTotal(this.examSum.getValue());
	}
	
	public void setFinalGrade() {
		this.finalGrades.addAll(new WeightedGrade(this.quizSum, .2), new WeightedGrade(this.hwSum, .3), new WeightedGrade(this.examSum, .5));
		GradeCalculationStrategy finalTotal = new SumOfGradesStrategy();
		this.grade = new SimpleGrade(finalTotal.calculate(this.finalGrades));
		this.finalGrade.setfinalGrade(this.grade.getValue());
	}
	
	public void recalculate() {
		this.setQuizSubtotal();
		this.setHomeworkSubtotal();
		this.setExamSoubtotal();
		this.setFinalGrade();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.quizList.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
			@Override
            public ListCell<Grade> call(ListView<Grade> list) {
                return new GradeCell();
            }
		});
		
		this.homeworkList.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
			@Override
            public ListCell<Grade> call(ListView<Grade> list) {
                return new GradeCell();
           }
		});
		
		this.examList.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
			@Override
            public ListCell<Grade> call(ListView<Grade> list) {
                return new GradeCell();
           }
		});
		
		this.quizSubtotal.textProperty().bindBidirectional(this.quizTotal.quizTotalProperty(), new NumberStringConverter());
		this.homeworkSubtotal.textProperty().bindBidirectional(this.homeworkTotal.homeworkTotalProperty(), new NumberStringConverter());
		this.examSubtotal.textProperty().bindBidirectional(this.examTotal.examTotalProperty(), new NumberStringConverter());
		this.finalText.textProperty().bindBidirectional(this.finalGrade.finalGradeProperty(), new NumberStringConverter());
		this.init();
	}

}
