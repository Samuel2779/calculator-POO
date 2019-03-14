import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Main extends Application{
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
        buttons[i] = new Button("" + i );
        buttons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    }

    Button AC = new Button("AC");
    AC.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    Button Plus = new Button("+");
    Plus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    Button Minus = new Button("-");
    Minus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    Button Times = new Button("*");
    Times.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    Button Divided = new Button("/");
    Divided.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
    Button Equals = new Button("=");
    Equals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );

    gp.add( AC, 0, 0, 4, 1 );
    gp.add( buttons[7], 0, 1 ); gp.add( buttons[8], 1, 1 ); gp.add( buttons[9], 2, 1 ); gp.add( Times,   3, 1 );
    gp.add( buttons[4], 0, 2 ); gp.add( buttons[5], 1, 2 ); gp.add( buttons[6], 2, 2 ); gp.add( Divided, 3, 2 );
    gp.add( buttons[1], 0, 3 ); gp.add( buttons[2], 1, 3 ); gp.add( buttons[3], 2, 3 ); gp.add( Minus,   3, 3 );
    gp.add( buttons[0], 0, 4, 2, 1 );                       gp.add( Equals,     2, 4 ); gp.add( Plus,    3, 4 );

    //hacer los botones.setEventHandler(MouseEvent.MOUSE_CLICKED, new BotonCalculadorHandler());

    gp.setHgap(1);
    gp.setVgap(1);

    //el valor del result tiene que ser global para que también lo puedan usar en todos los métodos
    Label result = new Label("result");

    bp.setTop(result);
    bp.setCenter(gp);

    //NO ME FUNCIONO XD ES PARA QUE APAREZCA EN EL TOP RIGHT
    //bp.setAlignment(result,Pos.TOP_RIGHT);

    Scene scene = new Scene(bp, 150, 150);
    primaryStage.setScene(scene);
    primaryStage.show();

	}

}
