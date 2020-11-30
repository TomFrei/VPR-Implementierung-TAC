package Board;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BoardMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UTILITY);



        stage.setTitle("Tac");
        stage.setScene(scene);
        stage.show();
    }
}
