/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokagg.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Kim
 */
public class iMatController implements Initializable {

    
    @FXML private GridPane cartPane;
    
    @FXML private AnchorPane unknownPane;
    @FXML private AnchorPane checkoutPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    protected void cartCheckoutButton(ActionEvent event){
        
        checkoutPane.toFront();
    }
}
