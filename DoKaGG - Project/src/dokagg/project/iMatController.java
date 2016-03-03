/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokagg.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.*;

/**
 *
 * @author Kim
 */
public class iMatController implements Initializable {
    
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
    @FXML private Button registerButton;
    
    
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
//    @FXML private ObservableList<Productt> cartObserverList 
//            = FXCollections.observableArrayList();
    ShoppingCartListener scl;
    
    @FXML private TableColumn tableColName;
    @FXML private TableColumn tableColQuantity;
    @FXML private TableColumn tableColUnitPrice;
    @FXML private TableColumn tableColTotal;
    
    // Thumbnail-default
    @FXML private Button thumbButton;
    
    // Account-Page
    @FXML private AnchorPane accountPane;
    
    // Checkout-Page
    @FXML private AnchorPane checkoutPane;
    @FXML private Pane checkoutStep1;
    @FXML private Pane checkoutStep2;
    @FXML private Pane checkoutStep3;
    @FXML private Label step1TopLabel;
    @FXML private Label step2TopLabel;
    @FXML private Label step3TopLabel;
    
    
    // Checkout Step1
    @FXML private ScrollPane step1SPane;
    @FXML private Button checkoutGoBackButton;
    @FXML private Button step1Forward;
    @FXML private Label step1TotSum;
    @FXML private GridPane step1Grid;
    
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
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//      cartTableView.setStyle("-fx-table-border-color: transparent;");
//      cartTableView.borderProperty().isNull();

        //IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(scl);
        
//        percentageCol.setCellValueFactory(
//                new PropertyValueFactory<Recipe, Integer>("match"));

//        ShoppingItem shopItem = ;
        tableColName.setCellValueFactory(
          new PropertyValueFactory<ShoppingItem, String>("product.name"));
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
        
//        RecipeDatabase db = RecipeDatabase.getSharedInstance();
//        List<Recipe> recipes = db.search(sf);
//        tableView.getItems().setAll(recipes);
    }
    
    // -----------------------------------------------------------------------
    // First account
    @FXML
    private void createAccountButton(){
        mainPane.toFront();
    }
    
    // -----------------------------------------------------------------------
    // Login window
    @FXML
    private void loginButton(){
        
        IMatDataHandler.getInstance().getUser().setUserName("Bengt");
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
    
    // Controller factory for thumbnail.
    private Pane thumbnailFactory(Product prod) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("productThumbnail.fxml"));
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
        
        System.out.println(tableColName.getCellData(0));
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
    private void cartCheckoutButton(){
        
        checkoutPane.toFront();
        step1SPane.toFront();
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
        step2TopLabel.setTextFill(Color.WHITE);
        
    } 
   
    @FXML
    private void step2Forward(){
        step3Pane.toFront();
        //checkoutStep2.setStyle("#checkoutPaneColourWhite");
       step2TopLabel.setTextFill(Color.BLACK);
        
        //checkoutStep3.setStyle("#niceColour");
        step3TopLabel.setTextFill(Color.WHITE);
        
    }
    
    @FXML
    private void step2Back(){
        step1SPane.toFront();
        //checkoutStep2.setStyle("#checkoutPaneColourWhite");
        step2TopLabel.setTextFill(Color.BLACK);
        
        //checkoutStep1.setStyle("#niceColour");
        step1TopLabel.setTextFill(Color.WHITE);
        
    }
    
    @FXML
    private void step3Back(){
        step2Pane.toFront();
       // checkoutStep3.setStyle("#checkoutPaneColourWhite");
        step3TopLabel.setTextFill(Color.BLACK);
        
        
       // checkoutStep2.setStyle("#niceColour");
        step2TopLabel.setTextFill(Color.WHITE);
        
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