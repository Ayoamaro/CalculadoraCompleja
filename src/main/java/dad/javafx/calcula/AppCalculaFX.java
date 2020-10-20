package dad.javafx.calcula;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Ayoze Amaro
 *
 */
public class AppCalculaFX extends Application {

	private ComboBox<String> Combo;
	private TextField aReal, aImaginario, bReal, bImaginario, resultReal, resultImaginario;
	private Label aRealLabel, aImaginarioLabel, bRealLabel, bImaginarioLabel, resultRealLabel, resultImaginarioLabel;
	private Separator separator;
	
	private DoubleProperty primerReal = new SimpleDoubleProperty(0);
	private DoubleProperty primerImaginario = new SimpleDoubleProperty(0);
	private DoubleProperty segundoReal = new SimpleDoubleProperty(0);
	private DoubleProperty segundoImaginario = new SimpleDoubleProperty(0);
	private DoubleProperty finalReal = new SimpleDoubleProperty(0);
	private DoubleProperty finalImaginario = new SimpleDoubleProperty(0);
	
	@Override
	public void start(Stage primaryStage) throws Exception {

	// Primer Número
	HBox num1Box = new HBox(5);
	aReal = new TextField("0");
	aReal.setPrefColumnCount(3);
	aReal.setAlignment(Pos.CENTER);
	aImaginario = new TextField("0");
	aImaginario.setPrefColumnCount(3);
	aImaginario.setAlignment(Pos.CENTER);
	// Símbolos
	aRealLabel = new Label("+");
	aImaginarioLabel = new Label("i");

	num1Box.getChildren().addAll(aReal, aRealLabel, aImaginario, aImaginarioLabel);
	num1Box.setSpacing(5);
	num1Box.setAlignment(Pos.CENTER);

	// Segundo Número
	HBox num2Box = new HBox();
	bReal = new TextField("0");
	bReal.setPrefColumnCount(3);
	bReal.setAlignment(Pos.CENTER);
	bImaginario = new TextField("0");
	bImaginario.setPrefColumnCount(3);
	bImaginario.setAlignment(Pos.CENTER);
	// Símbolos
	bRealLabel = new Label("+");
	bImaginarioLabel = new Label("i");

	num2Box.getChildren().addAll(bReal, bRealLabel, bImaginario, bImaginarioLabel);
	num2Box.setAlignment(Pos.CENTER);
	num2Box.setSpacing(5);

	// Separador
	separator = new Separator();

	// Resultado
	HBox resultBox = new HBox(5);
	resultReal = new TextField("0");
	resultReal.setPrefColumnCount(3);
	resultReal.setDisable(true);
	resultReal.setAlignment(Pos.CENTER);
	resultImaginario = new TextField("0");
	resultImaginario.setPrefColumnCount(3);
	resultImaginario.setDisable(true);
	resultImaginario.setAlignment(Pos.CENTER);
	// Símbolos
	resultRealLabel = new Label("+");
	resultImaginarioLabel = new Label("i");

	resultBox.getChildren().addAll(resultReal, resultRealLabel, resultImaginario, resultImaginarioLabel);
	resultBox.setSpacing(5);
	resultBox.setAlignment(Pos.CENTER);

	// VBox con números
	VBox numBox = new VBox(5);
	numBox.getChildren().addAll(num1Box, num2Box, separator, resultBox);
	numBox.setAlignment(Pos.CENTER);

	// ComboBox con las operaciones
	Combo = new ComboBox<String>();
	Combo.getItems().addAll("+", "-", "*", "/");

	// VBox con ComboBox
	VBox operationBox = new VBox(5);
	operationBox.getChildren().add(Combo);
	operationBox.setAlignment(Pos.CENTER);

	// VBox principal
	HBox root = new HBox(5);
	root.getChildren().addAll(operationBox, numBox);
	root.setAlignment(Pos.CENTER);

	Scene scene = new Scene(root, 320, 200);
		
	primaryStage.setScene(scene);
	primaryStage.setTitle("CalculadoraView");
	primaryStage.show();
		
	// Binding primer operación
	Bindings.bindBidirectional(aReal.textProperty(), primerReal, new NumberStringConverter());
	Bindings.bindBidirectional(aImaginario.textProperty(), primerImaginario, new NumberStringConverter());
		
	// Binding segunda operación
	Bindings.bindBidirectional(bReal.textProperty(), segundoReal, new NumberStringConverter());
	Bindings.bindBidirectional(bImaginario.textProperty(), segundoImaginario, new NumberStringConverter());

	// Binding resultado
	Bindings.bindBidirectional(resultReal.textProperty(), finalReal, new NumberStringConverter());
	Bindings.bindBidirectional(resultImaginario.textProperty(), finalImaginario, new NumberStringConverter());

	Combo.valueProperty().addListener(e -> {
			
	// Escogemos el valor del ComboBox
	String seleccion = Combo.getValue();
	switch (seleccion) {
		// Suma
	        case "+":  
	        	finalReal.bind(primerReal.add(primerImaginario));
	    		finalImaginario.bind(segundoReal.add(segundoImaginario));
	       	 	break;
	        // Resta
	        case "-": 
	        	finalReal.bind(primerReal.subtract(primerImaginario));
	            	finalImaginario.bind(segundoReal.subtract(segundoImaginario));
	            	break;
	        // Multiplicación
	        case "*": 
	            	finalReal.bind(primerReal.multiply(segundoReal).subtract(primerImaginario.multiply(segundoImaginario)));
	            	finalImaginario.bind(primerReal.multiply(segundoImaginario).add(segundoReal.multiply(primerImaginario)));
	            	break;
	        // División
	        case "/":
	            	finalReal.bind(((primerReal.multiply(segundoReal).add(primerImaginario.multiply(segundoImaginario)))
						.divide(segundoReal.multiply(segundoReal).add(segundoReal.multiply(segundoReal)))));
	            	finalImaginario.bind(((segundoReal.multiply(primerImaginario).subtract(primerReal.multiply(segundoImaginario)))
	            		.divide(segundoReal.multiply(segundoReal).add(segundoReal.multiply(segundoReal)))));
	            	break;
	}		
	});	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
