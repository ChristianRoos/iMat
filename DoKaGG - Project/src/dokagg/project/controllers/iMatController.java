package dokagg.project.controllers;

import dokagg.project.controllers.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.*;

import javafx.scene.control.Label;
/**
 *
 * @author Kim
 */
public class iMatController implements Initializable {
    private boolean loggedIn;
    
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
    @FXML private TextField registerLoginEmailField;
    @FXML private TextField registerLoginPassField;
    @FXML private Button registerButton;
    @FXML private Label kontoRutaName;
    
    
    // Main-Page
    @FXML private AnchorPane mainPane;
    @FXML private Label topUserName;
    @FXML private Button kontoRutaDetails;
    @FXML private Button kontoRutaLogOut;
    
    @FXML private Button categoryMeatButton;
    @FXML private Button categorySeaFoodButton;
    @FXML private Button categoryFruitButton;
    @FXML private Button categoryDairyButton;
    @FXML private Button categoryBreadButton;
    
    @FXML private Pane offersView1;
    @FXML private FlowPane specificCategoryList;
    @FXML private ObservableList<Pane> categoryItemList 
                    = FXCollections.observableArrayList();
    
    @FXML private GridPane cartPane;
    @FXML private TableView cartTableView;
    @FXML private Button cartButtonSave;
    @FXML private Button cartButton;
    @FXML private Text cartTotalCost;

    ShoppingCartListener scl;
    
    @FXML private TableColumn tableColName;
    @FXML private TableColumn tableColQuantity;
    @FXML private TableColumn tableColUnitPrice;
    @FXML private TableColumn tableColTotal;

    // Thumbnail-default
    @FXML private Button thumbButton;
    
    // Account-Page
    @FXML private AnchorPane accountPane;
    @FXML private Label accountAdressName;
    @FXML private Label accountAdressLName;
    @FXML private Label accountAdressAdress;
    @FXML private Label accountAdressZip;
    @FXML private Label accountAdressCity;
    @FXML private Label accountAdressTelephone;
    @FXML private Label accountAdressCellphone;
    @FXML private Label accountLogInEmail;
    @FXML private Label accountLogInPass;
    @FXML private Button accountAdressButton2;
    
    @FXML private Pane accountPayment1;
    @FXML private Pane accountPayment2;
    @FXML private Pane accountPayment3;
    @FXML private Pane accountLogIn1;
    @FXML private Pane accountLogIn2;
    @FXML private Pane accountAdress1;
    @FXML private Pane accountAdress2;
    
    
    @FXML private Button accountPaymentButtonChange;
    @FXML private Button accountPaymentButtonRemove;
    @FXML private Button accountPaymentButtonDone;
    @FXML private Button accountPaymentButtonAdd;
    @FXML private Button accountLogInButtonChange;
    @FXML private Button accountLogInButtonDone;
    @FXML private Button accountAdressButtonDone;
    @FXML private Button accountAdressButtonChange;
    
    @FXML private TextField accountPaymentCardField;
    @FXML private TextField accountPaymentMonthField;
    @FXML private TextField accountPaymentYearField;
    @FXML private TextField accountPaymentSecurityField;
    @FXML private TextField accountPaymentNameField;
    
    @FXML private Label accountPaymentCard1;
    @FXML private Label accountPaymentDate1;
    
    // Checkout-Page
    @FXML private AnchorPane checkoutPane;
    @FXML private Pane checkoutStep1;
    @FXML private Pane checkoutStep2;
    @FXML private Pane checkoutStep3;
    @FXML private Label step1TopLabel;
    @FXML private Label step2TopLabel;
    @FXML private Label step3TopLabel;
    @FXML private AnchorPane gzPane;
    
    
    // Checkout Step1
    @FXML private ScrollPane step1SPane;
    @FXML private Button checkoutGoBackButton;
    @FXML private Button step1Forward;
    @FXML private Label step1TotSum;
    @FXML private TableView step1Table;
    @FXML private TableColumn step1TableProduct;
    @FXML private TableColumn step1TableAmount;
    @FXML private TableColumn step1TablePrice;
    @FXML private TableColumn step1TableSum;
    @FXML private TableColumn step1TableRemove;
    
    
    
    
    // Checkout Step2
    @FXML private Pane step2Pane;
    @FXML private Button step2Forward;
    @FXML private Button step2Back;
    @FXML private Button step2GetAddButton;
    @FXML private TextField step2PNumber;
    @FXML private TextField step2FirstName;
    @FXML private TextField step2LastName;
    @FXML private TextField step2Address;
    @FXML private TextField step2PostalCode;
    @FXML private TextField step2City;
    @FXML private TextField step2Email;
    @FXML private TextField step2Phone;
    
    // Checkout Step3
    @FXML private Pane step3Pane;
    @FXML private Button step3Back;
    @FXML private Button step3Finish;
    @FXML private RadioButton step3RadioButton1;
    @FXML private RadioButton step3RadioButton2;
    @FXML private RadioButton step3RadioButton3;
    @FXML private RadioButton step3RadioButton4;
    @FXML private Label step3TotSum;
    @FXML private Label errorLabel;
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//      cartTableView.setStyle("-fx-table-border-color: transparent;");
//      cartTableView.borderProperty().isNull();

        //IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(scl);
        
//        percentageCol.setCellValueFactory(
//                new PropertyValueFactory<Recipe, Integer>("match"));

//        ShoppingItem shopItem = ;
        tableColName.setCellValueFactory(
          new PropertyValueFactory<Product, String>("product.name"));
        tableColQuantity.setCellValueFactory(
          new PropertyValueFactory<ShoppingItem, Double>("amount"));
//        tableColUnitPrice.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getProduct().getPrice())));
//        tableColTotal.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  String.valueOf(
//                          IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getTotal())));
    
//        cartTableView.getItems().setAll(IMatDataHandler.getInstance().getShoppingCart().getItems());
        mainPane.toFront();

    }
    
    // -----------------------------------------------------------------------
    // First account
    @FXML
    private void createAccountButton(){
        mainPane.toFront();
        //Login info
        int errors = 0;
        if(registerLoginEmailField2.getText().equals(registerLoginEmailConfirmField.getText())){
           IMatDataHandler.getInstance().getUser().setUserName(registerLoginEmailField2.getText()); 
        }
        else{
            errors++;
            System.out.println("Email does not match");
        }
        if(registerLoginPassField2.getText().equals(registerLoginPassConfirmField.getText())){
           IMatDataHandler.getInstance().getUser().setPassword(registerLoginPassField2.getText()); 
        }
        else{
            errors++;
            System.out.println("Password does not match");
        }
        
        //Address Info
        if(!registerAdressNameField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setFirstName(registerAdressNameField.getText());
        }
        else{errors++;}
        
        if(!registerAdressLNameField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setLastName(registerAdressLNameField.getText());
        }
        else{errors++;}
        
        if(!registerAdressAdressField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setAddress(registerAdressAdressField.getText());
        }
        else{errors++;}
        
        if(!registerAdressCityField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setPostAddress(registerAdressCityField.getText());
        }
        else{errors++;}
        
        if(!registerAdressZipField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setPostCode(registerAdressZipField.getText());
        }
        else{errors++;}
        
        if(!registerAdressCellphoneField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(registerAdressCellphoneField.getText());
        }
        else{errors++;}
        
        if(!registerAdressTelephoneField.getText().isEmpty()){
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber(registerAdressTelephoneField.getText());
        }
        else{errors++;}
        
        
        if (errors == 0) {
            kontoRutaDetails.setText("Kontouppgifter");
            kontoRutaLogOut.setText("Logga ut");
            mainPane.toFront();
            loggedIn = true;
            
            topUserName.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
            kontoRutaName.setText(IMatDataHandler.getInstance().getCustomer().getFirstName() + " " +IMatDataHandler.getInstance().getCustomer().getLastName());
            accountAdressTelephone.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
            accountAdressCellphone.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
            accountAdressCity.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
            accountAdressZip.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
            accountAdressAdress.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
            accountAdressLName.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
            accountAdressName.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
            accountLogInEmail.setText(IMatDataHandler.getInstance().getUser().getUserName());

        
        }
    }
    
    // -----------------------------------------------------------------------
    // Login window
    @FXML
    private void loginButton(){
        IMatDataHandler.getInstance().getUser().setUserName("Bengt");
        if(registerLoginEmailField.getText().equals(IMatDataHandler.getInstance().getUser().getUserName()) && 
                registerLoginPassField.getText().equals(IMatDataHandler.getInstance().getUser().getPassword()))
        {
        kontoRutaDetails.setText("Kontouppgifter");
        kontoRutaLogOut.setText("Logga ut");
        mainPane.toFront();
        loggedIn = true;
        }
    }
    
    // -----------------------------------------------------------------------
    // Main window
    
    @FXML
    private void mainWindowAccButton(){
        if (loggedIn == false) firstAccPane.toFront();
        else accountPane.toFront();
    }
    
    @FXML
    private void mainWindowLogoutButton(){
        if (loggedIn == true){
        mainPane.toFront();
        loggedIn = false; 
        kontoRutaDetails.setText("Registrera konto");
        kontoRutaLogOut.setText("Logga in");
        topUserName.setText("");
        kontoRutaName.setText("");
        } else
        {
           loginPane.toFront(); 
        }
    }
    @FXML
    private void accountPaymentAdd(){
        accountPayment1.toFront();
    }
    @FXML
    private void accountPaymentRemove(){
        accountPayment2.toFront();
    }
    @FXML
    private void accountPaymentChange(){
        accountPayment1.toFront();
    }
    @FXML
    private void accountPaymentDone(){
        accountPayment3.toFront();
        
        //IMatDataHandler.getInstance().getCreditCard().setCardNumber(accountPaymentCardField.getText());
        //IMatDataHandler.getInstance().getCreditCard().setHoldersName(accountPaymentNameField.getText());
        //IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(accountPaymentMonthField.getText()));
        //IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(accountPaymentYearField.getText()));
        //IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(accountPaymentSecurityField.getText()));
        
        
        accountPaymentCard1.setText( accountPaymentCardField.getText());
        accountPaymentDate1.setText( accountPaymentMonthField.getText() +"/"+ accountPaymentYearField.getText());
        System.out.println("error");
    }
    @FXML
    private void accountLoginChange(){
        accountLogIn1.toFront();
    }
    @FXML
    private void accountLoginDone(){
        accountLogIn2.toFront();
    }
    @FXML
    private void accountAdressChange(){
        accountAdress2.toFront();
    }
    @FXML
    private void accountAdressDone(){
        accountAdress1.toFront();
    }
    
    
    // Controller factory for thumbnail.
    private Pane thumbnailFactory(Product prod) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/productThumbnail.fxml"));
        Pane thumbnailProd = null;
        
        try {
            thumbnailProd = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ProductThumbnailController prodThumbCon = loader.getController();
        prodThumbCon.giveData(prod, this);

    return thumbnailProd;
   }
    
    @FXML
    private void mainWindowMeatCategoryButton() throws IOException{
        specificCategoryList.getChildren().clear();
        categoryItemList.clear();
        offersView1.toFront();  

        for (Product prod : IMatDataHandler.getInstance().getProducts(ProductCategory.MEAT)) {
            Pane thumbnailObj = thumbnailFactory(prod);
            
            categoryItemList.add(thumbnailObj);
        } 
        
        specificCategoryList.getChildren().addAll(categoryItemList);
    }
    
    @FXML
    public void updateShoppingCart(Product prod, double quantity){
        cartTableView.getItems().setAll(IMatDataHandler.getInstance().getShoppingCart().getItems());
//        cartTableView.get
        
//        cartTableView.getItems().setAll(IMatDataHandler.getInstance().getShoppingCart().getItems());
//        cartTableView.setItems(cartObserverList);
//        cartTableView.getColumns().addAll(tableColName,tableColQuantity, tableColUnitPrice, tableColTotal);

        cartTotalCost.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + " kr");

    }
    
    //instantiate the tableColumns in the ShoppingCart
    @FXML
    public void initializeShoppingCart() {
//        tableColName.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getProduct().getName()));
//        tableColQuantity.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  String.valueOf(
//                          IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getAmount())));
//        tableColUnitPrice.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getProduct().getPrice())));
//        tableColTotal.setCellValueFactory(
//          new PropertyValueFactory<>(
//                  String.valueOf(
//                          IMatDataHandler.getInstance().getShoppingCart().getItems().get(0).getTotal())));
    }
    
    @FXML
    private void testButton(){

    }

    
    @FXML
    private void addProductToCart(ActionEvent event){
      
      // Check if item already exists in the cart.
      // Change "null" into current object
      if(IMatDataHandler.getInstance().getShoppingCart().getItems().contains(null)) {
        IMatDataHandler.getInstance().getShoppingCart().addItem(null);
        
      } else {
        
      }
        cartTotalCost.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + " kr");
    }
    
    @FXML
    private void favoriteProduct(){
        //TODO
    }
    
    @FXML
    private void step3RadioButton1(){
        step3RadioButton1.selectedProperty().set(true);
        step3RadioButton2.selectedProperty().set(false);
        step3RadioButton3.selectedProperty().set(false);
        step3RadioButton4.selectedProperty().set(false);
    }
    
    @FXML
    private void step3RadioButton2(){
        step3RadioButton1.selectedProperty().set(false);
        step3RadioButton2.selectedProperty().set(true);
        step3RadioButton3.selectedProperty().set(false);
        step3RadioButton4.selectedProperty().set(false);
    }
    
    @FXML
    private void step3RadioButton3(){
        step3RadioButton1.selectedProperty().set(false);
        step3RadioButton2.selectedProperty().set(false);
        step3RadioButton3.selectedProperty().set(true);
        step3RadioButton4.selectedProperty().set(false);
    }
    
    @FXML
    private void step3RadioButton4(){
        step3RadioButton1.selectedProperty().set(false);
        step3RadioButton2.selectedProperty().set(false);
        step3RadioButton3.selectedProperty().set(false);
        step3RadioButton4.selectedProperty().set(true);
    }
    
    
    
    @FXML
    private void cartCheckoutButton(){
        checkoutPane.toFront();
        step1SPane.toFront();
        IMatDataHandler.getInstance().getShoppingCart().addProduct(IMatDataHandler.getInstance().getProducts().get(0));
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
    //
    // Step 1
    
    @FXML
    private void step1Forward(){
        step2Pane.toFront();
        //checkoutStep1.setStyle("#checkoutPaneColourWhite");
        step1TopLabel.setTextFill(Color.BLACK);
        
        //checkoutStep2.getStyleClass().remove("#checkoutPaneColourWhite");
        //checkoutStep2.getStyleClass().add("#niceColour");
        checkoutStep1.getStyleClass().clear();
        checkoutStep1.getStyleClass().add("checkoutPaneColourWhite");
        step1TopLabel.setTextFill(Color.BLACK);
        
        checkoutStep2.getStyleClass().clear();
        checkoutStep2.getStyleClass().add("niceColour");
        step2TopLabel.setTextFill(Color.WHITE);
    
        step2FirstName.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
        step2LastName.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
        step2Address.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
        step2PostalCode.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
        step2City.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        step2Email.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
        step2Phone.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        
        
        
        
    } 
   
    @FXML
    private void step2Forward(){
        step3Pane.toFront();
        //checkoutStep2.setStyle("#checkoutPaneColourWhite");
       step2TopLabel.setTextFill(Color.BLACK);
        
        //checkoutStep3.setStyle("#niceColour");
       checkoutStep2.getStyleClass().clear();
       checkoutStep2.getStyleClass().add("checkoutPaneColourWhite");
       step2TopLabel.setTextFill(Color.BLACK);
        
        checkoutStep3.getStyleClass().clear();
        checkoutStep3.getStyleClass().add("niceColour");
        step3TopLabel.setTextFill(Color.WHITE);
        errorLabel.visibleProperty().set(false);
    }
    
    @FXML
    private void step2Back(){
        step1SPane.toFront();
        //checkoutStep2.setStyle("#checkoutPaneColourWhite");
        step2TopLabel.setTextFill(Color.BLACK);
        
        //checkoutStep1.setStyle("#niceColour");
        checkoutStep2.getStyleClass().clear();
        checkoutStep2.getStyleClass().add("checkoutPaneColourWhite");
        step2TopLabel.setTextFill(Color.BLACK);
        
        checkoutStep1.getStyleClass().clear();
        checkoutStep1.getStyleClass().add("niceColour");
        step1TopLabel.setTextFill(Color.WHITE);
        

        
    }
    
    @FXML
    private void step3Back(){
        step2Pane.toFront();
       // checkoutStep3.setStyle("#checkoutPaneColourWhite");
        step3TopLabel.setTextFill(Color.BLACK);
        
        
       // checkoutStep2.setStyle("#niceColour");
        checkoutStep3.getStyleClass().clear();
        checkoutStep3.getStyleClass().add("checkoutPaneColourWhite");
        step3TopLabel.setTextFill(Color.BLACK);
        
        errorLabel.visibleProperty().set(false);
        checkoutStep2.getStyleClass().clear();
        checkoutStep2.getStyleClass().add("niceColour");
        step2TopLabel.setTextFill(Color.WHITE);
        
    }
    
    @FXML
    private void step3Finish(){
        if(step3RadioButton1.selectedProperty().getValue() || step3RadioButton2.selectedProperty().getValue()
                || step3RadioButton3.selectedProperty().getValue() || step3RadioButton4.selectedProperty().getValue()){
            errorLabel.visibleProperty().set(false);
            gzPane.toFront();
        }  
        else
            errorLabel.visibleProperty().set(true);
    }
    
    
    //
    // Step 2
    
    //
    // Step 3
    
    //
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
}
