package dokagg.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class CartItemController {
    
    @FXML private ImageView removeButton;
    @FXML private Image removeImage;
    @FXML private Text name;
    @FXML private TextField quantityTextField;
    @FXML private ImageView quantityImageView;
    @FXML private Image quantityImage;
    @FXML private Text price;
    @FXML private Text totalCost;
    
    @FXML private ShoppingCartController shoppingCart;
    @FXML private Product prod;
    private ShoppingItem prodAsShopItem;
    
    @FXML 
    public void giveData(ShoppingCartController shoppingCart, Product prod, double quantity, ShoppingItem prodAsShopItem) {
        this.shoppingCart = shoppingCart;
        this.prodAsShopItem = prodAsShopItem;
        this.prod = prod;

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
    }
    
    public void removeItem(){
        shoppingCart.removeCartItem(this, prodAsShopItem);
    }
    
    public Product getProduct() {
        return prod;
    }
}
