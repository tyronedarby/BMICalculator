// Author: Tyrone Darby
// Date Created: May 11, 2026


package bmi;

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
		if (tf1.getText() != null && !tf2.getText().isEmpty() && tf1.getText() != null && !tf2.getText().isEmpty()) {
			double weight = Double.parseDouble(tf1.getText());
			double height = Double.parseDouble(tf2.getText());
			String category = "";
			
			double bmi = weight / Math.pow(height, 2);
			
			if(bmi < 18.5) {
				category = "Underweight";
			} else if(bmi >= 18.5 && bmi <= 24.9) {
				category = "Normal";
			} else if(bmi >= 25.0 && bmi <= 29.9) {
				category = "Overweight";
			} else {
				category = "Obese";
			}
			
			tf3.setText(String.format("%.1f - %s", bmi, category));
		} else {
			tf3.setText("Enter both values");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
