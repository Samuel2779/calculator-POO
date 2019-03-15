import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.*;

public class Main extends Application{



	private double result2=0.0;
	private Label result;
	private boolean firstClick=false;
	private String last="";

	public static void main(String[] args){
		launch(args);
	}

	


	public void start(Stage primaryStage){
		



			primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setTitle("CalculMameitor");


	    BorderPane bp = new BorderPane();
	    GridPane gp = new GridPane();


	    Button[] buttons = new Button[10];

	    for( int i=0; i<buttons.length; i++ ) {
	        buttons[i] = new Button("" + i);
	        buttons[i].setId("" + i);
	        buttons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    }

	    Button ac = new Button("AC");
	    ac.setId("AC");
	    ac.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    Button plus = new Button("+");
	    plus.setId("+");
	    plus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    Button minus = new Button("-");
	    minus.setId("-");
	    minus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    Button times = new Button("*");
	    times.setId("*");
	    times.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    Button divided = new Button("/");
	    divided.setId("/");
	    divided.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
	    Button equals = new Button("=");
	     equals.setId("=");
	    equals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );

	    gp.add( ac, 0, 0, 4, 1 );
	    buttons[7].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[7], 0, 1 );
	    buttons[8].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[8], 1, 1 ); 
	  	buttons[9].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[9], 2, 1 );
	    buttons[4].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[4], 0, 2 );
	    buttons[5].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[5], 1, 2 );
		buttons[6].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[6], 2, 2 );
	    buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[1], 0, 3 ); 
	   	buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[2], 1, 3 );
	   	buttons[3].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[3], 2, 3 );
	    buttons[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());
	    gp.add( buttons[0], 0, 4, 2, 1 ); 
	    //operators
	    minus.addEventHandler(MouseEvent.MOUSE_CLICKED,new BotonCalculadorOperationHandler());
	    gp.add( minus,   3, 3 );
	    divided.addEventHandler(MouseEvent.MOUSE_CLICKED,new BotonCalculadorOperationHandler());
	    gp.add( divided, 3, 2 );
	    times.addEventHandler(MouseEvent.MOUSE_CLICKED,new BotonCalculadorOperationHandler());
	    gp.add( times,   3, 1 );
	    plus.addEventHandler(MouseEvent.MOUSE_CLICKED,new BotonCalculadorOperationHandler());
	    gp.add( plus,    3, 4 );
	    //resultado
	    equals.addEventHandler(MouseEvent.MOUSE_CLICKED,new BotonCalculadoraResultadoHandler());	                     
	    gp.add( equals,     2, 4 );

	    //hacer los botones.setEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());

	    gp.setHgap(1);
	    gp.setVgap(1);

	    //el valor del result tiene que ser global para que también lo puedan usar en todos los métodos
	  	result = new Label(result2 + "");

	    bp.setTop(result);
	    bp.setCenter(gp);

	    //NO ME FUNCIONO XD ES PARA QUE APAREZCA EN EL TOP RIGHT
	    //bp.setAlignment(result,Pos.TOP_RIGHT);

	    Scene scene = new Scene(bp, 150, 150);
	    primaryStage.setScene(scene);
	    primaryStage.show();

	}
	public class BotonCalculadorHandler implements EventHandler<MouseEvent>{
		public void handle(MouseEvent e){
			if(!firstClick){
				result.setText("");
				firstClick=true;
			}
			Control c= (Control)e.getSource();
			result.setText(result.getText()+c.getId());
			System.out.println(c.getId());
		
		}
	}
	public class BotonCalculadorOperationHandler implements EventHandler<MouseEvent>{
		public void handle(MouseEvent e){
			Control c= (Control)e.getSource();
			switch(c.getId()){
				case "+":
					last="+";
					result2=Double.parseDouble(result.getText());
					result.setText("0.0");
					firstClick=false;
					break;
				case "-":
					last="-";
					result2=Double.parseDouble(result.getText());
					result.setText("0.0");
					firstClick=false;
					break;
				case "*":
					last="*";
					result2=Double.parseDouble(result.getText());
					result.setText("0.0");
					firstClick=false;
					break;
				case "/":
					last="/";
					result2=Double.parseDouble(result.getText());
					result.setText("0.0");
					firstClick=false;
					break;
				case "AC":
					last="AC";
					result2=Double.parseDouble(result.getText());
					result.setText("0.0");
					firstClick=false;
					break;	

			}
		}
	}	
	public class BotonCalculadoraResultadoHandler implements EventHandler<MouseEvent>{
		public void handle(MouseEvent e){
			switch(last){
				case "+":
					result2=result2+Double.parseDouble(result.getText());
					result.setText(result2+"");
					break;
				case "-":
					result2=result2-Double.parseDouble(result.getText());
					result.setText(result2+"");
					break;
				case "*":	
					result2=result2*Double.parseDouble(result.getText());
					result.setText(result2+"");
					break;
				case "/":
					result2=result2/Double.parseDouble(result.getText());
					result.setText(result2+"");
					break;
				case "AC":
					result.setText(0.0 + "");
			}
		}
	}	






	
			


}