import Board.Board;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TAC_GUI extends Application {

	Image startLogo = new Image("flower2.png");
	ImageView iv_startLogo= new ImageView(startLogo);
	Functions functions=new Functions();
	TextField tf_login = new TextField();
	Alert alert = new Alert(AlertType.ERROR);
	
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
		Button btn_opt = new Button("Optionen");
		Button btn_end = new Button("Beenden");
		
		
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
			hboxBottom.getChildren().addAll(l_reg,btn_reg,btn_opt,btn_end);
			

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
		
		btn_opt.setOnAction(e -> {
			drawOptPane(stage);
		});
		
		btn_end.setOnAction(e -> {
			Platform.exit();
		});
		
		//Login durchführen
		btn_login.setOnAction(e->
		{
			if(functions.correctLoginFunctions(tf_login.getText(), tf_password.getText())==true)
			{
				//Auf die nächste Oberfläche wechseln
				System.out.println(functions.showNameFunctions(tf_login.getText()));
				drawLobby(stage);
			}
			else
			{
				alert.setTitle("Hinweis");
		        alert.setHeaderText("Fehlermeldung:");
		        alert.setContentText("Login fehlerhaft");	 
		        alert.showAndWait();
			}
		});
		
		stage.getIcons().add(new Image("file:src/Karten/Karte_100.png"));
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
		Button btn_next = new Button("Fertig");
		
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
				if(functions.usernameExistsFunctions(tf_regUsername.getText())==false)
				{
					functions.registerFunctions(tf_regUsername.getText(), tf_regShownName.getText(), tf_regPassword.getText());
					try {
						start(stage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					tf_login.setText(tf_regUsername.getText());
				}
				else
				{
					alert.setTitle("Hinweis");
			        alert.setHeaderText("Fehlermeldung:");
			        alert.setContentText("Der Benutzer existiert schon");	 
			        alert.showAndWait();
				}
			}
			else
			{
		        alert.setTitle("Hinweis");
		        alert.setHeaderText("Fehlermeldung:");
		        alert.setContentText("Die Passwortwiederholung ist fehlerhaft");	 
		        alert.showAndWait();
			}
		});
		
		Scene scene = new Scene(pane);
		stage.setTitle("TAC - Registrieren");
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	// Zeichnet das Optionenfenster
	public void drawOptPane(Stage stage) {
			
			BorderPane pane = new BorderPane();
			
			Label l_colorscheme = new Label("Farbschema");
			Label l_carddesign = new Label("Kartendesign");
			
			ComboBox<String> cb_colorscheme = new ComboBox<>();
			ComboBox<String> cb_carddesign= new ComboBox<>();
			
			//Inhalte der ComboBoxen
			cb_colorscheme.getItems().addAll("Beispiel1", "Beispiel2");
			cb_colorscheme.setValue(cb_colorscheme.getItems().get(0));
			cb_carddesign.getItems().addAll("Beispiel1", "Beispiel2", "Beispiel3");
			cb_carddesign.setValue(cb_carddesign.getItems().get(0));
			
			cb_colorscheme.setOnAction(e->
			{
				//Ändern des Farbschemas
			});
			
			cb_carddesign.setOnAction(e->
			{
				//Ändern des Kartendesigns
			});
			
			Button btn_back = new Button("Zurück");
			
			VBox vbox = new VBox();
				vbox.getChildren().addAll(l_colorscheme, cb_colorscheme, l_carddesign, cb_carddesign);
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
				hboxBottom.getChildren().addAll(btn_back);
			
			// Zurückbutton zeichnet wieder die Start-Pane
			btn_back.setOnAction(e->{
				try {
					start(stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			pane.setRight(vboxRight);
			pane.setLeft(vboxLeft);
			pane.setTop(hboxTop);
			pane.setBottom(hboxBottom);
			pane.setCenter(vbox);
			
			Scene scene = new Scene(pane);
			stage.setTitle("TAC - Optionen");
			stage.sizeToScene();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
	}
	
	public void drawLobby(Stage stage) {
		
	BorderPane pane = new BorderPane();
		
		Label l_greet = new Label("Wilkommen "+ functions.showNameFunctions(tf_login.getText()));
			l_greet.setPadding(new Insets(0,0,50,0));
			l_greet.setFont(new Font(24));
			
		Button btn_host = new Button("Spiel Hosten");
			btn_host.setMinWidth(100);
		Button btn_join = new Button("Spiel beitreten");
			btn_join.setMinWidth(100);
		Button btn_logout = new Button("Abmelden");
			btn_logout.setMinWidth(100);
		Button btn_quit = new Button("Beenden");
			btn_quit.setMinWidth(100);
		
		VBox vbox = new VBox();
			vbox.getChildren().addAll(l_greet,btn_host,btn_join,btn_logout,btn_quit);
			vbox.setAlignment(Pos.TOP_CENTER);
			vbox.setSpacing(10);
		
		VBox vboxLeft = new VBox();
			vboxLeft.setPadding(new Insets(150));
			
			
		VBox vboxRight = new VBox();
			vboxRight.setPadding(new Insets(150));
			
			
		HBox hboxTop = new HBox();
			hboxTop.setPadding(new Insets(100));
			hboxTop.setAlignment(Pos.TOP_LEFT);
			iv_startLogo.setScaleX(0.5);
			iv_startLogo.setScaleY(0.5);
			hboxTop.getChildren().addAll(iv_startLogo);
		
		
		HBox hboxBottom = new HBox();
			hboxBottom.setPadding(new Insets(30));
			hboxBottom.setAlignment(Pos.BASELINE_RIGHT);
			hboxBottom.setSpacing(10);
			
		
		pane.setRight(vboxRight);
		pane.setLeft(vboxLeft);
		pane.setTop(hboxTop);
		pane.setBottom(hboxBottom);
		pane.setCenter(vbox);

		btn_host.setOnAction(e -> {
			try {
				new Board().start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btn_logout.setOnAction(e -> {
			try {
				start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btn_quit.setOnAction(e -> {
			Platform.exit();
		});
		
		Scene scene = new Scene(pane);
		stage.setTitle("TAC - Lobby");
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}