package Board;

//import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.scene.transform.Rotate;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Board extends Application {

	private boolean selectedCard=false;
	private boolean selectedBall=false;
	
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
        card1.setPadding(new Insets(15));
        Label card1Name = new Label("Card 1");
        ImageView card1Pic = new ImageView("Karten/Karte_1.png");
        card1Pic.setPreserveRatio(true);
    	card1Pic.setFitHeight(150);
        card1.getChildren().addAll(card1Name, card1Pic);
        VBox card2 = new VBox();
        card2.setPadding(new Insets(15));
        Label card2Name = new Label("Card 2");
        ImageView card2Pic = new ImageView("Karten/Karte_2.png");
        card2Pic.setPreserveRatio(true);
    	card2Pic.setFitHeight(150);
    	card2.getChildren().addAll(card2Name, card2Pic);
        VBox card3 = new VBox();
        card3.setPadding(new Insets(15));
        Label card3Name = new Label("Card 3");
        ImageView card3Pic = new ImageView("Karten/Karte_3.png");
        card3Pic.setPreserveRatio(true);
    	card3Pic.setFitHeight(150);
    	card3.getChildren().addAll(card3Name, card3Pic);
        VBox card4 = new VBox();
        card4.setPadding(new Insets(15));
        Label card4Name = new Label("Card 4");
        ImageView card4Pic = new ImageView("Karten/Karte_4.png");
        card4Pic.setPreserveRatio(true);
    	card4Pic.setFitHeight(150);
    	card4.getChildren().addAll(card4Name, card4Pic);
        VBox card5 = new VBox();
        card5.setPadding(new Insets(15));
        Label card5Name = new Label("Card 5");
        ImageView card5Pic = new ImageView("Karten/Karte_5.png");
        card5Pic.setPreserveRatio(true);
    	card5Pic.setFitHeight(150);
    	card5.getChildren().addAll(card5Name, card5Pic);

        cardContainer.getChildren().addAll(card1, card2, card3, card4, card5);

        playerContainer.getChildren().addAll(player1, player2, player3, player4);

        //Testcode KUgeldingens TODO
        Pane pane=new Pane();
        Label test=new Label("O");
        	test.relocate(307, 307);
        
 
        
        Label test0 = new Label();
        test0.relocate(300,575);
        ImageView kugel = new ImageView("marbleBlue.png");
        
        	test0.setGraphic(kugel);
        	
        	//Hintergrund der Kugel beim Hovern
        	test0.setOnMouseEntered(e ->
        	{
        		if(selectedBall==false)
        		{
        			test0.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	test0.setOnMouseExited(e ->
        	{
        		if(selectedBall==false)
        		{
        			test0.setBackground(null);
        		}
        	});
        	
        	test0.setOnMouseClicked(e ->
        	{
        		if(selectedBall==false)
        		{
        			selectedBall=true;
        			test0.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			test0.setBackground(null);
        			selectedBall=false;
        		}
        	});
        	
        //Hardcode kommt später weg
        	//Hintergrund der Karten beim Hovern
        	card1.setOnMouseEntered(e ->
        	{
        		if(selectedCard==false)
        		{
        			card1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	card1.setOnMouseExited(e ->
        	{
        		if(selectedCard==false)
        		{
        			card1.setBackground(null);
        		}
        	});
        	
        	card1.setOnMouseClicked(e ->
        	{
        		if(selectedCard==false)
        		{
        			selectedCard=true;
        			card1.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			card1.setBackground(null);
        			card2.setBackground(null);
        			card3.setBackground(null);
        			card4.setBackground(null);
        			card5.setBackground(null);
        			selectedCard=false;
        		}
        	});
        	
        	//Hintergrund der Karten beim Hovern
        	card2.setOnMouseEntered(e ->
        	{
        		if(selectedCard==false)
        		{
        			card2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	card2.setOnMouseExited(e ->
        	{
        		if(selectedCard==false)
        		{
        			card2.setBackground(null);
        		}
        	});
        	
        	card2.setOnMouseClicked(e ->
        	{
        		if(selectedCard==false)
        		{
        			selectedCard=true;
        			card2.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			card1.setBackground(null);
        			card2.setBackground(null);
        			card3.setBackground(null);
        			card4.setBackground(null);
        			card5.setBackground(null);
        			selectedCard=false;
        		}
        	});
        	
        	//Hintergrund der Karten beim Hovern
        	card3.setOnMouseEntered(e ->
        	{
        		if(selectedCard==false)
        		{
        			card3.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	card3.setOnMouseExited(e ->
        	{
        		if(selectedCard==false)
        		{
        			card3.setBackground(null);
        		}
        	});
        	
        	card3.setOnMouseClicked(e ->
        	{
        		if(selectedCard==false)
        		{
        			selectedCard=true;
        			card3.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			card1.setBackground(null);
        			card2.setBackground(null);
        			card3.setBackground(null);
        			card4.setBackground(null);
        			card5.setBackground(null);
        			selectedCard=false;
        		}
        	});
        	
        	//Hintergrund der Karten beim Hovern
        	card4.setOnMouseEntered(e ->
        	{
        		if(selectedCard==false)
        		{
        			card4.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	card4.setOnMouseExited(e ->
        	{
        		if(selectedCard==false)
        		{
        			card4.setBackground(null);
        		}
        	});
        	
        	card4.setOnMouseClicked(e ->
        	{
        		if(selectedCard==false)
        		{
        			selectedCard=true;
        			card4.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			card1.setBackground(null);
        			card2.setBackground(null);
        			card3.setBackground(null);
        			card4.setBackground(null);
        			card5.setBackground(null);
        			selectedCard=false;
        		}
        	});
        	
        	//Hintergrund der Karten beim Hovern
        	card5.setOnMouseEntered(e ->
        	{
        		if(selectedCard==false)
        		{
        			card5.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(-3))));
        		}
        	});
        	
        	card5.setOnMouseExited(e ->
        	{
        		if(selectedCard==false)
        		{
        			card5.setBackground(null);
        		}
        	});
        	
        	card5.setOnMouseClicked(e ->
        	{
        		if(selectedCard==false)
        		{
        			selectedCard=true;
        			card5.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), new Insets(-3))));
        		}
        		else
        		{
        			card1.setBackground(null);
        			card2.setBackground(null);
        			card3.setBackground(null);
        			card4.setBackground(null);
        			card5.setBackground(null);
        			selectedCard=false;
        		}
        	});
        	
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