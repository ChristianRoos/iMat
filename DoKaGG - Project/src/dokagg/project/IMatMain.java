package dokagg.project;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;

public class IMatMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/dokagg/project/fxml/iMat.fxml"));
        
        Scene scene = new Scene(root, 1366, 768);
        
        stage.setTitle("iMat");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                IMatDataHandler.getInstance().shutDown();
        }
        });
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
