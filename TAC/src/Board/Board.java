package Board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Board extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 600);

        VBox playerContainer = new VBox();

        VBox player1 = new VBox();
        Label player1Name = new Label("Player 1 (YOU)");
        player1.getChildren().addAll(player1Name);

        VBox player2 = new VBox();
        Label player2Name = new Label("Player 2 (YOU)");
        player2.getChildren().addAll(player2Name);

        VBox player3 = new VBox();
        Label player3Name = new Label("Player 3 (YOU)");
        player3.getChildren().addAll(player3Name);

        VBox player4 = new VBox();
        Label player4Name = new Label("Player 4 (YOU)");
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

        ImageView boardImage = new ImageView("Board/board.jpg");
        borderPane.setCenter(boardImage);
        borderPane.setLeft(playerContainer);
        borderPane.setBottom(cardContainer);

        primaryStage.setTitle("TAC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
