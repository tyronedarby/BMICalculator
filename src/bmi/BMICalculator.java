// Author: Tyrone Darby
// Date Created: May 11, 2026


package bmi;

import io.github.tyronedarby.bmi.BmiCalculator;
import io.github.tyronedarby.bmi.BmiCategory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BMICalculator extends Application{
	// Create Labels and TextFields
	private Label lblWeight = new Label("Weight (kg)");
	private TextField tf1 = new TextField();
	
	private Label lblHeight = new Label("Height (m)");
	private TextField tf2 = new TextField();
	
	private Label lblBMI = new Label("BMI");
	private TextField tf3 = new TextField();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create GridPane
		GridPane gPane = new GridPane();
		
		// Create Buttons to calculate and reset
		Button btnCalculate = new Button("Calculate");
		Button btnReset = new Button("Reset");
		
		// Reset TextFields
		btnReset.setOnAction(e -> {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		});
		
		// Add controls to the GridPane
		gPane.add(lblWeight, 0, 0);
		gPane.add(tf1, 1, 0);
		gPane.add(lblHeight, 0, 1);
		gPane.add(tf2, 1, 1);
		gPane.add(lblBMI, 0, 2);
		gPane.add(tf3, 1, 2);
		gPane.add(btnCalculate, 0, 3);
		gPane.add(btnReset, 1, 3);
		
		// Make space between nodes
		gPane.setVgap(5);
		gPane.setHgap(10);
		gPane.setAlignment(Pos.CENTER);
		
		btnCalculate.setOnAction(e -> calculateBMI());
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(gPane);
		
		// Create Scene
		Scene scene = new Scene(bPane, 250, 120);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BMI Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Calculate BMI
	private void calculateBMI() {
		// make sure there are no blank or un-entered values
		if (tf1.getText() != null && !tf1.getText().isEmpty()
				&& tf2.getText() != null && !tf2.getText().isEmpty()) {
			try {
				double weight = Double.parseDouble(tf1.getText());
				double height = Double.parseDouble(tf2.getText());

				double bmi = BmiCalculator.calculate(weight, height);
				BmiCategory category = BmiCategory.of(bmi);

				tf3.setText(String.format("%.1f - %s", bmi, category.label()));
			} catch (NumberFormatException | IllegalArgumentException ex) {
				tf3.setText("Invalid input");
			}
		} else {
			tf3.setText("Enter both values");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
