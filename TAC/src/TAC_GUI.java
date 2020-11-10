import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TAC_GUI extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		

		Image startLogo = new Image("flower2.png");
		ImageView iv_startLogo= new ImageView(startLogo);
		
		BorderPane pane = new BorderPane();
		
		Label l_login = new Label("Username");
		Label l_password = new Label("Password");
		Label l_reg = new Label("Noch nicht registriert? ");
		
		Button btn_login = new Button("Login");
		Button btn_reg = new Button("Registrieren");
		
		TextField tf_login = new TextField();
			tf_login.setMaxWidth(130);
		
		TextField tf_password = new TextField();
			tf_password.setMaxWidth(130);
			
		VBox vbox = new VBox();
			vbox.getChildren().addAll(l_login,tf_login,l_password,tf_password,btn_login);
			vbox.setAlignment(Pos.TOP_CENTER);
			vbox.setSpacing(10);
			
		VBox vboxLeft = new VBox();
			vboxLeft.setPadding(new Insets(150));
			
		VBox vboxRight = new VBox();
			vboxRight.setPadding(new Insets(150));
			
		HBox hboxTop = new HBox();
			hboxTop.setPadding(new Insets(100));
			hboxTop.getChildren().add(iv_startLogo);
			hboxTop.setAlignment(Pos.CENTER);
			
		HBox hboxBottom = new HBox();
			hboxBottom.setPadding(new Insets(30));
			hboxBottom.setAlignment(Pos.BASELINE_RIGHT);
			hboxBottom.getChildren().addAll(l_reg,btn_reg);
		

		pane.setRight(vboxRight);
		pane.setLeft(vboxLeft);
		pane.setTop(hboxTop);
		pane.setBottom(hboxBottom);
		pane.setCenter(vbox);
		
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		        tf_login.requestFocus();
		    }
		});
		
		Scene scene = new Scene(pane);
		
		stage.setTitle("TAC - Start");
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

}
