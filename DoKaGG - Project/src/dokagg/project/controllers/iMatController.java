package dokagg.project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.chalmers.ait.dat215.project.*;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class iMatController implements Initializable {
    private boolean loggedIn;
    private int favCounter;
    ////////////////////////////////////////////////////////////////////////////
    //// First-Account-Page
    //
    @FXML private Pane firstAccPane;
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
    @FXML private PasswordField registerLoginPassField2;
    @FXML private PasswordField registerLoginPassConfirmField;
    
    @FXML private Label registerAdressErrors;
    @FXML private Label registerLoginErrors;
    
    ////////////////////////////////////////////////////////////////////////////
    //// Login-Page
    //
    @FXML private Pane loginPane;
    @FXML private TextField registerLoginEmailField;
    @FXML private PasswordField loginPassField;
    @FXML private Button registerButton;
    @FXML private Label kontoRutaName;
    @FXML private Label loginErrors;
    
    ////////////////////////////////////////////////////////////////////////////
    //// Main-Page
    //
    @FXML private AnchorPane mainPane;
    @FXML private Label topUserName;
    @FXML private Button kontoRutaDetails;
    @FXML private Button kontoRutaLogOut;
    
    // HomePage, History & SavedLists
    @FXML private Button startPageButton;
    @FXML private Button favortiePageButton;
    @FXML private Button historyPageButton;

    // SearchBar
    @FXML private TextField searchProduct;
    
    // Favorites
    @FXML private Pane favoritesView;
    @FXML private FlowPane favoritesProductsPane;
    @FXML private ObservableList<Pane> favoriteItemList = FXCollections.observableArrayList();
    @FXML private ObservableList<Pane> offersItemList = FXCollections.observableArrayList();
    // Categories
    @FXML private Button categoryMeatButton;
    @FXML private Button categorySeaFoodButton;
    @FXML private Button categoryFruitButton;
    @FXML private Button categoryDairyButton;
    @FXML private Button categoryDrinkButton;
    @FXML private Button categoryPantryButton;
    @FXML private Button savedListsButton;
    private ArrayList<Button> categoryButtons = new ArrayList<>();
    
    @FXML private Pane offersView1;
    @FXML private Label categoryLabel;
    @FXML private FlowPane specificCategoryList;
    @FXML private ObservableList<Pane> categoryItemList = FXCollections.observableArrayList();
    private ArrayList<ProductCategory> categoriesToSeeList = new ArrayList<>();
    private ArrayList<Product> unCategorizedProducts = new ArrayList<>();
    private ArrayList<Product> emptyUnCategoryList = new ArrayList<>();
    
    
    // ShoppingCart
    @FXML private AnchorPane mainViewShoppingCartShell;

    private ShoppingCartController currentlyActiveShoppingCart;
    private ShoppingCartController checkoutShoppingCart;
    
    // HistoryView & SavedLists
    @FXML private Pane historyCartsView;
    @FXML private Pane savedShoppingCartsView;
    @FXML private FlowPane historyCartsViewList;
    @FXML private FlowPane savedShoppingCartsViewList;
    public static ArrayList<ShoppingCartController> shoppingCartsHistory = new ArrayList<>();
    public static ArrayList<ShoppingCartController> shoppingCartsSaved = new ArrayList<>();
    

    // Thumbnail
    @FXML private Button thumbButton;
    
    ////////////////////////////////////////////////////////////////////////////
    //// Account-Page
    //
    @FXML private Pane accountPane;
    @FXML private Label accountAdressName;
    @FXML private Label accountAdressLName;
    @FXML private Label accountAdressAdress;
    @FXML private Label accountAdressZip;
    @FXML private Label accountAdressCity;
    @FXML private Label accountAdressTelephone;
    @FXML private Label accountAdressCellphone;
    @FXML private Label accountLogInEmail;
    @FXML private Label accountLogInPass;
    @FXML private Label accountLogInErrors;
    @FXML private Label accountAdressErrors;
    @FXML private Label accountPaymentErrors;
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
    
    @FXML private RadioButton accountPaymentMasterCard;
    @FXML private RadioButton accountPaymentVisa;
    
    @FXML private TextField accountPaymentCardField;
    @FXML private TextField accountPaymentMonthField;
    @FXML private TextField accountPaymentYearField;
    @FXML private TextField accountPaymentSecurityField;
    @FXML private TextField accountPaymentNameField;
    @FXML private TextField accountLogInEmailField;
    @FXML private TextField accountAdressNameField;
    @FXML private TextField accountAdressLNameField;
    @FXML private TextField accountAdressAdressField;
    @FXML private TextField accountAdressZipField;
    @FXML private TextField accountAdressCityField;
    @FXML private TextField accountAdressCellphoneField;
    @FXML private TextField accountAdressTelephoneField;
    
    @FXML private PasswordField accountLogInPassField;
    @FXML private PasswordField accountLogInConfirmPassField;
    
    @FXML private Label accountPaymentCard1;
    @FXML private Label accountPaymentDate1;
    
    ////////////////////////////////////////////////////////////////////////////
    //// Checkout-Page
    //
    @FXML private Pane checkoutPane;
    @FXML private Pane checkoutStep1;
    @FXML private Pane checkoutStep2;
    @FXML private Pane checkoutStep3;
    @FXML private Label step1TopLabel;
    @FXML private Label step2TopLabel;
    @FXML private Label step3TopLabel;
    @FXML private AnchorPane gzPane;
    @FXML private Button gzBackToStartButton;
    @FXML private Button gzExitButton;
    
    // Checkout Step1
    @FXML private AnchorPane step1SPane;
    @FXML private Pane step1CartPane;
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
    @FXML private TextField step2Cellphone;
    
    
//Checkout Step2 Log in
    @FXML private Pane step2LoginPane;
    @FXML private Button step2LoginForward;
    @FXML private Button step2LoginBack;
    @FXML private Button step2LoginButton;
    @FXML private TextField step2LoginEmail;
    @FXML private PasswordField step2LoginPass;
    @FXML private TextField step2RegisterEmail;
    @FXML private TextField step2RegisterEmailConfirm;
    @FXML private PasswordField step2RegisterPass;
    @FXML private PasswordField step2RegisterPassConfirm;
    @FXML private TextField step2RegisterName;
    @FXML private TextField step2RegisterLName;
    @FXML private TextField step2RegisterAdress;
    @FXML private TextField step2RegisterZip;
    @FXML private TextField step2RegisterCity;
    @FXML private TextField step2RegisterTelephone;
    @FXML private TextField step2RegisterCellphone;
    @FXML private Label step2LoginErrors;
    @FXML private Label step2RegisterErrors;
    
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
    

    // Checkout Step4
    @FXML private Pane step4Pane;
    @FXML private Button step4Back;
    @FXML private Button step4Forward;
    @FXML private RadioButton step4Mastercard;
    @FXML private RadioButton step4Visa;
    @FXML private Label step4TotSum;
    @FXML private Label step4Errors;
    @FXML private TextField step4Name;
    @FXML private TextField step4CardNr;
    @FXML private TextField step4Month;
    @FXML private TextField step4Year;
    @FXML private TextField step4Security;
    @FXML private CheckBox step4SaveInfo;
    
        // Checkout Step4 Confirm
    @FXML private Pane step4ConfirmPane;
    @FXML private Button step4ConfirmBack;
    @FXML private Button step4ConfirmForward;
    @FXML private Button step4ConfirmChange;
    @FXML private Label step4ConfirmType;
    @FXML private Label step4ConfirmName;
    @FXML private Label step4ConfirmCardNr;
    @FXML private Label step4ConfirmDate;
    @FXML private Label step4ConfirmSecurity;
    @FXML private Label step4ConfirmTotSum;
    // StarView
    @FXML private Pane startView;
    @FXML private HBox startViewOffers;
    @FXML private HBox startViewFav;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IMatDataHandler.getInstance().getShoppingCart().clear();
        currentlyActiveShoppingCart = shoppingCartFactory(null);
        mainViewShoppingCartShell.getChildren().add(currentlyActiveShoppingCart.cartPane); 
        
        categoryButtons.add(startPageButton);
        categoryButtons.add(favortiePageButton);
        categoryButtons.add(historyPageButton);
        categoryButtons.add(savedListsButton);
        categoryButtons.add(categoryMeatButton);
        categoryButtons.add(categorySeaFoodButton);
        categoryButtons.add(categoryFruitButton);
        categoryButtons.add(categoryDairyButton);
        categoryButtons.add(categoryDrinkButton);
        categoryButtons.add(categoryPantryButton);

        mainPane.toFront();

        openStartView();
    }
    
    // -----------------------------------------------------------------------
    // First account
    @FXML
    private void createAccountButton(){
        //Login info
        String errorMessageAdress ="";
        String errorMessageRegister ="";
        if(!registerLoginEmailField2.getText().equals(registerLoginEmailConfirmField.getText()) || registerLoginEmailConfirmField.getText().isEmpty()){
             errorMessageRegister = errorMessageRegister + "Email stämmer ej överrens eller ej angivna. "; 
        }
        if(!registerLoginPassField2.getText().equals(registerLoginPassConfirmField.getText()) || registerLoginPassConfirmField.getText().isEmpty()){
           errorMessageRegister = errorMessageRegister + "Lösenord stämmer ej överens eller ej angivna. ";
        }
        //Address Info
        if(registerAdressNameField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Namn saknas. ";}
        if(registerAdressLNameField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Efternamn saknas. ";}
        if(registerAdressAdressField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Adress saknas. ";}
        if(registerAdressCityField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Stad saknas. ";}
        if(registerAdressZipField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Postnummer saknas. ";}
        if(registerAdressCellphoneField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Mobilnummer saknas. ";}
        if(registerAdressTelephoneField.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Telefonnummer saknas. ";}

        
        
        if (errorMessageAdress.isEmpty() && errorMessageRegister.isEmpty()) {
            
            IMatDataHandler.getInstance().getUser().setUserName(registerLoginEmailField2.getText());
            IMatDataHandler.getInstance().getUser().setPassword(registerLoginPassField2.getText()); 
            IMatDataHandler.getInstance().getCustomer().setEmail(registerLoginEmailField2.getText());
            IMatDataHandler.getInstance().getCustomer().setFirstName(registerAdressNameField.getText());
            IMatDataHandler.getInstance().getCustomer().setLastName(registerAdressLNameField.getText());
            IMatDataHandler.getInstance().getCustomer().setPostAddress(registerAdressCityField.getText());
            IMatDataHandler.getInstance().getCustomer().setPostCode(registerAdressZipField.getText());
            IMatDataHandler.getInstance().getCustomer().setAddress(registerAdressAdressField.getText());
            IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(registerAdressCellphoneField.getText());
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber(registerAdressTelephoneField.getText());
            
            kontoRutaDetails.setText("Kontouppgifter");
            kontoRutaLogOut.setText("Logga ut");
            mainPane.toFront();
            loggedIn = true;
            resetLabels();
            updateLabels();
            
        }
        else{
            registerAdressErrors.setText(errorMessageAdress);
            registerLoginErrors.setText(errorMessageRegister);
        }
    }
    
    // -----------------------------------------------------------------------
    // Login window
    @FXML
    private void loginButton(){
        String errorMessageLogin = "";
        if(registerLoginEmailField.getText().isEmpty()){
            errorMessageLogin="Email saknas. ";
        }
        if(loginPassField.getText().isEmpty()){
            errorMessageLogin= errorMessageLogin +"Lösenord saknas. ";
        }
        if(!registerLoginEmailField.getText().equals(IMatDataHandler.getInstance().getUser().getUserName())&&errorMessageLogin.isEmpty()){
             errorMessageLogin= errorMessageLogin +"Finns inget konto registrerat med den emailen";
        }
        if(!loginPassField.getText().equals(IMatDataHandler.getInstance().getUser().getPassword())&&errorMessageLogin.isEmpty()){
             errorMessageLogin= errorMessageLogin + "Email och lösenord matchar inte";
        }
        loginErrors.setText(errorMessageLogin);
        if(errorMessageLogin.isEmpty()){
        updateLabels();
        kontoRutaDetails.setText("Kontouppgifter");
        kontoRutaLogOut.setText("Logga ut");
        mainPane.toFront();
        loggedIn = true;
        registerLoginEmailField.setText("");
        loginPassField.setText("");
        openStartView();
        }
    }
    
    // -----------------------------------------------------------------------
    // Main window
    
    @FXML
    private void mainWindowAccButton(){
        if (loggedIn == false) firstAccPane.toFront();
        else {
            accountPane.toFront();
            if(IMatDataHandler.getInstance().getCreditCard().getCardNumber().isEmpty()){
                accountPayment2.toFront();
            }
            else accountPayment3.toFront();
        }
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
        resetLabels();
        updateLabels();
    }
    @FXML
    private void accountPaymentChange(){
        accountPayment1.toFront();
    }
       private boolean containDigits(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }  
        return true;
    }
    
    private boolean intLengthCheck(String card, int length) {
        boolean lengthCheck;
        lengthCheck = card.length() == length; 
        
        return lengthCheck;
    }
    
    private boolean intLimitClear(String fieldText, int min, int max) {
            
        return !(Integer.parseInt(fieldText) > max || Integer.parseInt(fieldText) < min);  
    }
    
    private boolean cardClear(String card) {
        return (containDigits(card) && intLengthCheck(card, 16));
    }
    
    private boolean monthClear(String month) {
        return (containDigits(month) && intLimitClear(month, 1, 12));
    }
    
    private boolean yearClear(String year) {
        return (containDigits(year) && intLimitClear(year, 0, 99));
    }
    
    private boolean securityNumberClear(String number) {
        return (containDigits(number) && intLengthCheck(number, 3));  
    }
    
    @FXML
    private void accountPaymentDone(){
        if(!accountPaymentMasterCard.isSelected() && !accountPaymentVisa.isSelected()){
            accountPaymentErrors.setText("Korttyp har inte angivits!");
        }
        else if ((accountPaymentNameField.getText().isEmpty())) {
            accountPaymentErrors.setText("Namn har inte angivits!");}
        else if (!cardClear(accountPaymentCardField.getText())) {
            accountPaymentErrors.setText("Kortnummer har angivits fel!");
        } else if (!monthClear(accountPaymentMonthField.getText())) {
            accountPaymentErrors.setText("Felaktigt månad!");
        } else if (!yearClear(accountPaymentYearField.getText())) {
            accountPaymentErrors.setText("Felaktigt årtal!");
        } else if (!securityNumberClear(accountPaymentSecurityField.getText())){
            accountPaymentErrors.setText("CVC är inkorrekt inmatad!");
        } else {
            accountPayment3.toFront();         
            
            if(accountPaymentMasterCard.isSelected()){IMatDataHandler.getInstance().getCreditCard().setCardType(accountPaymentMasterCard.getText());}
            else {IMatDataHandler.getInstance().getCreditCard().setCardType(accountPaymentVisa.getText());}
            IMatDataHandler.getInstance().getCreditCard().setCardNumber(accountPaymentCardField.getText());
            IMatDataHandler.getInstance().getCreditCard().setHoldersName(accountPaymentNameField.getText());
            IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(accountPaymentMonthField.getText()));
            IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(accountPaymentYearField.getText()));
            IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(accountPaymentSecurityField.getText()));
        
            accountPaymentErrors.setText("");
            
            updateLabels();
        } 
    }

    @FXML
    private void accountLoginChange(){
        accountLogIn1.toFront();
        accountLogInErrors.setText("Låt email vara oförändrad för att bara ändra lösenord eller låt lösenord vara tomt för att bara ändra email.");
    }
    @FXML
    private void accountLoginDone(){
        String errorMessageChangeLogin= "";
        if(!accountLogInPassField.getText().equals(accountLogInConfirmPassField.getText())){
            errorMessageChangeLogin= "Lösenord matchar inte. ";
        }
        if(accountLogInEmailField.getText().isEmpty()){
            errorMessageChangeLogin="Email måste vara ifylld. " +errorMessageChangeLogin;
        }
        if(errorMessageChangeLogin.isEmpty())
        {
            IMatDataHandler.getInstance().getUser().setUserName(accountLogInEmailField.getText());
            IMatDataHandler.getInstance().getCustomer().setEmail(accountLogInEmailField.getText());
            
            if (!accountLogInPassField.getText().isEmpty()){
                IMatDataHandler.getInstance().getUser().setPassword(accountLogInPassField.getText());
            }
            updateLabels();
            accountLogIn2.toFront();
        }
        else {accountLogInErrors.setText(errorMessageChangeLogin);}
    }
    @FXML
    private void accountAdressChange(){
        updateLabels();
        accountAdress1.toFront();
    }
    @FXML
    private void accountAdressDone(){
        String errorMessageChangeAdress= "";
        //Address Info
        if(accountAdressNameField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Namn saknas ";
        }
        if(accountAdressLNameField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Efternamn saknas ";
        }
        if(accountAdressAdressField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Adress saknas ";
        }
        if(accountAdressCityField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Stad saknas ";
        }
        if(accountAdressZipField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Postnummer saknas ";
        }
        if(accountAdressCellphoneField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Mobilnummer saknas ";
        }
        if(accountAdressTelephoneField.getText().isEmpty()){
            errorMessageChangeAdress = errorMessageChangeAdress +"Telefonnummer saknas ";
        }
        
        
        if (errorMessageChangeAdress.isEmpty()) {
        IMatDataHandler.getInstance().getCustomer().setFirstName(accountAdressNameField.getText());
        IMatDataHandler.getInstance().getCustomer().setLastName(accountAdressLNameField.getText());
        IMatDataHandler.getInstance().getCustomer().setAddress(accountAdressAdressField.getText());
        IMatDataHandler.getInstance().getCustomer().setPostAddress(accountAdressCityField.getText());
        IMatDataHandler.getInstance().getCustomer().setPostCode(accountAdressZipField.getText());
        IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(accountAdressCellphoneField.getText());
        IMatDataHandler.getInstance().getCustomer().setPhoneNumber(accountAdressTelephoneField.getText());
        
        accountAdress2.toFront();
        
        updateLabels();
        }
        else accountAdressErrors.setText(errorMessageChangeAdress);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //// The category,favorite-related methods
    //
    
    // thumbnailController factory.
    private Pane thumbnailFactory(Product prod) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dokagg/project/fxml/productThumbnail.fxml"));
        Pane thumbnailProd = null;
        
        try {
            thumbnailProd = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ProductThumbnailController prodThumbCon = loader.getController();
        prodThumbCon.initProdThumb(prod, this);

        return thumbnailProd;
   }
    
    @FXML
    private void searchMethod() throws IOException{
        specificCategoryList.getChildren().clear();
        categoryItemList.clear();
        offersView1.toFront();  

        for (Product prod : IMatDataHandler.getInstance().findProducts(searchProduct.getText())) {
            Pane thumbnailObj = thumbnailFactory(prod);
            
            categoryItemList.add(thumbnailObj);
        } 
        
        specificCategoryList.getChildren().addAll(categoryItemList);
    }
    
    @FXML
    private void openFavoriteView() throws IOException{
        favoritesProductsPane.getChildren().clear();
        favoriteItemList.clear();
        favoritesView.toFront();

        for (Product favProd : IMatDataHandler.getInstance().favorites()) {
            Pane thumbnailObj = thumbnailFactory(favProd);
            
            favoriteItemList.add(thumbnailObj);
        } 
        
        favoritesProductsPane.getChildren().addAll(favoriteItemList);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //// Show specific Category view
    //
    @FXML
    private void openCategoryView(ArrayList<Product> unCategorizedProducts) throws IOException {
      
      // Clearing lists/views below before using them.
      // The category-FlowPane
      specificCategoryList.getChildren().clear();
      // The actual list with all the objects which will be shown
      categoryItemList.clear();
      offersView1.toFront();  

      for (ProductCategory prodCate : categoriesToSeeList) {
        for (Product prod : IMatDataHandler.getInstance().getProducts(prodCate)) {
          Pane thumbnailObj = thumbnailFactory(prod);

          categoryItemList.add(thumbnailObj);
        }
      }
      for (Product prod : unCategorizedProducts) {
        Pane thumbnailObj = thumbnailFactory(prod);

        categoryItemList.add(thumbnailObj);
      }

      specificCategoryList.getChildren().addAll(categoryItemList);
      categoriesToSeeList.clear();
      unCategorizedProducts.clear();
    }
    
    @FXML
    private void showCategoryMeat() throws IOException{
      categoriesToSeeList.add(ProductCategory.MEAT);
      categoryLabel.setText("Kött & Chark");
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategorySeafood() throws IOException{
      categoriesToSeeList.add(ProductCategory.FISH);
      categoryLabel.setText("Fisk & Skaldjur");
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryFruitAndGreen() throws IOException{
      categoriesToSeeList.add(ProductCategory.BERRY);
      categoriesToSeeList.add(ProductCategory.CABBAGE);
      categoriesToSeeList.add(ProductCategory.CITRUS_FRUIT);
      categoriesToSeeList.add(ProductCategory.CITRUS_FRUIT);
      categoriesToSeeList.add(ProductCategory.FRUIT);
      categoriesToSeeList.add(ProductCategory.HERB);
      categoriesToSeeList.add(ProductCategory.MELONS);
      categoriesToSeeList.add(ProductCategory.NUTS_AND_SEEDS);
      categoriesToSeeList.add(ProductCategory.POD);
      categoriesToSeeList.add(ProductCategory.POTATO_RICE);
      categoriesToSeeList.add(ProductCategory.ROOT_VEGETABLE);
      categoriesToSeeList.add(ProductCategory.VEGETABLE_FRUIT);
      
      categoryLabel.setText("Frukt & Grönt");
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryDairyEggCheese() throws IOException{
      categoriesToSeeList.add(ProductCategory.DAIRIES);
      categoryLabel.setText("Mejeri, Ägg & Ost");
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryDrinks() throws IOException{
      unCategorizedProducts = (ArrayList) IMatDataHandler.getInstance().findProducts("milk");
      categoriesToSeeList.add(ProductCategory.HOT_DRINKS);
      categoriesToSeeList.add(ProductCategory.COLD_DRINKS);
      
      categoryLabel.setText("Dryck");
      openCategoryView(unCategorizedProducts);
    }
    
    @FXML
    private void showCategoryPantry() throws IOException{
      categoriesToSeeList.add(ProductCategory.BREAD);
      categoriesToSeeList.add(ProductCategory.SWEET);
      categoriesToSeeList.add(ProductCategory.FLOUR_SUGAR_SALT);
      categoriesToSeeList.add(ProductCategory.NUTS_AND_SEEDS);
      
      categoryLabel.setText("Skafferi");
      openCategoryView(emptyUnCategoryList);
    }
    
    
    // TODO
    // Method to highlight the last button you clicked (i.e. current view showing)
    private void highlightMenuButtons(Button inputButton) {
        
        for (Button button : categoryButtons) {
            /*
            Make all buttons in this array gray, except the one we send in as a parameter
            Pink:    #d31145
            Default: #e5e5e5
            */
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //// The shoppingCart methods
    //
    
    // ShoppingCart factory.
    public ShoppingCartController shoppingCartFactory(ArrayList<CartItemController> clonedCartList) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dokagg/project/fxml/shoppingCart.fxml"));
        GridPane shopCartPane = null;
        
        try {
            shopCartPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ShoppingCartController shopCartCont = loader.getController();
        shopCartCont.initShopCart(this, clonedCartList);
        
        

        return shopCartCont;
   }

    @FXML
    public void addProdToShoppingCart(Product prod, double quantity, ShoppingItem prodAsShopItem){
        
        // Have to do this first check to set the total-value correct
        if(currentlyActiveShoppingCart.cartsItems.size() == 0) {
            currentlyActiveShoppingCart.cartTotalCost.setText("0");
        }
        
        // Check if the shoppingcart is empty
        if(currentlyActiveShoppingCart.cartsItems.size() >0) {
            
            // see if product we want to add already exist in shoppingcart,
            // in that case, increase the amount of same type you just bought.
            for(CartItemController cartItem : currentlyActiveShoppingCart.cartsItems) {
                
                if(cartItem.getProduct().getName().equals(prod.getName())) {

                    double newQuantity = Double.valueOf(cartItem.getQuantity()) + quantity;
                    cartItem.setQuantity(newQuantity);
                    
//                    currentlyActiveShoppingCart.findItem(prod).setQuantity(quantity);
                    String oldTotal = currentlyActiveShoppingCart.cartTotalCost.getText();
                    currentlyActiveShoppingCart.cartTotalCost.setText(
                            String.valueOf(Double.valueOf(oldTotal) + prod.getPrice()*quantity));
                    return;
                }
            }
        }
        // The item didn't exist already
        String oldTotal = currentlyActiveShoppingCart.cartTotalCost.getText();
                    currentlyActiveShoppingCart.cartTotalCost.setText(
                            String.valueOf(Double.valueOf(oldTotal) + prod.getPrice()*quantity));
        currentlyActiveShoppingCart.addCartItem(prod, quantity, prodAsShopItem);
    }
     
    @FXML
    private void openHistoryView() {
        historyCartsViewList.getChildren().clear();
        
        // An ugly improvised way to avoid checking if cart already exist in the list.
        shoppingCartsHistory.clear();

        if(IMatDataHandler.getInstance().getOrders().get(0).getItems() != null){
            
            for(Order order : IMatDataHandler.getInstance().getOrders()){
                
                // first create an cart we will add stuff to
                ShoppingCartController shoppingCart = shoppingCartFactory(null);
                
                // Just some cart-look trimming.
                shoppingCart.cartButton.visibleProperty().set(false);
                shoppingCart.cartButton.disableProperty().set(true);
                
                // Then for every product inside the order, add them one by one
                // to the new cart.
                for(ShoppingItem shopItem : order.getItems()) {
                    shoppingCart.addCartItem(shopItem.getProduct(), shopItem.getAmount(), shopItem);
                }
                
                // Lastly add the newly created historyCart to our arrayList.
                shoppingCartsHistory.add(shoppingCart);
            }
        }
        
        for(ShoppingCartController shopCart : shoppingCartsHistory) {
            historyCartsViewList.getChildren().add(shopCart.cartPane);
        }
        historyCartsView.toFront();
        
        System.out.println(IMatDataHandler.getInstance().getOrders());
        
    }
  
    @FXML
    public void openSavedShoppingCarts() {
        savedShoppingCartsViewList.getChildren().clear();
        for(ShoppingCartController shopCart : shoppingCartsSaved) {
            savedShoppingCartsViewList.getChildren().add(shopCart.cartPane);
        }
        
        savedShoppingCartsView.toFront();
    }

    @FXML
    public void saveShoppingCart(ArrayList<CartItemController> cartsItems) {
        ArrayList<CartItemController> cloneBaby = new ArrayList<>(cartsItems);
        ShoppingCartController shoppingCart = shoppingCartFactory(cloneBaby);
        
        shoppingCart.cartButton.visibleProperty().set(false);
        shoppingCart.cartButton.disableProperty().set(true);
        
        shoppingCart.cartButtonSave.visibleProperty().set(false);
        shoppingCart.cartButtonSave.disableProperty().set(true);
        
        Button makeCurrentCart = new Button();
        
        shoppingCart.cartPane.add(makeCurrentCart, 0, 2);
        makeCurrentCart.setTranslateY(-93);
        makeCurrentCart.setTranslateX(78);
        makeCurrentCart.setPrefWidth(137);
        makeCurrentCart.setPrefHeight(34);
               
        makeCurrentCart.setText("Hämta varukorg");
        makeCurrentCart.setTextFill(Color.WHITE);
        makeCurrentCart.setAlignment(Pos.CENTER);
        makeCurrentCart.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
         
        makeCurrentCart.getStyleClass().clear();
        makeCurrentCart.getStyleClass().add("pinkBGColour");
      
     //   shoppingCart.cartScrollPane.getStyleClass().add("fancyGrey");
     //   shoppingCart.cartGreyPane.getStyleClass().add("fancyGrey");
    //    shoppingCart.cartGreyPane2.getStyleClass().add("fancyGrey");
    //    shoppingCart.cartList.getStyleClass().add("fancyGrey");
        
        shoppingCartsSaved.add(shoppingCart);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //// Checkout part
    //
    
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
    
    // Here is the only place we add stuff to the "IMatDataHandler.ShoppingCart
    // (This method is used in cartCheckoutButton)
    public void updateBackendShopCart(CartItemController cartItem) {
        
        // Check if the shoppingcart is empty
        if(IMatDataHandler.getInstance().getShoppingCart().getItems().size() > 0){

            // see if product we want to add already exist in shoppingcart,
            // in that case, increase the amount of same type you just bought.
            for(ShoppingItem shopItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {

                if(shopItem.getProduct().getName().equals(cartItem.getProduct().getName())) {

                    shopItem.setAmount(shopItem.getAmount() + Double.valueOf(cartItem.getQuantity()));

                    return;
                }
            }
        }
        // The item didn't exist already
        IMatDataHandler.getInstance().getShoppingCart().addProduct(cartItem.getProduct(), Double.valueOf(cartItem.getQuantity()));
    }
    
    @FXML
    public void cartCheckoutButton(ShoppingCartController shoppingCart){
        
        IMatDataHandler.getInstance().getShoppingCart().clear();
        
        // Set our checkoutCart to the this cart (for later use when we go back)
        checkoutShoppingCart = shoppingCart;
        
        // Clear checkout-pane to add the "activeCart"
        step1CartPane.getChildren().clear();
        step1CartPane.getChildren().add(shoppingCart.cartPane);
        
        for(CartItemController cartItem : shoppingCart.cartsItems) {
            updateBackendShopCart(cartItem);
        }
        

        step1TotSum.setText(String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getTotal())+" kr");
        step3TotSum.setText(String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getTotal())+" kr");
        step4ConfirmTotSum.setText(String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getTotal())+" kr");
        step4TotSum.setText(String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getTotal())+" kr");
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
        
        // Update our shop-cart with the changes (if any) made in our checkout-part.
        currentlyActiveShoppingCart.cartsItems = checkoutShoppingCart.cartsItems;
        
        // Have to clear the database-value, because we add to it when we enter the Checkout-panes.
        IMatDataHandler.getInstance().getShoppingCart().clear();
        mainPane.toFront();
    }
    //
    // Step 1
    
    @FXML
    private void step1Forward(){
        if(loggedIn){
        step2Pane.toFront();
        }
        else{step2LoginPane.toFront();}
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
        if(step3RadioButton1.selectedProperty().getValue()
                || step3RadioButton3.selectedProperty().getValue() || step3RadioButton4.selectedProperty().getValue()){
            
            IMatDataHandler.getInstance().placeOrder();
            
            errorLabel.visibleProperty().set(false);
            IMatDataHandler.getInstance().placeOrder();
            shoppingCartsHistory.add(shoppingCartFactory(currentlyActiveShoppingCart.cartsItems));
            gzPane.toFront();
        }  
        else if(step3RadioButton2.selectedProperty().getValue()){
            if(IMatDataHandler.getInstance().getCreditCard().getCardNumber().isEmpty()){
                step4Pane.toFront();
            }
            else step4ConfirmPane.toFront();
                
        }
        else {
            errorLabel.visibleProperty().set(true);
            errorLabel.setText("Du måste välja ett av alternativen ovan för att gå vidare!");

        }
    }
    
    @FXML
    private void gzBackToStartButton(){
        mainPane.toFront();
        checkoutStep3.getStyleClass().clear();
        checkoutStep3.getStyleClass().add("checkoutPaneColourWhite");
        step3TopLabel.setTextFill(Color.BLACK);
        
        checkoutStep1.getStyleClass().clear();
        checkoutStep1.getStyleClass().add("niceColour");
        // Eventuella clear av varukorg etc.
    }
    @FXML
    private void gzExitButton(){
        IMatDataHandler.getInstance().shutDown();
        System.exit(0);
    }
    private void updateLabels(){
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
        
        accountAdressNameField.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
        accountAdressLNameField.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
        accountAdressAdressField.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
        accountAdressZipField.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
        accountAdressCityField.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        accountAdressCellphoneField.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        accountAdressTelephoneField.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
        accountLogInEmailField.setText(IMatDataHandler.getInstance().getUser().getUserName());
        
        step2FirstName.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
        step2LastName.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
        step2Address.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
        step2PostalCode.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
        step2City.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        step2Email.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
        step2Phone.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
        step2Cellphone.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        
        accountPaymentCard1.setText( IMatDataHandler.getInstance().getCreditCard().getCardNumber());
        accountPaymentDate1.setText(  IMatDataHandler.getInstance().getCreditCard().getValidMonth() +"/"+  IMatDataHandler.getInstance().getCreditCard().getValidYear());
        step4ConfirmType.setText( IMatDataHandler.getInstance().getCreditCard().getCardType());
        step4ConfirmName.setText( IMatDataHandler.getInstance().getCreditCard().getHoldersName());
        step4ConfirmCardNr.setText( IMatDataHandler.getInstance().getCreditCard().getCardNumber());
        step4ConfirmDate.setText( IMatDataHandler.getInstance().getCreditCard().getValidMonth()+"/"+ IMatDataHandler.getInstance().getCreditCard().getValidYear());
    }
    private void resetLabels(){
        IMatDataHandler.getInstance().getCreditCard().setCardNumber("");
        IMatDataHandler.getInstance().getCreditCard().setCardType("");
        IMatDataHandler.getInstance().getCreditCard().setHoldersName("");
        IMatDataHandler.getInstance().getCreditCard().setValidMonth(0);
        IMatDataHandler.getInstance().getCreditCard().setValidYear(0);
        IMatDataHandler.getInstance().getCreditCard().setVerificationCode(0);
    }
    @FXML
    private void step2Register(){
        //Login info
        String errorMessageAdress ="";
        String errorMessageRegister ="";
        if(!step2RegisterEmail.getText().equals(step2RegisterEmailConfirm.getText()) || step2RegisterEmailConfirm.getText().isEmpty()){
             errorMessageRegister = errorMessageRegister + "Email stämmer ej överrens eller ej angivna. "; 
        }
        if(!step2RegisterPass.getText().equals(step2RegisterPassConfirm.getText()) || step2RegisterPassConfirm.getText().isEmpty()){
           errorMessageRegister = errorMessageRegister + "Lösenord stämmer ej överens eller ej angivna. ";
        }
        //Address Info
        if(step2RegisterName.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Namn saknas. ";}
        if(step2RegisterLName.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Efternamn saknas. ";}
        if(step2RegisterAdress.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Adress saknas. ";}
        if(step2RegisterCity.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Stad saknas. ";}
        if(step2RegisterZip.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Postnummer saknas. ";}
        if(step2RegisterCellphone.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Mobilnummer saknas. ";}
        if(step2RegisterTelephone.getText().isEmpty()){errorMessageAdress = errorMessageAdress + "Telefonnummer saknas. ";}

        
        
        if (errorMessageAdress.isEmpty() && errorMessageRegister.isEmpty()) {
            IMatDataHandler.getInstance().getUser().setUserName(step2RegisterEmail.getText());
            IMatDataHandler.getInstance().getUser().setPassword(step2RegisterPass.getText()); 
            IMatDataHandler.getInstance().getCustomer().setEmail(step2RegisterEmail.getText());
            IMatDataHandler.getInstance().getCustomer().setFirstName(step2RegisterName.getText());
            IMatDataHandler.getInstance().getCustomer().setLastName(step2RegisterLName.getText());
            IMatDataHandler.getInstance().getCustomer().setPostAddress(step2RegisterAdress.getText());
            IMatDataHandler.getInstance().getCustomer().setPostCode(step2RegisterZip.getText());
            IMatDataHandler.getInstance().getCustomer().setAddress(step2RegisterCity.getText());
            IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(step2RegisterCellphone.getText());
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber(step2RegisterTelephone.getText());
            
            kontoRutaDetails.setText("Kontouppgifter");
            kontoRutaLogOut.setText("Logga ut");
            step3Pane.toFront();
            loggedIn = true;
            resetLabels();
            updateLabels();
            
        }
        else{
            step2RegisterErrors.setText(errorMessageAdress+errorMessageRegister);
        }

    }
    @FXML
    private void step2Login(){
        String errorMessageLogin = "";
        if(step2LoginEmail.getText().isEmpty()){
            errorMessageLogin="Email saknas. ";
        }
        if(step2LoginPass.getText().isEmpty()){
            errorMessageLogin= errorMessageLogin +"Lösenord saknas. ";
        }
        if(!step2LoginEmail.getText().equals(IMatDataHandler.getInstance().getUser().getUserName())&&errorMessageLogin.isEmpty()){
             errorMessageLogin= errorMessageLogin +"Finns inget konto registrerat med den emailen";
        }
        if(!step2LoginPass.getText().equals(IMatDataHandler.getInstance().getUser().getPassword())&&errorMessageLogin.isEmpty()){
             errorMessageLogin= errorMessageLogin + "Email och lösenord matchar inte";
        }
        step2LoginErrors.setText(errorMessageLogin);
        if(errorMessageLogin.isEmpty()){
        updateLabels();
        kontoRutaDetails.setText("Kontouppgifter");
        kontoRutaLogOut.setText("Logga ut");
        step2Pane.toFront();
        loggedIn = true;
        step2LoginEmail.setText("");
        step2LoginPass.setText("");
        }

    }
    @FXML
    private void step4Back(){
        step3Pane.toFront();
    }
    @FXML
    private void step4Change(){
        step4Pane.toFront();
    }
    @FXML
    private void step4FinishPayment(){
        if(!step4Mastercard.isSelected() && !step4Visa.isSelected()){
            step4Errors.setText("Korttyp har inte angivits!");
        }
        else if ((step4Name.getText().isEmpty())) {
            step4Errors.setText("Namn har inte angivits!");}
        else if (!cardClear(step4CardNr.getText())) {
            step4Errors.setText("Kortnummer har angivits fel!");
        } else if (!monthClear(step4Month.getText())) {
            step4Errors.setText("Felaktigt månad!");
        } else if (!yearClear(step4Year.getText())) {
            step4Errors.setText("Felaktigt årtal!");
        } else if (!securityNumberClear(step4Security.getText())){
            step4Errors.setText("CVC är inkorrekt inmatad!");
        } else {
            if(step4SaveInfo.isSelected()){     
            
            if(step4Mastercard.isSelected()){IMatDataHandler.getInstance().getCreditCard().setCardType(step4Mastercard.getText());}
            else {IMatDataHandler.getInstance().getCreditCard().setCardType(step4Visa.getText());}
            IMatDataHandler.getInstance().getCreditCard().setCardNumber(step4CardNr.getText());
            IMatDataHandler.getInstance().getCreditCard().setHoldersName(step4Name.getText());
            IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(step4Month.getText()));
            IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(step4Year.getText()));
            IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(step4Security.getText()));
            updateLabels();
            }
            step4Errors.setText("");
            IMatDataHandler.getInstance().placeOrder();
            shoppingCartsHistory.add(shoppingCartFactory(currentlyActiveShoppingCart.cartsItems));
            gzPane.toFront();
        } 
    }
    @FXML
    private void step4Finish(){  
            IMatDataHandler.getInstance().placeOrder();
            shoppingCartsHistory.add(shoppingCartFactory(currentlyActiveShoppingCart.cartsItems));
            gzPane.toFront();
    }
    @FXML
    private void openStartView(){
        
        Random randomizer = new Random();
        startViewFav.getChildren().clear();
        favoriteItemList.clear();
        startViewOffers.getChildren().clear();
        offersItemList.clear();
        startView.toFront();
        if(loggedIn){
        for (int j = 0; j<5;) {
            if(j<IMatDataHandler.getInstance().favorites().size()){
            Product favProd = IMatDataHandler.getInstance().favorites().get(j);
            Pane thumbnailObj = thumbnailFactory(favProd);
            favoriteItemList.add(thumbnailObj);
            }
            j++;
            
        }}
        for (int i = 0; i<5;) {
            
            Product offerProd = IMatDataHandler.getInstance().getProducts().get(randomizer.nextInt(IMatDataHandler.getInstance().getProducts().size()));
            Pane thumbnailObj = thumbnailFactory(offerProd);
            offersItemList.add(thumbnailObj);
            i++;
        } 
        favCounter = favoriteItemList.size();
        startViewOffers.getChildren().addAll(offersItemList);
        startViewFav.getChildren().addAll(favoriteItemList);
    }
    @FXML
    private void offersLeft(){
        Random randomizer = new Random();
        startViewOffers.getChildren().clear();
        offersItemList.clear();
        for (int i = 0; i<5;) {
            
            Product offerProd = IMatDataHandler.getInstance().getProducts().get(randomizer.nextInt(IMatDataHandler.getInstance().getProducts().size()));
            Pane thumbnailObj = thumbnailFactory(offerProd);
            offersItemList.add(thumbnailObj);
            i++;
        } 
        startViewOffers.getChildren().addAll(offersItemList);
    }
    @FXML
    private void offersRight(){
        Random randomizer = new Random();
        startViewOffers.getChildren().clear();
        offersItemList.clear();
        for (int i = 0; i<5;) {
            
            Product offerProd = IMatDataHandler.getInstance().getProducts().get(randomizer.nextInt(IMatDataHandler.getInstance().getProducts().size()));
            Pane thumbnailObj = thumbnailFactory(offerProd);
            offersItemList.add(thumbnailObj);
            i++;
        } 
        startViewOffers.getChildren().addAll(offersItemList);
    }
    @FXML
    private void favoritesLeft(){
        if(favCounter>=10){
        startViewFav.getChildren().clear();
        favoriteItemList.clear();
        for (int j = favCounter-10; j<favCounter-5;) {
            if(j<IMatDataHandler.getInstance().favorites().size()){
            Product favProd = IMatDataHandler.getInstance().favorites().get(j);
            Pane thumbnailObj = thumbnailFactory(favProd);
            favoriteItemList.add(thumbnailObj);
            }
            j++;
            
        }
        favCounter = favCounter - 5;
        startViewFav.getChildren().addAll(favoriteItemList);
        }

    }
    @FXML
    private void favoritesRight(){
        if(favCounter<IMatDataHandler.getInstance().favorites().size()){
        startViewFav.getChildren().clear();
        favoriteItemList.clear();
        for (int j = favCounter; j<favCounter+5;) {
            if(j<IMatDataHandler.getInstance().favorites().size()){
            Product favProd = IMatDataHandler.getInstance().favorites().get(j);
            Pane thumbnailObj = thumbnailFactory(favProd);
            favoriteItemList.add(thumbnailObj);
            }
            j++;
            
        }
        favCounter = favCounter + 5;
        startViewFav.getChildren().addAll(favoriteItemList);
        }
    }
    

    //
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
}
