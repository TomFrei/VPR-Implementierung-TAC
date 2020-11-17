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

	Image startLogo = new Image("flower2.png");
	ImageView iv_startLogo= new ImageView(startLogo);
	Functions functions=new Functions();

	@Override
	public void start(Stage stage) throws Exception {
		

		startLogo = new Image("flower2.png");
		iv_startLogo= new ImageView(startLogo);
		
		BorderPane pane = new BorderPane();
		
		Label l_login = new Label("Username");
		Label l_password = new Label("Password");
		Label l_reg = new Label("Noch nicht registriert? ");
		
		Button btn_login = new Button("Login");
		Button btn_reg = new Button("Registrieren");
		Button btn_end = new Button("Beenden");
		
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
		
		// Setzt den Fokus auf das Username Texfeld bei Start
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		        tf_login.requestFocus();
		    }
		});
		
		Scene scene = new Scene(pane);
		
		
		btn_reg.setOnAction(e -> {
			drawRegPane(stage);
		});
		
		//Login durchführen
		btn_login.setOnAction(e->
		{
			if(functions.correctLoginFunctions(tf_login.getText(), tf_password.getText())==true)
			{
				//Auf die nächste Oberfläche wechseln
			}
			else
			{
				//Meldung anzeigen ("Diesen Benutzer gibt es nicht")
			}
		});
		
		stage.setTitle("TAC - Start");
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	// Zeichnet das Registrierungsfenster
	public void drawRegPane(Stage stage) {
		
		BorderPane pane = new BorderPane();
		
		Label l_regUsername = new Label("Username");
		Label l_regShwonName = new Label("Anzeigename");
		Label l_password = new Label("Passwort");
		Label l_passwordRepeat = new Label("Passwort wiederholen");
		
		TextField tf_regUsername = new TextField();
		TextField tf_regShownName = new TextField();
		TextField tf_regPassword = new TextField();
		TextField tf_regPasswordRepeat = new TextField();
		
		Button btn_back = new Button("Zurück");
		Button btn_next = new Button("Weiter");
		
		VBox vbox = new VBox();
			vbox.getChildren().addAll(l_regUsername,tf_regUsername,l_regShwonName,tf_regShownName,l_password,tf_regPassword,l_passwordRepeat,tf_regPasswordRepeat);
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
			hboxBottom.setSpacing(10);
			hboxBottom.getChildren().addAll(btn_back,btn_next);
		
		pane.setRight(vboxRight);
		pane.setLeft(vboxLeft);
		pane.setTop(hboxTop);
		pane.setBottom(hboxBottom);
		pane.setCenter(vbox);
		
		// Zurückbutton zeichnet wieder die Start-Pane
		btn_back.setOnAction(e->{
			try {
				start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		//Button zum registrieren
		btn_next.setOnAction(e->
		{
			//Passwort = Passwortwiederholung?
			if(tf_regPassword.getText().equals(tf_regPasswordRepeat.getText())==true)
			{
				functions.registerFunctions(tf_regUsername.getText(), tf_regShownName.getText(), tf_regPassword.getText());
			}
		});
		
		Scene scene = new Scene(pane);
		stage.setTitle("TAC - Registrieren");
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}