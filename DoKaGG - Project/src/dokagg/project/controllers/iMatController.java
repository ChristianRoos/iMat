package dokagg.project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
import javafx.scene.layout.HBox;

public class iMatController implements Initializable {
    private boolean loggedIn;
    
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
    
    // SearchBar
    @FXML private TextField searchProduct;
    
    // Favorites
    @FXML private Pane favoritesView;
    @FXML private HBox favoritesProductsPane;
    @FXML private ObservableList<Pane> favoriteItemList = FXCollections.observableArrayList();
    
    // Categories
    @FXML private Button categoryMeatButton;
    @FXML private Button categorySeaFoodButton;
    @FXML private Button categoryFruitButton;
    @FXML private Button categoryDairyButton;
    @FXML private Button categoryPantryButton;
    
    @FXML private Pane offersView1;
    @FXML private FlowPane specificCategoryList;
    @FXML private ObservableList<Pane> categoryItemList = FXCollections.observableArrayList();
    private ArrayList<ProductCategory> categoriesToSeeList = new ArrayList<>();
    private ArrayList<Product> unCategorizedProducts = new ArrayList<>();
    private ArrayList<Product> emptyUnCategoryList = new ArrayList<>();
    
    
    // ShoppingCart
    @FXML private AnchorPane mainViewShoppingCartShell;

    private static ShoppingCartController currentlyActiveShoppingCart;
    
    // HistoryView & SavedLists
    @FXML private Pane historyCartsView;
    @FXML private Pane savedShoppingCartsView;
    @FXML private HBox historyCartsViewList;
    @FXML private HBox savedShoppingCartsViewList;
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
        
        IMatDataHandler.getInstance().getShoppingCart().clear();
        currentlyActiveShoppingCart = shoppingCartFactory(null);
        mainViewShoppingCartShell.getChildren().add(currentlyActiveShoppingCart.cartPane); 

        mainPane.toFront();

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
        if (!cardClear(accountPaymentCardField.getText())) {
            accountPaymentErrors.setText("Kortnummer har angivits fel!");
        } else if (!monthClear(accountPaymentMonthField.getText())) {
            accountPaymentErrors.setText("Felaktigt månad!");
        } else if (!yearClear(accountPaymentYearField.getText())) {
            accountPaymentErrors.setText("Felaktigt årtal!");
        } else if (!securityNumberClear(accountPaymentSecurityField.getText())){
            accountPaymentErrors.setText("CVC är inkorrekt inmatad!");
        } else {
            accountPayment3.toFront();         
        
            IMatDataHandler.getInstance().getCreditCard().setCardNumber(accountPaymentCardField.getText());
            IMatDataHandler.getInstance().getCreditCard().setHoldersName(accountPaymentNameField.getText());
            IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(accountPaymentMonthField.getText()));
            IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(accountPaymentYearField.getText()));
            IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(accountPaymentSecurityField.getText()));
        
            accountPaymentErrors.setText("");
            accountPaymentCard1.setText( accountPaymentCardField.getText());
            accountPaymentDate1.setText( accountPaymentMonthField.getText() +"/"+ accountPaymentYearField.getText());
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
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategorySeafood() throws IOException{
      categoriesToSeeList.add(ProductCategory.FISH);
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
      
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryDairyEggCheese() throws IOException{
      categoriesToSeeList.add(ProductCategory.DAIRIES);
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryPantry() throws IOException{
      categoriesToSeeList.add(ProductCategory.BREAD);
      categoriesToSeeList.add(ProductCategory.SWEET);
      categoriesToSeeList.add(ProductCategory.FLOUR_SUGAR_SALT);
      categoriesToSeeList.add(ProductCategory.NUTS_AND_SEEDS);
      
      openCategoryView(emptyUnCategoryList);
    }
    
    @FXML
    private void showCategoryDrinks() throws IOException{
      unCategorizedProducts = (ArrayList) IMatDataHandler.getInstance().findProducts("milk");
      categoriesToSeeList.add(ProductCategory.HOT_DRINKS);
      categoriesToSeeList.add(ProductCategory.COLD_DRINKS);
      
      openCategoryView(unCategorizedProducts);
    }
    
    @FXML
    private void testButton(){

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
        // Check if the shoppingcart is empty
        if(IMatDataHandler.getInstance().getShoppingCart().getItems().size() > 0){
            
            // see if product we want to add already exist in shoppingcart,
            // in that case, increase the amount of same type you just bought.
            for(ShoppingItem shopItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
                
                if(shopItem.getProduct().getName().equals(prod.getName())) {
                    shopItem.setAmount(shopItem.getAmount() + quantity);
                    
                    currentlyActiveShoppingCart.findItem(prod).increaseQuantity(quantity);
                    currentlyActiveShoppingCart.cartTotalCost.setText(
                            String.valueOf(IMatDataHandler.getInstance().getShoppingCart().getTotal()));
                    return;
                }
            }
        }
        // The item didn't exist already
        IMatDataHandler.getInstance().getShoppingCart().addProduct(prod, quantity);
        currentlyActiveShoppingCart.addCartItem(prod, quantity, prodAsShopItem);
    }
     
    @FXML
    private void openHistoryView() {
        historyCartsViewList.getChildren().clear();
        
        for(ShoppingCartController shopCart : shoppingCartsHistory) {
            historyCartsViewList.getChildren().add(shopCart.cartPane);
        }
        
        historyCartsView.toFront();
    }

    @FXML
    public void openSavedShoppingCarts() {
        savedShoppingCartsViewList.getChildren().clear();

        for(ShoppingCartController shopCart : shoppingCartsSaved) {
            savedShoppingCartsViewList.getChildren().add(shopCart.cartPane);
        }
        
        savedShoppingCartsView.toFront();
    }
    
    // HOWTO add history from checkout
    // call shoppingCartsHistory.add(shoppingCartFactory(currentlyActiveShoppingCart.cartsItems)));
    
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
    
    
    
    @FXML
    public void cartCheckoutButton(ShoppingCartController shoppingCart){
        
        // -------------------------------------------------------------------------------------------------------- TODO
        // Change savedShoppingCartsViewList to correct Pane it is to be added to
        savedShoppingCartsViewList.getChildren().clear();
        savedShoppingCartsViewList.getChildren().add(shoppingCart.cartPane);

        
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
        
    }

    //
    // -----------------------------------------------------------------------
    //
    
    // -----------------------------------------------------------------------
    //
}
