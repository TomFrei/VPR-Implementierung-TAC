package Board;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.scene.transform.Rotate;


public class Board extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);

        VBox playerContainer = new VBox();

        VBox player1 = new VBox();
        Label player1Name = new Label("Player 1 (YOU)");
        player1.getChildren().addAll(player1Name);

        VBox player2 = new VBox();
        Label player2Name = new Label("Player 2");
        player2.getChildren().addAll(player2Name);

        VBox player3 = new VBox();
        Label player3Name = new Label("Player 3");
        player3.getChildren().addAll(player3Name);

        VBox player4 = new VBox();
        Label player4Name = new Label("Player 4");
        player4.getChildren().addAll(player4Name);

        HBox cardContainer = new HBox();
        
        VBox card1 = new VBox();
        Label card1Name = new Label("Card 1");
        card1.getChildren().addAll(card1Name);
        VBox card2 = new VBox();
        Label card2Name = new Label("Card 2");
        card2.getChildren().addAll(card2Name);
        VBox card3 = new VBox();
        Label card3Name = new Label("Card 3");
        card3.getChildren().addAll(card3Name);
        VBox card4 = new VBox();
        Label card4Name = new Label("Card 4");
        card4.getChildren().addAll(card4Name);

        cardContainer.getChildren().addAll(card1, card2, card3, card4);

        playerContainer.getChildren().addAll(player1, player2, player3, player4);

        //Testcode KUgeldingens TODO
        Pane pane=new Pane();
        Label test=new Label("O");
        	test.relocate(307, 307);
        
 
        
        Label test0 = new Label();
        	test0.relocate(300,575);
        ImageView kugel = new ImageView("marbleBlue.png");
        
    
        	test0.setGraphic(kugel);
        	
        	//Kugel skalieren
        	kugel.setPreserveRatio(true);
        	kugel.setFitHeight(16);
        	
        	Label[] kugelFelder = new Label[64];
        	kugelFelder[0] = test0;
        	
       	     
        	
        ImageView boardImage = new ImageView("Board/board.jpg");        
        //Boardmitte x=307 y=307
        
       
        pane.getChildren().addAll(boardImage,test,test0);

   
        
        borderPane.setCenter(pane);
        borderPane.setLeft(playerContainer);
        borderPane.setBottom(cardContainer);
        
        
        
        primaryStage.setTitle("TAC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
