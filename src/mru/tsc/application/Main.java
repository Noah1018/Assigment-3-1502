package mru.tsc.application;
	
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import mru.tsc.controller.AppManager;


public class Main extends Application {
	
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/**
	 * Creating stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,870,470);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			

	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SecurityException, IOException {
		LogManager.getLogManager().reset();
		LOGR.setLevel(Level.ALL);
		FileHandler fh = new FileHandler("doc/myLog.log", true);
		fh.setLevel(Level.ALL);
		LOGR.addHandler(fh);
		fh.setFormatter(new SimpleFormatter());
		LOGR.log(Level.ALL, "Run Log");
		launch(args);
	}
	
}
