package dokagg.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
<<<<<<< HEAD
=======
import javafx.scene.text.Text;
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class CartItemController {
    
<<<<<<< HEAD
    @FXML private ImageView cartItemDelete;
    @FXML private Image removeImage;
    @FXML private Label cartItemName;
    @FXML private TextField cartItemAmountField;
    @FXML private ImageView quantityImageView;
    @FXML private Image quantityImage;
    @FXML private Label cartItemPricePer;
    @FXML private Label cartItemTotal;
=======
    @FXML private ImageView removeButton;
    @FXML private Image removeImage;
    @FXML private Text name;
    @FXML private TextField quantityTextField;
    @FXML private ImageView quantityImageView;
    @FXML private Image quantityImage;
    @FXML private Text price;
    @FXML private Text totalCost;
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
    
    @FXML private ShoppingCartController shoppingCart;
    @FXML private Product prod;
    private ShoppingItem prodAsShopItem;
    
    @FXML 
    public void giveData(ShoppingCartController shoppingCart, Product prod, double quantity, ShoppingItem prodAsShopItem) {
        this.shoppingCart = shoppingCart;
        this.prodAsShopItem = prodAsShopItem;
        this.prod = prod;

<<<<<<< HEAD
//        removeImage  = new Image(getClass()
//        .getResourceAsStream("/dokagg/project/resources/images/secondCross.jpg"));
//        cartItemDelete.setImage(removeImage);
        
//        quantityImage  = new Image(getClass()
//        .getResourceAsStream("/dokagg/project/resources/images/styck.png"));
//        quantityImageView.setImage(quantityImage);
//        quantityImageView.toFront();
        
        cartItemName.setText(prod.getName());
        cartItemAmountField.setText(String.valueOf(quantity));
        cartItemPricePer.setText(String.valueOf(prod.getPrice()));
        cartItemTotal.setText(String.valueOf(prod.getPrice()*quantity));
=======
        removeImage  = new Image(getClass()
        .getResourceAsStream("/dokagg/project/resources/images/cross.png"));
        removeButton.setImage(removeImage);
        
        quantityImage  = new Image(getClass()
        .getResourceAsStream("/dokagg/project/resources/images/styck.png"));
        quantityImageView.setImage(quantityImage);
        quantityImageView.toFront();
        
        name.setText(prod.getName());
        quantityTextField.setText(String.valueOf(quantity));
        price.setText(String.valueOf(prod.getPrice()));
        this.totalCost.setText(String.valueOf(prod.getPrice()*quantity));
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
    }
    
    public void removeItem(){
        shoppingCart.removeCartItem(this, prodAsShopItem);
    }
    
    public Product getProduct() {
        return prod;
    }
<<<<<<< HEAD
    
    public String getQuantity(){
        return cartItemAmountField.getText();
    }
    
    public void increaseQuantity(double quantity){
        double newQuantity = Double.valueOf(getQuantity()) + quantity;
        cartItemAmountField.setText(String.valueOf(newQuantity));
        cartItemTotal.setText(String.valueOf(prod.getPrice()*newQuantity));
       
    }
}
=======
}
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
