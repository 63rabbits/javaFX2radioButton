package javaFX2radioButton;

import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RadioButtonController {

	@FXML
	private RadioButton rdb01;
	@FXML
	private RadioButton rdb02;
	@FXML
	private ToggleGroup rdbgroup;
	@FXML
	private TextField txf01;
	@FXML
	private TextField txf02;

	@FXML
	private RadioButton rdb01LBind;
	@FXML
	private RadioButton rdb02LBind;
	@FXML
	private ToggleGroup rdbLBgroup;
	@FXML
	private TextField txf01LBind;
	@FXML
	private TextField txf02LBind;

	private Image imgWin;
	private Image imgMac;

	private String win = "Windows";
	private String osx = "OS X";

	@FXML
	void initialize() {
		imgWin = new Image(this.getClass().getResourceAsStream("res/ms.png"));
		imgMac = new Image(this.getClass().getResourceAsStream("res/apple.png"));

		// Using Event Handler
		assert rdb01 != null : "fx:id=\"rdb01\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert rdb02 != null : "fx:id=\"rdb02\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert txf01 != null : "fx:id=\"txf01\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert txf02 != null : "fx:id=\"txf02\" was not injected: check your FXML file 'RadioButton.fxml'.";
		this.rdb01.setGraphic(new ImageView(imgWin));
		this.rdb02.setGraphic(new ImageView(imgMac));
		this.rdb01.setUserData(win);
		this.rdb02.setUserData(osx);
		this.rdb01.setSelected(true);
		this.txf01.setText(((RadioButton) this.rdbgroup.getSelectedToggle()).getText());
		this.txf02.setText((String) this.rdbgroup.getSelectedToggle().getUserData());

		// Using Bind (Hight-level API)

		// Using Bind (Low-level API)
		assert rdb01LBind != null : "fx:id=\"rdb01LBind\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert rdb02LBind != null : "fx:id=\"rdb02LBind\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert txf01LBind != null : "fx:id=\"txf01LBind\" was not injected: check your FXML file 'RadioButton.fxml'.";
		assert txf02LBind != null : "fx:id=\"txf02LBind\" was not injected: check your FXML file 'RadioButton.fxml'.";
		this.rdb01LBind.setGraphic(new ImageView(imgWin));
		this.rdb02LBind.setGraphic(new ImageView(imgMac));
		this.rdb01LBind.setUserData(win);
		this.rdb02LBind.setUserData(osx);
		this.rdb01LBind.setSelected(true);
		this.txf01LBind.textProperty().bind(this.observer01(rdbLBgroup));
		this.txf02LBind.textProperty().bind(this.observer02(rdbLBgroup));
	}

	// Using Event Handler
	@FXML
	void rdbOnAction(ActionEvent event) {
		this.txf01.setText(((RadioButton) this.rdbgroup.getSelectedToggle()).getText());
		this.txf02.setText((String) this.rdbgroup.getSelectedToggle().getUserData());
	}

	// Using Bind (Hight-level API)

	// Using Bind (Low-level API)
	private ObjectBinding<String> observer01(ToggleGroup p) {
		final ToggleGroup tgg = p;
		ObjectBinding<String> sBinding = new ObjectBinding<String>() {
			{
				super.bind(tgg.selectedToggleProperty());
			}

			@Override
			protected String computeValue() {
				return ((RadioButton) tgg.getSelectedToggle()).getText();
			}
		};
		return sBinding;
	}

	private ObjectBinding<String> observer02(ToggleGroup p) {
		final ToggleGroup tgg = p;
		ObjectBinding<String> sBinding = new ObjectBinding<String>() {
			{
				super.bind(tgg.selectedToggleProperty());
			}

			@Override
			protected String computeValue() {
				return (String) ((RadioButton) tgg.getSelectedToggle()).getUserData();
			}
		};
		return sBinding;
	}
}
