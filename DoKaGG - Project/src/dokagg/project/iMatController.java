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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.*;

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
    @FXML private FlowPane specificCategoryList;
    
    @FXML private Button categoryMeatButton;
    @FXML private Button categorySeaFoodButton;
    @FXML private Button categoryFruitButton;
    @FXML private Button categoryDairyButton;
    @FXML private Button categoryBreadButton;
    
    @FXML private Button cartButton;
    
    // Account-Page
    @FXML private AnchorPane accountPane;
    
    
    @FXML private GridPane cartPane;
    
    @FXML private AnchorPane unknownPane;
    
    // Checkout-Page
    @FXML private AnchorPane checkoutPane;
    @FXML private Button checkoutGoBackButton;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        IMatDataHandler iMatDataHandler;
        Customer customer;
        
        user = new User();
        firstAccPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // First account
    @FXML
    private void createAccountButton(){

        user.setFirstName(registerAdressNameField.getText());
        user.setLastName(registerAdressLNameField.getText());
        
        topUserName.setText(user.getFirstName() + " " + user.getLastName());
        
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // Login window
    @FXML
    private void loginButton(){
        
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // Main window
    
        @FXML
    private void mainWindowAccButton(){
        accountPane.toFront();
    }
    
    @FXML
    private void mainWindowLogoutButton(){
        loginPane.toFront();
    }
    
    @FXML
    private void mainWindowMeatCategoryButton(){
    }
    
    @FXML
    private void cartCheckoutButton(){
        
        checkoutPane.toFront();
    }
    // -----------------------------------------------------------------------
    // Account window
    @FXML
    private void accountExitButton(){
        
        mainPane.toFront();
    }
    
    
    // -----------------------------------------------------------------------
    // Checkout window
    
    @FXML
    private void checkoutGoBackButton(){
        
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
}
