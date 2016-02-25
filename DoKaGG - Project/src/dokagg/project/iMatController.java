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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Kim
 */
public class iMatController implements Initializable {

    private User user;
    
    // First-Account-Page
    @FXML private AnchorPane firstAccPane;
    @FXML private Button registerButton2;
    @FXML private TextField registerAdressNameField;
    @FXML private TextField registerAdressLNameField;
    @FXML private TextField registerAdressAdressField;
    @FXML private TextField registerAdressZipField;
    @FXML private TextField registerAdressCityField;
    @FXML private TextField registerAdressTelephoneField;
    @FXML private TextField registerAdressCellphoneField;
    @FXML private TextField registerLoginEmailField2;
    @FXML private TextField registerLoginEmailConfirmField;
    @FXML private TextField registerLoginPassField2;
    @FXML private TextField registerLoginPassConfirmField;
    
    
    // Login-Page
    @FXML private AnchorPane loginPane;
    @FXML private Button registerButton;
    
    
    // Main-Page
    @FXML private AnchorPane mainPane;
    @FXML private Label topUserName;
    @FXML private Button kontoRutaDetails;
    @FXML private Button kontoRutaLogOut;
    
    // Account-Page
    @FXML private AnchorPane accountPane;
    
    
    @FXML private GridPane cartPane;
    
    @FXML private AnchorPane unknownPane;
    @FXML private AnchorPane checkoutPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        firstAccPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // First-Account-Part
    @FXML
    private void createAccountButton(ActionEvent event){

        user.setFirstName(registerAdressNameField.getText());
        user.setLastName(registerAdressLNameField.getText());
        
        topUserName.setText(user.getFirstName() + " " + user.getLastName());
        
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // Login-window-part
    @FXML
    private void loginButton(ActionEvent event){
        
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // Main-window-part
    
    @FXML
    private void mainWindowLogoutButton(ActionEvent event){
        
        loginPane.toFront();
    }
    
    @FXML
    private void mainWindowAccButton(ActionEvent event){
        
        accountPane.toFront();
    }
    
    
    
    @FXML
    private void cartCheckoutButton(ActionEvent event){
        
        checkoutPane.toFront();
    }
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
}
