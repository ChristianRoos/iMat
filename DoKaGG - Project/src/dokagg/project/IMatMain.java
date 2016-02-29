package dokagg.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import se.chalmers.ait.dat215.project.*;

public class IMatMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("iMat.fxml"));
        
        Scene scene = new Scene(root, 1366, 768);
        
        stage.setTitle("iMat");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        
        IMatDataHandler.getInstance(); // TODO
        launch(args);
    }
}
