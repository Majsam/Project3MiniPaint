package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicReference;

public class Controller {

	@FXML
	private Rectangle circleMode;

	@FXML
	private CheckBox filledChk;

	@FXML
	private Rectangle lineMode;

	@FXML
	private Circle menuCircle;

	@FXML
	private ColorPicker menuColorPick;

	@FXML
	private Button menuFontSelect;

	@FXML
	private Line menuLine;

	@FXML
	private CheckBox menuRainbowMode;

	@FXML
	private Rectangle menuRectangle;

	@FXML
	private Text menuText;

	@FXML
	private Pane pane;

	@FXML
	private Pane drawPane;

	@FXML
	private Rectangle rectMode;

	@FXML
	private Rectangle textMode;

	@FXML
	void circleMode(MouseEvent event) {
		currMode = "CIRCLE";
	}

	@FXML
	void createShape(MouseEvent e) {
		if (currMode.equals("LINE")) {
			drawPane.setOnMousePressed((MouseEvent event) -> {
				startX = event.getX();
				startY = event.getY();
				currentLine = new Line(startX, startY, startX, startY);
				currentLine.setStroke(menuColorPick.getValue());
				drawPane.getChildren().add(currentLine);
			});
			drawPane.setOnMouseDragged((MouseEvent event) -> {
				currentLine.setEndX(event.getX());
				currentLine.setEndY(event.getY());
			});
		}
		if (currMode.equals("TEXT")) {
			drawPane.setOnMousePressed((MouseEvent event) -> {
				TextField textField = new TextField();
				textField.setLayoutX(event.getX());
				textField.setLayoutY(event.getY());
				textField.prefColumnCountProperty().bind(textField.textProperty().length());
				textField.setAlignment(Pos.CENTER);
				textField.setStyle("-fx-text-fill: " + menuColorPick.getValue().toString());
				drawPane.getChildren().add(textField);
				textField.requestFocus();
			});
		}
	}

	@FXML
	void resizeShape(MouseEvent event) {
//		if (currMode == "LINE"){
//
//		} else if (currMode == "CIRCLE") {
//
//		} else if (currMode == "RECT") {
//
//		} else if (currMode == "TEXT") {
//
//		}
	}

	@FXML
	void getFont(ActionEvent event) {

	}

	@FXML
	void setRainbow() {
		double hue = 0
		Color color = null;
		new Thread(() -> {
			Thread.sleep(1000);
				hue = (hue.get() + 10) % 360;
				color.set(Color.hsb(hue.get(), 1, 1));
		}).start();
		menuColorPick.setValue(Color);
	}


//	private Color rainbow() {
//		int i = 0;
//		int j = 0;
//		int k = 0;
//
//		Color curColor = null;
//		while (menuRainbowMode.isSelected()) {
//			if (i == 0) {
//				while (i < 255) {
//					curColor = Color.rgb(i, j, k);
//					i += 5;
//				}
//				if (i == 255) {
//					while (j < 255) {
//						curColor = Color.rgb(i, j, k);
//						j += 5;
//					}
//				}
//				if (j == 255) {
//					while (k < 255) {
//						curColor = Color.rgb(i, j, k);
//						k += 5;
//					}
//				}
//			} else {
//				while (i > 0) {
//					curColor = Color.rgb(i, j, k);
//					i -= 5;
//				}
//				if (i == 0) {
//					while (j < 255) {
//						curColor = Color.rgb(i, j, k);
//						j -= 5;
//					}
//				}
//				if (j == 0) {
//					while (k < 255) {
//						curColor = Color.rgb(i, j, k);
//						k -= 5;
//					}
//				}
//			}
//		}
//		return curColor;
//	}

	@FXML
	void globalKeyEvents(KeyEvent event) {

	}

	@FXML
	void lineMode(MouseEvent e) {
		currMode = "LINE";
	}

	@FXML
	void rectMode(MouseEvent event) {
		currMode = "RECT";
	}

	@FXML
	void textMode(MouseEvent e) {
		currMode = "TEXT";
	}
	@FXML
	void updateColor(ActionEvent event) {
		menuCircle.setFill(menuColorPick.getValue());
		menuRectangle.setFill(menuColorPick.getValue());
	}


	String currMode = "";
	private double startX, startY;
	private Line currentLine;
}
