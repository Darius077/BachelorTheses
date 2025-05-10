package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import repository.*;
import service.*;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));

        String url = "jdbc:sqlite:data/test_db.db";
        Repository repo = new Repository(url);
        Service service = new Service(repo);

        Controller controller = new Controller(service);
        loader.setController(controller);

        Scene scene = new Scene(loader.load(), 800, 600);
        stage.setTitle("GUI for App");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
